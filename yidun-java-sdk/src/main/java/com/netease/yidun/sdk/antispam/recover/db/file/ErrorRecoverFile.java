package com.netease.yidun.sdk.antispam.recover.db.file;

import com.netease.yidun.sdk.antispam.recover.LifeCycle;
import com.netease.yidun.sdk.antispam.recover.RecoverConfig;
import com.netease.yidun.sdk.core.utils.FileKits;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 恢复异常文件
 * 本文件用于存储
 */
@Slf4j
public class ErrorRecoverFile implements LifeCycle {

    private File file;

    private RecoverFileHandler recoverFileHandler;
    /** 写锁 */
    private Object writeLock = new Object();

    private final RecoverConfig recoverConfig;

    public ErrorRecoverFile(File file, RecoverFileHandler recoverFileHandler, RecoverConfig recoverConfig) {
        // 确保文件夹存在
        if (fileError(file)) {
            throw new IllegalArgumentException(
                    "Invalid db file " + file + ", cause: Failed to create directory " + file.getParentFile() + "!");
        }
        this.file = file;
        this.recoverFileHandler = recoverFileHandler;
        this.recoverConfig = recoverConfig;
    }

    private boolean fileError(File file) {
        return !file.exists() && file.getParentFile() != null && !file.getParentFile().exists()
                && !file.getParentFile().mkdirs();
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
        // 应用内部通过writeLock控制
        synchronized (writeLock) {
            append(datas);
        }
    }

    public String getName() {
        return file.getName();
    }

    public long getLength() {
        return file.exists() ? file.length() : 0L;
    }

    private void append(String[] datas) {
        try {
            if (recoverConfig.fileSizeLimitEnable()) {
                FileKits.append(datas, file, recoverConfig.getRecoverFileSizeLimitInByte());
            } else {
                FileKits.append(datas, file);
            }
        } catch (Exception e) {
            // 写入失败，只能ignore
            log.error(e.getMessage(), e);
        }
    }

    public void recover() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileReader fr = new FileReader(file);
                 BufferedReader bf = new BufferedReader(fr)) {
                List<String> failed = recover(bf);
                synchronized (writeLock) {
                    // 清理之前先保证同时写的数据已经被读到
                    failed.addAll(recover(bf));
                    clearAndAppend(failed);
                }
            }
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }
    }

    private List<String> recover(BufferedReader bufferedReader) throws IOException {
        List<String> errorLines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            try {
                boolean ret = recoverFileHandler.handle(line);
                if (!ret) {
                    log.error("file:{}, 恢复失败，data: {}", file.getName(), line);
                    errorLines.add(line);
                }
            } catch (Exception e) {
                // 异常就跳过
                log.error("数据恢复发生异常 line：{}", line, e);
            }
        }
        return errorLines;
    }

    private void clearAndAppend(List<String> failed) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileKits.clear(file);
            FileKits.append(failed, file);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }
}
