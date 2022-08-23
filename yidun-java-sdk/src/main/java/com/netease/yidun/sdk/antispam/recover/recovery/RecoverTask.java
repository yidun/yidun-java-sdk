/*
 * @(#) OfflineNodeRecoveryTask.java 2022-06-15
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.recover.recovery;

import static com.netease.yidun.sdk.antispam.recover.RecoverConfig.RECOVER_FILE_SUFFIX;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.lang.invoke.MethodHandles;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netease.yidun.sdk.antispam.recover.RecoverConfig;
import com.netease.yidun.sdk.antispam.recover.RecoverRegistry;
import com.netease.yidun.sdk.antispam.recover.db.file.ErrorRecoverFile;
import com.netease.yidun.sdk.antispam.recover.db.file.RecoverFile;
import com.netease.yidun.sdk.antispam.recover.db.file.RecoverFileHandler;
import com.netease.yidun.sdk.core.utils.FileKits;
import com.netease.yidun.sdk.core.utils.NamedThreadFactory;

/**
 * @author ruicha
 * @version 2022-06-15
 */
public class RecoverTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String basePath;
    private final String clusterRecoveryLockFilePath;

    private final String localAddress;
    private final RecoverConfig recoverConfig;
    private final ExecutorService recoverExecutor;

    public RecoverTask(RecoverConfig recoverConfig) {
        this.recoverConfig = recoverConfig;
        this.basePath = recoverConfig.getBasePath();
        this.clusterRecoveryLockFilePath = recoverConfig.getRecoverLockFilePath();
        this.localAddress = recoverConfig.getLocalAddress();
        this.recoverExecutor = new ThreadPoolExecutor(recoverConfig.getClusterRecoverPoolSize(),
                recoverConfig.getClusterRecoverPoolSize(),
                60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024),
                new NamedThreadFactory("recover-worker", true));
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            File lockFile = new File(clusterRecoveryLockFilePath);
            if (!lockFile.exists()) {
                lockFile.createNewFile();
            }
            // 排它锁，只允许获取到锁的进程进行读写
            try (RandomAccessFile raf = new RandomAccessFile(lockFile, "rw");
                    FileChannel channel = raf.getChannel();
                    FileLock lock = channel.tryLock()) {
                if (lock == null) {
                    log.warn("Can not lock the file " + clusterRecoveryLockFilePath
                            + ", ignore and retry later, maybe other java process use the file");
                    return;
                }
                if (log.isDebugEnabled()) {
                    log.debug("lock file success {}, currentIp:{}", clusterRecoveryLockFilePath, recoverConfig.getLocalAddress());
                }
                channel.truncate(0);
                channel.write(ByteBuffer.wrap(
                        (localAddress + "_start_" + System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8)));

                dealRecoverFiles();
                dealErrorFiles();

                // 如果进程挂了，操作系统会释放lock文件锁
                channel.truncate(0);
                channel.write(ByteBuffer
                        .wrap((localAddress + "_end_" + System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8)));
            }
        } catch (Throwable e) {
            log.warn("OfflineRecoveryTask error, cause: " + e.getMessage(), e);
        }
        log.info("数据恢复逻辑结束，任务执行节点: {}, total cost: {}ms",
                recoverConfig.getLocalAddress(), System.currentTimeMillis() - start);
    }

    private void dealRecoverFiles() throws InterruptedException {
        List<File> recoverFileList = getRecoverFileList();
        if (recoverFileList.isEmpty()) {
            return;
        }
        // 并行增加效率
        CountDownLatch latch = new CountDownLatch(recoverFileList.size());
        for (File recover : recoverFileList) {
            if (!recover.exists() || recover.length() == 0) {
                // 如果文件为空就直接skip
                latch.countDown();
                continue;
            }
            recoverExecutor.execute(
                    () -> {
                        try {
                            long temp = System.currentTimeMillis();
                            if (log.isDebugEnabled()) {
                                log.debug("{} 恢复开始! 任务执行节点: {},", recover.getName(), recoverConfig.getLocalAddress());
                            }
                            handleRecover(recover);
                            log.info("{} 恢复结束！任务执行节点: {}, cost:{} ms", recover.getName(),
                                    recoverConfig.getLocalAddress(), System.currentTimeMillis() - temp);
                        } finally {
                            latch.countDown();
                        }
                    }
            );
        }
        latch.await();
    }

    private void dealErrorFiles() throws InterruptedException {
        if (RecoverRegistry.getErrorRecoverFileList().isEmpty()) {
            return;
        }
        CountDownLatch latch = new CountDownLatch(RecoverRegistry.getErrorRecoverFileList().size());
        for (ErrorRecoverFile errorRecoverFile : RecoverRegistry.getErrorRecoverFileList()) {
            if (errorRecoverFile.getLength() == 0) {
                // 如果文件为空就直接skip
                latch.countDown();
                continue;
            }
            recoverExecutor.execute(
                    () -> {
                        try {
                            long temp = System.currentTimeMillis();
                            errorRecoverFile.recover();
                            log.info("{} 恢复结束！任务执行节点: {}, cost:{} ms", errorRecoverFile.getName(),
                                    recoverConfig.getLocalAddress(), System.currentTimeMillis() - temp);
                        } finally {
                            latch.countDown();
                        }
                    }
            );
        }
        latch.await();
    }

    private void handleRecover(File recoverFile) {
        try {
            String dbName = parseDbName(recoverFile.getName());
            RecoverFileHandler recoverFileHandler = RecoverRegistry.lookupHandler(dbName);
            if (recoverFileHandler == null) {
                log.error("no recoverFileHandler found for recoverFile[{}], db: [{}]", recoverFile.getName(), dbName);
                // 只能打日志跳过了
                // 这种不算失败，但是对应的文件会保留
                return;
            }
            boolean fileRecoverDone = false;
            while (!fileRecoverDone) {
                // 文件读取异常或者文件已经清理到末尾，return true
                fileRecoverDone = recoverAndClean(recoverFile, recoverFileHandler, dbName);
            }
        } catch (Throwable e) {
            log.error("recover file [{}] unexpected error, cause: {}", recoverFile.getAbsolutePath(),
                    e.getMessage());
        }
    }

    /**
     *
     * @param recoverFile
     * @param recoverFileHandler
     * @return 是否结束对这个文件的恢复
     */
    private boolean recoverAndClean(File recoverFile, RecoverFileHandler recoverFileHandler,
                                    String dbName) throws IOException {

        int lastHandleLine = 0;
        boolean readFileError = false;
        long start = System.currentTimeMillis();
        try (FileReader fr = new FileReader(recoverFile);
             LineNumberReader lr = new LineNumberReader(fr)) {
            String line;
            // 每次读取指定行数来恢复
            while (((line = lr.readLine()) != null)
                    && lr.getLineNumber() <= recoverConfig.getRecoverLinesPerTime()) {
                try {
                    recoverFileHandler.handle(line);
                    lastHandleLine = lr.getLineNumber();
                } catch (Exception e) {
                    // 这里只可能是序列化异常，只能跳过了
                    log.error("数据恢复发生异常 line：{}", line, e);
                }
            }
        } catch (IOException e) {
            log.error("error when read recoverFile[{}], cause:{}", recoverFile.getAbsolutePath(), e.getMessage(),
                    e);
            readFileError = true;
        }
        if (readFileError || lastHandleLine == 0) {
            // 文件读取错误或者文件为空，直接跳过
            return true;
        }
        log.info("recover {} lines from {}, recoverCost: {}ms",
                lastHandleLine, recoverFile.getName(), System.currentTimeMillis() - start);

        // 如果读取文件是成功的，那么就说明进行了恢复逻辑，要走后面的清理逻辑
        start = System.currentTimeMillis();
        if (isLocalRecoverFile(recoverFile.getAbsolutePath(), dbName)) {
            // 如果是本节点的恢复文件，需要通过应用级别锁控制，文件锁控制不住，会直接抛异常，不好处理
            // 前面判空过，这里不会为Null
            RecoverFile localRecoverFile = RecoverRegistry.lookupFile(dbName);
            synchronized (localRecoverFile.getWriteLock()) {
                handleClean(recoverFile, lastHandleLine);
            }
        } else {
            File lockFile = new File(recoverFile.getAbsolutePath() + ".lock");
            if (!lockFile.exists()) {
                lockFile.createNewFile();
            }
            // 排它锁，只允许获取到锁的进程进行写操作
            try (RandomAccessFile raf = new RandomAccessFile(lockFile, "rw");
                 FileChannel channel = raf.getChannel();
                 FileLock lock = channel.lock()) {
                if (log.isDebugEnabled()) {
                    log.debug("lock file success {}, currentIp:{}", lockFile.getAbsolutePath(), recoverConfig.getLocalAddress());
                }
                channel.truncate(0);
                channel.write(ByteBuffer.wrap(
                        (localAddress + "_" + System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8)));
                handleClean(recoverFile, lastHandleLine);
            }
        }
        log.info("remove {} lines from {}, removeCost: {}ms",
                lastHandleLine, recoverFile.getName(), System.currentTimeMillis() - start);
        return false;
    }

    private boolean isLocalRecoverFile(String absolutePath, String dbName) {
        RecoverFile localRecoverFile = RecoverRegistry.lookupFile(dbName);
        return localRecoverFile != null && Objects.equals(absolutePath, localRecoverFile.getFilePath());
    }

    private void handleClean(File recoverFile, int lastHandleLine) throws IOException {
        // 说明对应文件中的数据还有数据未清理
        log.info("recover file {} success , remove {} lines from head", recoverFile.getAbsolutePath(),
                lastHandleLine);
        FileKits.removeLinesFromHead(recoverFile, lastHandleLine);
    }

    private String parseDbName(String recoverFileName) {
        if (recoverConfig.isIpIsolateEnable()) {
            return recoverFileName.substring(recoverFileName.indexOf("_") + 1,
                    recoverFileName.indexOf(RECOVER_FILE_SUFFIX));
        } else {
            return recoverFileName.substring(0, recoverFileName.indexOf(RECOVER_FILE_SUFFIX));
        }
    }

    private List<File> getRecoverFileList() {
        File[] files = new File(basePath).listFiles();
        if (files == null || files.length == 0) {
            return Collections.emptyList();
        }
        List<File> list = new ArrayList<>(files.length);
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(RECOVER_FILE_SUFFIX)) {
                list.add(file);
            }
        }
        return list;
    }

}
