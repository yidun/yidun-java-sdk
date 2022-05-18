/*
 * @(#) Credentials.java 2021-05-24
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.auth;

import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 访问易盾服务的凭证信息。可以登录易盾官网找到自己的凭证信息。请妥善保管，避免泄露。
 */
public class Credentials {

    private final String secretId;
    private final String secretKey;

    public Credentials(String secretId, String secretKey) {
        AssertUtils.notBlank(secretId, "secret id should not be blank");
        AssertUtils.notBlank(secretKey, "secret key should not be blank");
        this.secretId = secretId;
        this.secretKey = secretKey;
    }

    public String getSecretId() {
        return secretId;
    }

    public String secretId() {
        return secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String secretKey() {
        return secretKey;
    }
}
