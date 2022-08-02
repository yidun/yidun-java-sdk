package com.netease.yidun.sdk.antispam.recover.db;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.recover.RecoverConfig;
import com.netease.yidun.sdk.antispam.recover.RecoverRegistry;
import com.netease.yidun.sdk.antispam.recover.db.file.ErrorRecoverFile;
import com.netease.yidun.sdk.antispam.recover.db.file.RecoverFile;
import com.netease.yidun.sdk.core.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

/**
 * 默认数据存储的仓库实现
 *
 * @author hzleishaobo
 * @version 2017年9月6日
 * @param <T>
 */
@Slf4j
public class DefaultRecoverRepository<T> implements RecoverRepository<T> {

    private Gson gson = new Gson();

    private RecoverRepositoryReadHandler<T> recoverRepositoryReadHandler;

    private Class<T> entityClass;

    private RecoverFile recoverFile;
    private ErrorRecoverFile errorRecoverFile;

    public DefaultRecoverRepository(String dbName, Class<T> entityClass,
                                    RecoverRepositoryReadHandler<T> recoverRepositoryReadHandler,
                                    RecoverConfig recoverConfig) {
        this.entityClass = entityClass;
        if (StringUtils.isEmpty(dbName)) {
            dbName = this.entityClass.getSimpleName();
        }
        this.recoverRepositoryReadHandler = recoverRepositoryReadHandler;

        this.errorRecoverFile = new ErrorRecoverFile(new File(recoverConfig.getRecoverErrorFilePath(dbName)), line -> {
            T data = gson.fromJson(line, DefaultRecoverRepository.this.entityClass);
            return DefaultRecoverRepository.this.recoverRepositoryReadHandler.tryRecover(data);
        }, recoverConfig);
        this.recoverFile = new RecoverFile(new File(recoverConfig.getRecoverFilePath(dbName)),
                line -> {
                    T data = gson.fromJson(line, DefaultRecoverRepository.this.entityClass);
                    boolean opRet = DefaultRecoverRepository.this.recoverRepositoryReadHandler.handleRecover(data);
                    if (!opRet && !recoverConfig.isRecoverFailAbortEnable()) {
                        // 追加写入到恢复文件中
                        errorRecoverFile.write(line);
                    }
                    return opRet;
                }, recoverConfig);
        RecoverRegistry.register(dbName, recoverFile, errorRecoverFile);

    }

    @Override
    public void store(final T data) {
        if (data == null) {
            return;
        }
        String strData = gson.toJson(data);
        this.recoverFile.write(strData);
    }

    @Override
    public void store(final Collection<T> datas) throws InterruptedException {
        if (datas == null || datas.isEmpty()) {
            return;
        }
        String[] strDatas = new String[datas.size()];
        int index = 0;
        for (Iterator<T> iterator = datas.iterator(); iterator.hasNext();) {
            T data = iterator.next();
            String strData = gson.toJson(data);
            strDatas[index++] = strData;
        }
        this.recoverFile.write(strDatas);
    }

    @Override
    public void checkFileSizeLimit() {
       this.recoverFile.checkFileSizeLimit();
    }

    @Override
    public void start() {
        this.recoverFile.start();
    }

    @Override
    public void stop() {
        this.recoverFile.stop();
    }

}
