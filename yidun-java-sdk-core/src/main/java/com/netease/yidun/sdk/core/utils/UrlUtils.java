/*
 * @(#) UrlUtils.java 2021-06-09
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.netease.yidun.sdk.core.exception.YidunSdkException;

public class UrlUtils {

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new YidunSdkException("Fail to encode with utf8. str: " + str, e);
        }
    }

    public static String encode(Map<String, String> params) {
        StringBuilder result = new StringBuilder();

        boolean firstItem = true;
        for (Map.Entry<String, String> param : params.entrySet()) {
            String key = param.getKey();
            String value = param.getValue();

            if (StringUtils.isEmpty(key)) {
                continue;
            }

            if (firstItem) {
                firstItem = false;
            } else {
                result.append("&");
            }

            result.append(encode(key));

            if (StringUtils.isNotEmpty(value)) {
                result.append("=");
                result.append(encode(value));
            }
        }

        return result.toString();
    }
}
