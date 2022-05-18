
package com.netease.yidun.sdk.core.utils;

import java.util.HashMap;

public class StringHashMap extends HashMap<String, String> {
    private static final long serialVersionUID = 1L;

    public String put(String key, Object value) {
        return this.put(key, toString(value));
    }

    @Override
    public String put(String key, String value) {
        return StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)
                ? super.put(key, value)
                : null;
    }

    private static String toString(Object value) {
        return value == null ? null : value.toString();
    }
}
