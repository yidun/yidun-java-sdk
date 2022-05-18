/*
 * @(#) RequestValidationUtils.java 2021-01-05
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.utils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * 方便字段校验。基于 javax validation-api，需在 classpath 中提供 ValidationProvider（如 hibernate-validator）
 */
public class ValidationUtils {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 校验各字段是否合法。如果存在非法字段值，则抛出异常 {@link IllegalArgumentException}。
     *
     * @param object 检验对象。需通过 javax validation-api 相关注解声明被校验字段的规格
     * @throws IllegalArgumentException 存在非法字段值
     */
    public static <T> void validate(T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);

        if (violations.isEmpty()) {
            return;
        }

        String msg = violations.stream()
                .map(ConstraintViolation::getMessage)
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
                ValidationUtils.validate(object);
            } catch (IllegalArgumentException e) {
                // 忽略参数非法的异常
            }
        }
    }
}
