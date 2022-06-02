

package com.netease.yidun.sdk.core.auth;

/**
 * 请求签名信息
 */
public class SignResult {

    /**
     * 签名算法
     */
    private final SignatureMethodEnum signMethod;
    /**
     * 访问易盾服务的凭证ID
     */
    private final String secretId;
    /**
     * 请求签名
     */
    private final String signature;

    public SignResult(SignatureMethodEnum signMethod, String secretId, String signature) {
        this.signMethod = signMethod;
        this.secretId = secretId;
        this.signature = signature;
    }

    public SignatureMethodEnum getSignMethod() {
        return signMethod;
    }

    public String getSecretId() {
        return secretId;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public String toString() {
        return "SignResult(" +
                "signMethod=" + signMethod +
                ", secretId=" + secretId +
                ", signature=" + signature +
                ")";
    }
}
