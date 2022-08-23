package com.netease.yidun.sdk.antispam.recover;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import com.netease.yidun.sdk.core.utils.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 恢复器包装类，集成了处理异常的能力和尝试恢复功能
 *
 * @author hzleishaobo
 * @version 2017年9月8日
 * @param <T>
 */
@Slf4j
public abstract class WrapRecover<T> implements Recover<T>, RecoverHandler<T> {

    private Recover<T> realRecover;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public WrapRecover(RecoverConfig recoverConfig, String dbName) {
        // 获得实体类
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        while (!(type instanceof ParameterizedType) && c != Object.class) {
            c = c.getSuperclass();
            type = c.getGenericSuperclass();
        }
        Type[] paramsType = ((ParameterizedType) type).getActualTypeArguments();
        this.entityClass = (Class<T>) paramsType[0];
        if (StringUtils.isEmpty(dbName)) {
            dbName = entityClass.getSimpleName();
        }
        // 初始化恢复器
        this.realRecover = new DefaultRecover<>(this, dbName, entityClass, recoverConfig);
    }

    @Override
    public void recover(Collection<T> datas) {
        this.realRecover.recover(datas);
    }

    @Override
    public void recover(T data) {
        this.realRecover.recover(data);
    }

    @Override
    public void start() {
        this.realRecover.start();
    }

    @Override
    public void stop() {
        this.realRecover.stop();
    }
}
