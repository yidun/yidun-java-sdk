package com.netease.yidun.sdk.sms.v2;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 验证码检验请求
 */
public class OtpVerifyRequest extends BizPostFormRequest<OtpVerifyResponse> {

    @NotBlank(message = "requestId不能为空")
    private String requestId;

    @NotBlank(message = "code不能为空")
    @Size(max = 10, message = "code最长10个字符")
    private String code;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String requestId() {
        return requestId;
    }

    public OtpVerifyRequest requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }

    public OtpVerifyRequest code(String code) {
        this.code = code;
        return this;
    }

    public OtpVerifyRequest(String businessId, String requestId, String code) {
        productCode = "sms";
        version = "v2";
        uriPattern = "/v2/verifysms";
        this.businessId = businessId;
        this.requestId = requestId;
        this.code = code;
    }

    @Override
    public Class<OtpVerifyResponse> getResponseClass() {
        return OtpVerifyResponse.class;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("requestId", requestId);
        params.put("code", code);

        return params;
    }

    @Override
    public String toString() {
        return "OtpVerifyRequest("
                + "super=" + super.toString()
                + ", requestId=" + requestId
                + ", code=" + code
                + ")";
    }
}
