package com.netease.yidun.sdk.antispam.recover;

/**
 * 恢复处理器
 *
 * @author hzleishaobo
 * @version 2017年9月6日
 * @param <T>
 */
public interface RecoverHandler<T> {

    /**
     * 允许抛出异常，返回false或者抛出异常的情况下会重试
     * 
     * @param data
     */
    boolean tryRecover(T data);
}
