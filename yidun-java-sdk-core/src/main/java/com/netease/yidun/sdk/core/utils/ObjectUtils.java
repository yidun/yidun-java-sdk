

package com.netease.yidun.sdk.core.utils;

public class ObjectUtils {

    public static <T> T defaultIfNull(final T object, final T defaultValue) {
        return object != null ? object : defaultValue;
    }
}
