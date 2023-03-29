package com.netease.yidun.sdk.captcha.v2;

import com.netease.yidun.sdk.core.request.PostFormRequest;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.HashMap;
import java.util.Map;

/**
 * captcha verify request
 */
public class CaptchaVerifyRequest extends PostFormRequest<CaptchaVerifyResponse> {

    /**
     * 验证码id
     */
    @NotBlank
    @Size(max = 32, message = "验证码id最长32个字符")
    private String captchaId;
    /**
     * 提交二次校验的验证数据，即NECaptchaValidate值。只能校验成功一次，重复校验会返回校验不通过。有效时长默认20分钟，可在官网配置为1~20分钟
     */
    @NotBlank
    private String validate;
    /**
     * 用户信息，值可为空
     */
    private String user;

    @Override
    public Class<CaptchaVerifyResponse> getResponseClass() {
        return CaptchaVerifyResponse.class;
    }

    public String getCaptchaId() {
        return captchaId;
    }

    public void setCaptchaId(String captchaId) {
        this.captchaId = captchaId;
    }

    public String captchaId() {
        return captchaId;
    }

    public CaptchaVerifyRequest captchaId(String captchaId) {
        this.captchaId = captchaId;
        return this;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public String validate() {
        return validate;
    }

    public CaptchaVerifyRequest validate(String validate) {
        this.validate = validate;
        return this;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String user() {
        return user;
    }

    public CaptchaVerifyRequest user(String user) {
        this.user = user;
        return this;
    }

    /**
     * v2版本的二次校验接口,支持post请求
     */
    public CaptchaVerifyRequest() {
        productCode = "captcha";
        version = "v2";
        uriPattern = "/api/v2/verify";
    }

    public CaptchaVerifyRequest(String captchaId, String validate, String user) {
        productCode = "captcha";
        version = "v2";
        uriPattern = "/api/v2/verify";
        this.captchaId = captchaId;
        this.validate = validate;
        this.user = user;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = new HashMap<>();
        params.put("captchaId", captchaId);
        params.put("validate", validate);
        params.put("user", user);
        return params;
    }

    @Override
    public String toString() {
        return "CaptchaVerifyRequest("
                + "super=" + super.toString()
                + ", captchaId=" + captchaId
                + ", validate=" + validate
                + ", user=" + user
                + ")";
    }
}
