package com.netease.yidun.sdk.mobileverify.mobilenumberverify.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.validation.limitation.Size;

public class MobileNumberVerifyRequest extends BizPostFormRequest<MobileNumberVerifyResponse> {

    /**
     * 号码认证易盾返回的token（长度为32位）
     */
    @Size(max = 32, message = "token最大长度32位")
    private String token;

    /**
     * 运营商预取号获取到的token，token都是一次性有效, 且2分钟后自动过期（三家运营商返回的token长度不一样，这里不做校验）
     */
    private String accessToken;

    /**
     * 手机号
     */
    private String phone;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String token() {
        return token;
    }

    public MobileNumberVerifyRequest token(String token) {
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

    public MobileNumberVerifyRequest accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String phone() {
        return phone;
    }

    public MobileNumberVerifyRequest phone(String phone) {
        this.phone = phone;
        return this;
    }

    public MobileNumberVerifyRequest(String businessId) {
        productCode = "mobileverify";
        version = "v1";
        uriPattern = "/v1/check";
        this.businessId = businessId;
    }

    @Override
    public Class<MobileNumberVerifyResponse> getResponseClass() {
        return MobileNumberVerifyResponse.class;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("token", token);
        params.put("accessToken", accessToken);
        params.put("phone", phone);
        return params;
    }

    @Override
    public String toString() {
        return "MobileNumberVerifyRequest("
                + "super=" + super.toString()
                + ", token=" + token
                + ", accessToken=" + accessToken
                + ", phone=" + phone
                + ")";
    }
}
