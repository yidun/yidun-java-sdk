/*
 * @(#) OrderedMd5Signer.java 2020-07-09
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.auth;

import java.util.Arrays;
import java.util.Map;

/**
 * 请求签名生成器。默认使用SHA1算法
 */
public class OpenApiSignerImpl implements Signer {

    /**
     * 默认签名算法：MD5
     */
    public static final SignatureMethodEnum DEFAULT_SIGNATURE_METHOD = SignatureMethodEnum.SHA1;

    public static final OpenApiSignerImpl INSTANCE = new OpenApiSignerImpl();

    private static final String TIMESTAMP = "timestamp";

    private static final String NONCE = "nonce";

    private OpenApiSignerImpl() {
    }

    @Override
    public SignResult genSignature(Credentials credentials, Map<String, String> params) {
        // 1. 参数名按照ASCII码表升序排序
        String[] paramNames = params.keySet().toArray(new String[0]);
        Arrays.sort(paramNames);

        String timestamp = "";
        String nonce = "";

        // 2. 按照排序拼接参数名与参数值
        StringBuilder paramBuffer = new StringBuilder();
        for (String paramName : paramNames) {
            String paramValue = params.get(paramName);
            if (TIMESTAMP.equals(paramName)) {
                timestamp = paramValue;
                continue;
            }
            if (NONCE.equals(paramName)) {
                nonce = paramValue;
                continue;
            }

            paramBuffer
                    .append(paramName)
                    .append(paramValue == null ? "" : paramValue);
        }

        // 3. 将secretKey，nonce，timestamp拼接到最后
        paramBuffer.append(credentials.getSecretKey()).append(nonce).append(timestamp);
        String signature = DEFAULT_SIGNATURE_METHOD.calcSign(paramBuffer.toString());

        return new SignResult(DEFAULT_SIGNATURE_METHOD, credentials.getSecretId(), signature);
    }

}
