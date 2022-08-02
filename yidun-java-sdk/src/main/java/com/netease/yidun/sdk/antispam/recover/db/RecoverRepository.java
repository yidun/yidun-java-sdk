package com.netease.yidun.sdk.antispam.recover.db;

import com.netease.yidun.sdk.antispam.recover.LifeCycle;

import java.util.Collection;

/**
 * 数据失败时恢复前数据存储的仓库
 *
 * @author hzleishaobo
 * @version 2017年9月6日
 * @param <T>
 */
public interface RecoverRepository<T> extends LifeCycle {

    /**
     * 存储数据
     *
     * @param data
     */
    void store(T data);

    /**
     * 批量存储数据
     *
     * @param datas
     */
    void store(Collection<T> datas) throws InterruptedException;


    /**
     * 如果设置的文件大小限制，此方法会校验文件大小是否超过限制，如果超过，则抛出 FileSizeLimitExceedException
     */
    void checkFileSizeLimit();
}
