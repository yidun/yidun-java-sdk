package com.netease.yidun.sdk.mobileverify.oneclicklogin.v1;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.Map;

public class MobileNumberGetRequest extends BizPostFormRequest<MobileNumberGetResponse> {

    /**
     * 号码认证易盾返回的token（长度为32位）
     */
    @Size(max = 32, message = "token最大长度32位")
    private String token;

    /**
     * 运营商预取号获取到的token，token都是一次性有效, 且2分钟后自动过期（三家运营商返回的token长度不一样，这里不做校验）
     */
    private String accessToken;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String token() {
        return token;
    }

    public MobileNumberGetRequest token(String token) {
        this.token = token;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String accessToken() {
        return accessToken;
    }

    public MobileNumberGetRequest accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public MobileNumberGetRequest(String businessId) {
        productCode = "mobileverify";
        version = "v1";
        uriPattern = "/v1/oneclick/check";
        this.businessId = businessId;
    }

    @Override
    public Class<MobileNumberGetResponse> getResponseClass() {
        return MobileNumberGetResponse.class;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("token", token);
        params.put("accessToken", accessToken);
        return params;
    }

    @Override
    public String toString() {
        return "MobileNumberGetRequest("
                + "super=" + super.toString()
                + ", token=" + token
                + ", accessToken='" + accessToken
                + ")";
    }
}
