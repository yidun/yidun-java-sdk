/*
 * @(#) MethodType.java 2020-07-09
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.http;

public enum HttpMethodEnum {

    GET(false),
    POST(true);

    private boolean hasContent;

    HttpMethodEnum(boolean hasContent) {
        this.hasContent = hasContent;
    }

    public boolean hasContent() {
        return hasContent;
    }
}
