package com.netease.yidun.sdk.antispam.recover.db.asyn;

import com.netease.yidun.sdk.antispam.recover.db.RecoverRepository;

import java.util.Collection;

/**
 * 异步存储处理
 *
 * @author hzleishaobo
 * @version 2017年9月6日
 * @param <T>
 */
public interface RecoverAsyner<T> extends RecoverRepository<T> {

    void asyn(T data);

    void asyn(Collection<T> datas);

}
