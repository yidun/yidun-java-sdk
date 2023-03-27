package com.netease.yidun.sdk.auth.bankcard.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.validation.limitation.CheckIdCard;
import com.netease.yidun.sdk.core.validation.limitation.CheckName;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 银行卡认证请求
 */
public class BankCardCheckRequest extends BizPostFormRequest<BankCardResponse> {

    public BankCardCheckRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/bankcard/check";
        this.businessId = businessId;
    }

    /**
     * 银行卡号
     */
    @NotBlank(message = "银行卡号不能为空")
    private String bankCardNo;

    /**
     * 姓名
     */
    @CheckName
    private String name;

    /**
     * 身份证号码
     */
    @CheckIdCard
    private String idCardNo;

    /**
     * 手机号
     */
    private String phone;

    @Size(max = 64, message = "dataId长度不合法")
    private String dataId;

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public BankCardCheckRequest bankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankCardCheckRequest name(String name) {
        this.name = name;
        return this;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public BankCardCheckRequest idCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BankCardCheckRequest phone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public BankCardCheckRequest dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("name", name);
        params.put("idCardNo", idCardNo);
        params.put("bankCardNo", bankCardNo);
        params.put("dataId", dataId);
        params.put("phone", phone);
        return params;
    }

    @Override
    public Class<BankCardResponse> getResponseClass() {
        return BankCardResponse.class;
    }

    @Override
    public String toString() {
        return "BankCardCheckRequest(" +
                "super=" + super.toString() +
                ", bankCardNo=" + bankCardNo +
                ", name=" + name +
                ", idCardNo=" + idCardNo +
                ", phone=" + phone +
                ", dataId=" + dataId +
                ")";
    }
}
