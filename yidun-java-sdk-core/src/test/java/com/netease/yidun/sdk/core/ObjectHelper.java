/*
 * @(#) FieldUtils.java 2021-06-10
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core;

import org.apache.commons.lang3.reflect.FieldUtils;

public class ObjectHelper {

    @SuppressWarnings("unchecked")
    public static <T> T getField(Object obj, String fieldName) {
        try {
            return (T) FieldUtils.readField(obj, fieldName, true);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
