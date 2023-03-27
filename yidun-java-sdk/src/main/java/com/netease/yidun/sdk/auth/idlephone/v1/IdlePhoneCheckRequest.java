package com.netease.yidun.sdk.auth.idlephone.v1;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Size;
import java.util.Map;

/**
 * 号码状态检测请求
 */
public class IdlePhoneCheckRequest extends BizPostFormRequest<IdlePhoneCheckResponse> {
    /**
     * 检测手机号
     */
    @NotNull(message = "phoneList不能为空")
    @Size(max = 50, message = "phoneList长度不合法")
    private String phoneList;

    /**
     * 手机号序列加密方式
     */
    @NotNull(message = "encryptType不能为空")
    @Size(max = 4, message = "encryptType长度不合法")
    private String encryptType;

    public String getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(String phoneList) {
        this.phoneList = phoneList;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public IdlePhoneCheckRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/idlephone/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("phoneList", phoneList);
        params.put("encryptType", encryptType);
        return params;
    }

    @Override
    public Class<IdlePhoneCheckResponse> getResponseClass() {
        return IdlePhoneCheckResponse.class;
    }

    @Override
    public String toString() {
        return "IdCardCheckRequest(" +
                "super=" + super.toString() +
                ", phoneList=" + phoneList +
                ", encryptType=" + encryptType +
                ")";
    }
}
