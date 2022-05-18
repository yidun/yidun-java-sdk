/*
 * @(#) ISigner.java 2020-07-08
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.auth;

import java.util.Map;

/**
 * 用于计算请求签名
 */
public interface Signer {

    /**
     * 计算签名
     * 
     * @param credentials 访问易盾服务的凭证
     * @param params 参与签名计算的参数。key:参数名; value:参数值
     * @return 签名结果
     */
    SignResult genSignature(Credentials credentials, Map<String, String> params);
}
