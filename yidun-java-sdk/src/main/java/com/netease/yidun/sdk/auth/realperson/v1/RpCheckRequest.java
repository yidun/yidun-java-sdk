package com.netease.yidun.sdk.auth.realperson.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.validation.limitation.CheckIdCard;
import com.netease.yidun.sdk.core.validation.limitation.CheckName;
import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 实人认证请求
 */
public class RpCheckRequest extends BizPostFormRequest<RpCheckResponse> {

    /**
     * 用户真实姓名
     */
    @CheckName
    private String name;

    /**
     * 用户身份证号码，支持15位和18位
     */
    @CheckIdCard
    private String cardNo;

    /**
     * 所传头像照片类型
     */
    @NotNull(message = "picType不能为空")
    private PicType picType;

    /**
     * 用户头像，要求包含人脸
     */
    @NotBlank(message = "头像照不能为空")
    private String avatar;

    @Size(max = 64, message = "dataId长度不合法")
    private String dataId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RpCheckRequest name(String name) {
        this.name = name;
        return this;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public RpCheckRequest cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public PicType getPicType() {
        return picType;
    }

    public void setPicType(PicType picType) {
        this.picType = picType;
    }

    public RpCheckRequest picType(PicType picType) {
        this.picType = picType;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public RpCheckRequest avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public RpCheckRequest dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public RpCheckRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/rp/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("name", name);
        params.put("cardNo", cardNo);
        params.put("picType", String.valueOf(picType.getType()));
        params.put("avatar", avatar);
        params.put("dataId", dataId);
        return params;
    }

    @Override
    public Class<RpCheckResponse> getResponseClass() {
        return RpCheckResponse.class;
    }

    @Override
    public String toString() {
        return "RpCheckRequest(" +
                "super=" + super.toString() +
                ", name=" + name +
                ", cardNo=" + cardNo +
                ", picType=" + picType +
                ", avatar=" + avatar +
                ", dataId=" + dataId +
                ")";
    }
}
