package com.netease.yidun.sdk.auth.mobilenumber.name.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.validation.limitation.CheckName;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 手机号与所有者姓名验证请求
 */
public class MobileNumberOwnerNameCheckRequest extends BizPostFormRequest<MobileNumberOwnerNameCheckResponse> {

    public MobileNumberOwnerNameCheckRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/mobile2Ele/check";
        this.businessId = businessId;
    }

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Size(min = 1, max = 32, message = "手机号长度不合法")
    private String phone;

    /**
     * 姓名
     */
    @CheckName
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MobileNumberOwnerNameCheckRequest name(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MobileNumberOwnerNameCheckRequest phone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("name", name);
        params.put("phone", phone);
        return params;
    }

    @Override
    public Class<MobileNumberOwnerNameCheckResponse> getResponseClass() {
        return MobileNumberOwnerNameCheckResponse.class;
    }

    @Override
    public String toString() {
        return "MobileNumberOwnerNameCheckRequest(" +
                "super=" + super.toString() +
                ", name=" + name +
                ", phone=" + phone +
                ")";
    }
}
