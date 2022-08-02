package com.netease.yidun.sdk.antispam.recover.db;

/**
 * 失败仓库读处理器
 *
 * @author hzleishaobo
 * @version 2017年9月6日
 * @param <T>
 */
public interface RecoverRepositoryReadHandler<T> {
    /**
     * 读处理器
     *
     * @param data
     * @return
     */
    boolean handleRecover(T data);

    /**
     * no retry recover
     * @param data
     * @return
     */
    boolean tryRecover(T data);

}
