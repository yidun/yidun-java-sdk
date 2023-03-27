package com.netease.yidun.sdk.auth.mobilenumber.idname.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.validation.limitation.CheckIdCard;
import com.netease.yidun.sdk.core.validation.limitation.CheckName;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 手机号与所有者身份证号及姓名验证请求
 */
public class MobileNumberOwnerIdNameCheckRequest extends BizPostFormRequest<MobileNumberOwnerIdNameCheckResponse> {

    public MobileNumberOwnerIdNameCheckRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/mobile/check";
        this.businessId = businessId;
    }

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Size(min = 1, max = 32, message = "手机号长度不合法")
    private String phone;

    /**
     * 用户身份证号码，支持15位和18位
     */
    @CheckIdCard
    private String cardNo;

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

    public MobileNumberOwnerIdNameCheckRequest name(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MobileNumberOwnerIdNameCheckRequest phone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public MobileNumberOwnerIdNameCheckRequest cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("name", name);
        params.put("phone", phone);
        params.put("cardNo", cardNo);
        return params;
    }

    @Override
    public Class<MobileNumberOwnerIdNameCheckResponse> getResponseClass() {
        return MobileNumberOwnerIdNameCheckResponse.class;
    }

    @Override
    public String toString() {
        return "MobileNumberOwnerIdNameCheckRequest(" +
                "super=" + super.toString() +
                ", name=" + name +
                ", phone=" + phone +
                ", cardNo=" + cardNo +
                ")";
    }
}
