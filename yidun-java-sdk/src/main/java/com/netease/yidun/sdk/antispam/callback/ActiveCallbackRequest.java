package com.netease.yidun.sdk.antispam.callback;


import com.google.gson.Gson;
import com.netease.yidun.sdk.core.exception.YidunSdkException;
import com.netease.yidun.sdk.core.utils.StringUtils;

import java.io.Serializable;

/**
 * 主动回调的实体对象
 */
public class ActiveCallbackRequest implements Serializable {

    private static final Gson GSON = new Gson();

    /**
     * 密钥secretId
     */
    private String secretId;
    /**
     * 密钥businessId
     */
    private String businessId;
    /**
     * 业务场景
     */
    private String scene;
    /**
     * 数据签名
     */
    private String signature;
    /**
     * 签名方法
     */
    private String signatureMethod;
    /**
     * 回调数据
     */
    private String callbackData;

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignatureMethod() {
        return signatureMethod;
    }

    public void setSignatureMethod(String signatureMethod) {
        this.signatureMethod = signatureMethod;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }

    protected <T> T parseCallbackData(Class<T> clazz) {
        if (StringUtils.isBlank(getCallbackData())) {
            return null;
        }
        try {
            return GSON.fromJson(getCallbackData(), clazz);
        } catch (Exception e) {
            throw new YidunSdkException("parse callback data fails", e);
        }
    }
}