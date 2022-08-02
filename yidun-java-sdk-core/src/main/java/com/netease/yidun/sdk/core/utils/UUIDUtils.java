package com.netease.yidun.sdk.core.utils;

import java.util.UUID;

public class UUIDUtils {

    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
