

package com.netease.yidun.sdk.core.utils;

import com.netease.yidun.sdk.core.validation.Validator;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 方便字段校验。
 */
public class ValidationUtils {

    /**
     * 校验各字段是否合法。如果存在非法字段值，则抛出异常 {@link IllegalArgumentException}。
     *
     * @param object 检验对象。
     * @throws IllegalArgumentException 存在非法字段值
     */
    public static <T> void validate(T object) {
        List<String> violations = Validator.validate(object);

        if (violations.isEmpty()) {
            return;
        }

        String msg = violations.stream()
                .collect(Collectors.joining(". "));
        throw new IllegalArgumentException(msg);
    }

    /**
     * 预热。避免首次正式校验耗时过高
     *
     * @param classes 待预热的类
     */
    public static void preheat(Collection<Class<?>> classes) {
        List<Object> requests = classes.stream()
                .map(clazz -> {
                    try {
                        return clazz.newInstance();
                    } catch (Exception e) {
                        // 忽略实例创建失败的异常
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        preheatByInstance(requests);
    }

    /**
     * 预热。避免首次正式校验耗时过高。此方法适用于没有无参构造方法的类
     *
     * @param objects 待预热的类的实例
     */
    public static void preheatByInstance(Collection<Object> objects) {
        for (Object object : objects) {
            try {
                validate(object);
            } catch (IllegalArgumentException e) {
                // 忽略参数非法的异常
            }
        }
    }
}
