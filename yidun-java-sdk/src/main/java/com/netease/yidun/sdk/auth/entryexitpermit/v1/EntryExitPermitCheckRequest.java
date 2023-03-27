package com.netease.yidun.sdk.auth.entryexitpermit.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.validation.limitation.CheckName;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 出入境证件核验请求
 */
public class EntryExitPermitCheckRequest extends BizPostFormRequest<EntryExitPermitCheckResponse> {
    /**
     * 姓名
     */
    @CheckName
    private String name;
    /**
     * 证件号码
     */
    private String cardNo;
    /**
     * 证件类型
     */
    private int verifyType;
    /**
     * 国籍
     */
    private String nation;

    @Size(max = 64, message = "dataId长度不合法")
    private String dataId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntryExitPermitCheckRequest name(String name) {
        this.name = name;
        return this;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public EntryExitPermitCheckRequest cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public int getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(int verifyType) {
        this.verifyType = verifyType;
    }

    public EntryExitPermitCheckRequest verifyType(int verifyType) {
        this.verifyType = verifyType;
        return this;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public EntryExitPermitCheckRequest nation(String nation) {
        this.nation = nation;
        return this;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public EntryExitPermitCheckRequest dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public EntryExitPermitCheckRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/foreign/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.putAll(super.getCustomSignParams());
        params.put("name", name);
        params.put("cardNo", cardNo);
        params.put("verifyType", String.valueOf(verifyType));
        params.put("nation", nation);
        params.put("dataId", dataId);
        return params;
    }

    @Override
    public Class<EntryExitPermitCheckResponse> getResponseClass() {
        return EntryExitPermitCheckResponse.class;
    }

    @Override
    public String toString() {
        return "EntryExitPermitCheckRequest("
                + "super=" + super.toString()
                + ", name=" + name
                + ", cardNo=" + cardNo
                + ", verifyType=" + verifyType
                + ", nation=" + nation
                + ", dataId=" + dataId
                + ")";
    }
}
