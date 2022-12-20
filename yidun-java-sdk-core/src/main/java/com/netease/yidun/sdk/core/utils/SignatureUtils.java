package com.netease.yidun.sdk.core.utils;

import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.auth.SignerImpl;
import com.netease.yidun.sdk.core.exception.YidunSdkException;

import java.util.HashMap;
import java.util.Map;

public class SignatureUtils {

    public static final String PARAM_SIGN = "signature";
    public static final String PARAM_SECRET_ID = "secretId";

    private static String genSignature(String secretKey, Map<String, String> params) {
        String secretId = params.get(PARAM_SECRET_ID);
        if (StringUtils.isBlank(secretId)) {
            // 签名参数为空，直接返回空
            return "";
        }

        return SignerImpl.INSTANCE.genSignature(new Credentials(secretId, secretKey), params).getSignature();
    }

    /**
     * 验证签名是否匹配
     *
     * @param requestParams    签名的参数
     * @param secretKey 签名的key
     * @return 是否匹配
     * @throws YidunSdkException
     */
    public static boolean verifySignature(Map<String, String[]> requestParams, String secretKey) {
        if (StringUtils.isBlank(secretKey) || requestParams == null) {
            return false;
        }

        Map<String, String> params = new HashMap<>();
        String signature = null;
        for (String paramName : requestParams.keySet()) {
            String[] value = requestParams.get(paramName);
            if (value == null || value.length == 0) {
                continue;
            }

            if (PARAM_SIGN.equals(paramName)) {
                signature = value[0];
            } else {
                params.put(paramName, value[0]);
            }
        }
        if (StringUtils.isBlank(signature)) {
            // 签名为空，直接返回失败
            return false;
        }
        String generatedSignature = genSignature(secretKey, params);
        if (StringUtils.isBlank(generatedSignature)) {
            return false;
        }

        return signature.equals(generatedSignature);
    }
}
