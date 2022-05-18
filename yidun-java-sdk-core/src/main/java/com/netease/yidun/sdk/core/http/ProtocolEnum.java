/*
 * @(#) ProtocolType.java 2020-07-09
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.http;

public enum ProtocolEnum {

    HTTP("http"),

    HTTPS("https");

    private final String protocol;

    ProtocolEnum(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public String toString() {
        return protocol;
    }
}
