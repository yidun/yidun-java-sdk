package com.netease.yidun.sdk.antispam.recover;

import com.netease.yidun.sdk.core.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.function.Supplier;

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
    public WrapRecover(RecoverConfig recoverConfig) {
        // 获得实体类
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        while (!(type instanceof ParameterizedType) && c != Object.class) {
            c = c.getSuperclass();
            type = c.getGenericSuperclass();
        }
        Type[] paramsType = ((ParameterizedType) type).getActualTypeArguments();
        this.entityClass = (Class<T>) paramsType[0];
        String dbName = getDbName();
        if (StringUtils.isEmpty(dbName)) {
            dbName = entityClass.getSimpleName();
        }
        // 初始化恢复器
        this.realRecover = new DefaultRecover<>(this, dbName, entityClass, recoverConfig);
    }

    protected abstract String getDbName();

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

    public boolean extractFunction(Supplier<Boolean> supplier, T recoverRequest, String msg) {
        boolean result = false;
        try {
            result = supplier.get();
        } catch (Exception e) {
            recover(recoverRequest);
            log.error("extractFunction error, msg:{}, data:{}", msg, recoverRequest, e);
            return result;
        }
        // 针对未执行成功的方法进行恢复
        if (!result) {
            recover(recoverRequest);
            log.error("extractFunction no success, msg:{}, data:{}", msg, recoverRequest);
        }
        return result;
    }

}
