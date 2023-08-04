package com.netease.yidun.sdk.core.utils;

import com.google.gson.Gson;

public class GsonUtils {

    private static final Gson GSON = new Gson();

    public static String toJson(Object object) {
        if (object == null) {
            return null;
        }
        return GSON.toJson(object);
    }
}
