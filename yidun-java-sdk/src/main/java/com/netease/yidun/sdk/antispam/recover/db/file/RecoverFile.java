package com.netease.yidun.sdk.antispam.recover.db.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import com.netease.yidun.sdk.antispam.recover.LifeCycle;
import com.netease.yidun.sdk.antispam.recover.RecoverConfig;
import com.netease.yidun.sdk.antispam.recover.exception.FileSizeLimitExceedException;
import com.netease.yidun.sdk.core.utils.FileKits;

import lombok.extern.slf4j.Slf4j;

/**
 * 恢复文件
 *
 * <pre>
 *  这里有个问题是，数据恢复的粒度是一个文件，恢复数据读取一半，数据恢复一半的时候重启了应用，下次会重新读取了文件。
 *  目前是要求使用者使用该工具的时候，恢复处理需要做去重处理。
 *  后期可以在文件读取的时候写入控制信息到另外一个文件，比如:{offset:1000},表示恢复到了1000条记录。下次重启恢复的时候忽略前1000条记录
 * </pre>
 *
 * @author hzleishaobo
 * @version 2017年9月6日
 */
@Slf4j
public class RecoverFile implements LifeCycle {

    private File file;

    private RecoverFileHandler recoverFileHandler;
    /** 写锁 */
    private Object writeLock = new Object();

    private final AtomicBoolean fileSizeLimitExceed = new AtomicBoolean(false);

    private final RecoverConfig recoverConfig;

    private final AtomicLong lastCheckFileSizeTime = new AtomicLong(0);

    private static final long HALF_SECOND_IN_NANO = TimeUnit.MICROSECONDS.toNanos(500);

    public RecoverFile(File file, RecoverFileHandler recoverFileHandler, RecoverConfig recoverConfig) {
        // 确保文件夹存在
        if (fileError(file)) {
            throw new IllegalArgumentException(
                    "Invalid db file " + file + ", cause: Failed to create directory " + file.getParentFile() + "!");
        }
        this.file = file;
        this.recoverFileHandler = recoverFileHandler;
        this.recoverConfig = recoverConfig;
        if (recoverConfig.fileSizeLimitEnable()) {
            // init
            updateIfExceedFileSizeLimit();
        }
    }

    private boolean fileError(File file) {
        return !file.exists() && file.getParentFile() != null && !file.getParentFile().exists()
                && !file.getParentFile().mkdirs();
    }

    public RecoverFileHandler getRecoverFileHandler() {
        return recoverFileHandler;
    }

    public Object getWriteLock() {
        return writeLock;
    }

    /**
     * 以追加的方式把字符串写到文件中，每个字符串一行
     *
     * @param datas
     */
    public void write(String... datas) {
        if (datas == null || datas.length == 0) {
            return;
        }
        try {
            if (recoverConfig.fileSizeLimitEnable()) {
                while (isFileSizeLimitExceed()) {
                    log.warn("file[{}] exceeded size limit[{}], sleep 2s", file.getName(), recoverConfig.getRecoverFileSizeLimitInByte());
                    Thread.sleep(2000);
                    updateIfExceedFileSizeLimit();
                }
            }
            File lockFile = new File(file.getAbsolutePath() + ".lock");
            if (!lockFile.exists()) {
                lockFile.createNewFile();
            }
            // 排它锁，只允许获取到锁的进程进行读写
            try (RandomAccessFile raf = new RandomAccessFile(lockFile, "rw");
                    FileChannel channel = raf.getChannel();
                    FileLock lock = channel.lock()) {
                if (log.isDebugEnabled()) {
                    log.debug("lock file success {}, isValid:{}", lockFile.getAbsolutePath(), lock.isValid());
                }
                channel.truncate(0);
                channel.write(ByteBuffer.wrap((recoverConfig.getLocalAddress() + "_" + System.currentTimeMillis())
                        .getBytes(StandardCharsets.UTF_8)));
                synchronized (writeLock) {
                    // 防止jvm内部的写竞争
                    append(datas);
                }
            }

        } catch (Throwable e) {
            // 写入失败，只能ignore
            log.error("append file [{}] unexpected error, cause: {}", file.getAbsolutePath(), e.getMessage(), e);
            log.error("append failed data: " + Arrays.toString(datas));
        }
    }

    private void append(String[] datas) throws IOException {
        FileKits.append(datas, file);
        if (recoverConfig.fileSizeLimitEnable()) {
            updateIfExceedFileSizeLimit();
        }
    }

    private void updateIfExceedFileSizeLimit() {
        fileSizeLimitExceed.set(file.length() >= recoverConfig.getRecoverFileSizeLimitInByte());
        lastCheckFileSizeTime.set(System.nanoTime());
    }

    public void checkFileSizeLimit() {
        if (!recoverConfig.fileSizeLimitEnable()) {
            return;
        }
        if (isFileSizeLimitExceed() && (System.nanoTime() - lastCheckFileSizeTime.get()) > HALF_SECOND_IN_NANO) {
            // if last file size checkTime elapse over 500ms, update again
            updateIfExceedFileSizeLimit();
        }
        if (isFileSizeLimitExceed()) {
            throw new FileSizeLimitExceedException(String.format("file[%s] exceeded size limit[%s]",
                    file.getName(), recoverConfig.getRecoverFileSizeLimitInByte()));
        }
    }

    private boolean isFileSizeLimitExceed() {
        return fileSizeLimitExceed.get();
    }

    public String getFilePath() {
        return file.getAbsolutePath();
    }

    @Override
    public void start() {
        //
    }

    @Override
    public void stop() {
        //
    }
}
