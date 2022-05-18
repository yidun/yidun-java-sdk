/*
 * @(#) OrderedMd5Signer.java 2020-07-09
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.auth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.netease.yidun.sdk.core.exception.YidunSdkException;
import com.netease.yidun.sdk.core.utils.StringUtils;

/**
 * 请求签名生成器。默认使用MD5算法
 */
public class SignerImpl implements Signer {

    /**
     * 默认签名算法：MD5
     */
    public static final SignatureMethodEnum DEFAULT_SIGNATURE_METHOD = SignatureMethodEnum.MD5;

    public static final SignerImpl INSTANCE = new SignerImpl();

    private SignerImpl() {
    }

    @Override
    public SignResult genSignature(Credentials credentials, Map<String, String> params) {
        SignatureMethodEnum signatureMethod = determineSignatureMethod(params);
        String secretId = credentials.getSecretId();

        HashMap<String, String> target = new HashMap<>(params);
        target.put("secretId", secretId);

        String signature = genSignature(signatureMethod, credentials.getSecretKey(), target);

        return new SignResult(signatureMethod, secretId, signature);
    }

    private String genSignature(SignatureMethodEnum signatureMethod, String secretKey, Map<String, String> params) {
        // 1. 参数名按照ASCII码表升序排序
        String[] paramNames = params.keySet().toArray(new String[0]);
        Arrays.sort(paramNames);

        // 2. 按照排序拼接参数名与参数值
        StringBuilder paramBuffer = new StringBuilder();
        for (String paramName : paramNames) {
            String paramValue = params.get(paramName);
            paramBuffer
                    .append(paramName)
                    .append(paramValue == null ? "" : paramValue);
        }

        // 3. 将secretKey拼接到最后
        paramBuffer.append(secretKey);

        return signatureMethod.calcSign(paramBuffer.toString());
    }

    private static SignatureMethodEnum determineSignatureMethod(Map<String, String> params) {
        String strMethod = params.get("signatureMethod");

        if (StringUtils.isBlank(strMethod)) {
            return DEFAULT_SIGNATURE_METHOD;
        }

        try {
            return SignatureMethodEnum.valueOf(StringUtils.upperCase(strMethod));
        } catch (IllegalArgumentException e) {
            throw new YidunSdkException("Unsupported signatureMethod: " + strMethod, e);
        }
    }
}
