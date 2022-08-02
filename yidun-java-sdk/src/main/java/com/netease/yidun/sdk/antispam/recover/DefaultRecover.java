package com.netease.yidun.sdk.antispam.recover;

import com.netease.yidun.sdk.antispam.recover.db.RecoverRepositoryReadHandler;
import com.netease.yidun.sdk.antispam.recover.db.asyn.DefaultRecoverAsyner;
import com.netease.yidun.sdk.antispam.recover.db.asyn.RecoverAsyner;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 恢复器默认实现
 *
 * @author hzleishaobo
 * @version 2017年9月6日
 * @param <T>
 */
@Slf4j
public class DefaultRecover<T> implements Recover<T>, RecoverRepositoryReadHandler<T> {

    /** 处理器 */
    private RecoverHandler<T> recoverHandler;
    /** 同步器-->延迟初始化吧 */
    private RecoverAsyner<T> recoverAsyner;
    /** 文件名 */
    private String dbName;
    /** 类名 */
    private Class<T> clazz;
    /** 延迟初始化吧 */
    private volatile boolean started = false;

    private Lock startLock = new ReentrantLock();
    /** 一分钟尝试恢复一次 */
    private RecoverConfig recoverConfig;

    public DefaultRecover(RecoverHandler<T> recoverHandler, String dbName, Class<T> clazz, RecoverConfig recoverConfig) {
        this.recoverConfig = recoverConfig;
        this.recoverHandler = recoverHandler;
        this.dbName = dbName;
        this.clazz = clazz;
        startLock.lock();
        try {
            if (!started) {
                this.recoverAsyner = new DefaultRecoverAsyner<>(dbName, clazz, this, recoverConfig);
                this.recoverAsyner.start();
                this.started = true;
            }
        } finally {
            startLock.unlock();
        }
    }

    @Override
    public void recover(T data) {
        if (!started) {
            start();
        }
        recoverAsyner.asyn(data);
    }

    @Override
    public void recover(Collection<T> datas) {
        if (!started) {
            start();
        }
        for (T data : datas) {
            recover(data);
        }
    }

    @Deprecated
    @Override
    public void start() {
        if (!started) {
            startLock.lock();
            try {
                if (!started) {
                    this.recoverAsyner = new DefaultRecoverAsyner<>(dbName, clazz, this, recoverConfig);
                    this.recoverAsyner.start();
                    this.started = true;
                }
            } finally {
                startLock.unlock();
            }
        }
    }

    @Override
    public void stop() {// 建议不要调用
        this.recoverAsyner.stop();
    }

    @Override
    public boolean handleRecover(T data) {
        // 直接恢复，恢复成功就直接返回
        if (tryRecover(data)) {
            return true;
        }
        // 捕获异常，异常则重试
        int count = 1;
        boolean opRet;
        do {
            log.warn("dbName:{}, 第 {} 次尝试恢复数据失败,暂停执行 {} s", dbName, count,
                    recoverConfig.getRecoverFailRetryIntervalInSec());
            try {
                TimeUnit.SECONDS.sleep(recoverConfig.getRecoverFailRetryIntervalInSec());
            } catch (InterruptedException e) {
                log.error("", e);
            }
            count++;
            opRet = tryRecover(data);
        } while (!opRet && count <= recoverConfig.getRecoverThreshold());
        if (!opRet) {
            // 数据恢复失败，很可能是脏数据，打印错误日志，要配置对应的哨兵集群告警
            log.error("dbName:{}, 恢复次数达到上限[{}]次仍失败, data: {}",
                    dbName, count, data);
        }
        log.info("dbName:{}, 第 {} 次尝试恢复数据, 最终执行结果:{} 继续恢复后续数据", dbName, count, opRet);
        return opRet;
    }

    @Override
    public boolean tryRecover(T data) {
        boolean recovered = false;
        try {
            recovered = this.recoverHandler.tryRecover(data);
        } catch (Exception e) {
            log.error("数据恢复失败", e);
        }
        return recovered;
    }

}
