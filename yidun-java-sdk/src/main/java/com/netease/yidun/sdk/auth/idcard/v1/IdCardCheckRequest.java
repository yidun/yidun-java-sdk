package com.netease.yidun.sdk.auth.idcard.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.validation.limitation.CheckIdCard;
import com.netease.yidun.sdk.core.validation.limitation.CheckName;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 实证认证-实名校验请求
 */
public class IdCardCheckRequest extends BizPostFormRequest<IdCardCheckResponse> {
    /**
     * 姓名
     */
    @CheckName
    private String name;
    /**
     * 身份证号码
     */
    @CheckIdCard
    private String cardNo;

    @Size(max = 64, message = "dataId长度不合法")
    private String dataId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IdCardCheckRequest name(String name) {
        this.name = name;
        return this;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public IdCardCheckRequest cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public IdCardCheckRequest dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public IdCardCheckRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/idcard/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("name", name);
        params.put("cardNo", cardNo);
        params.put("dataId", dataId);
        return params;
    }

    @Override
    public Class<IdCardCheckResponse> getResponseClass() {
        return IdCardCheckResponse.class;
    }

    @Override
    public String toString() {
        return "IdCardCheckRequest(" +
                "super=" + super.toString() +
                ", name=" + name +
                ", cardNo=" + cardNo +
                ", dataId=" + dataId +
                ")";
    }
}
