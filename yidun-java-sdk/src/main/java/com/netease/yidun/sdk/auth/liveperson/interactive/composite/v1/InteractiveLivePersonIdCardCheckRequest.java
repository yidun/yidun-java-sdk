package com.netease.yidun.sdk.auth.liveperson.interactive.composite.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.validation.limitation.CheckIdCard;
import com.netease.yidun.sdk.core.validation.limitation.CheckName;
import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 交互式活体人脸核身检测请求
 */
public class InteractiveLivePersonIdCardCheckRequest
        extends BizPostFormRequest<InteractiveLivePersonIdCardCheckResponse> {

    /**
     * 二次校验token，
     */
    @NotBlank(message = "token不能为空")
    private String token;

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
     * 是否需要返回正面照,默认不返照
     */
    private boolean needAvatar = false;

    /**
     * 照片类型 默认url
     */
    private PicType picType = PicType.URL;

    @Size(max = 64, message = "dataId长度不合法")
    private String dataId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public InteractiveLivePersonIdCardCheckRequest token(String token) {
        this.token = token;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InteractiveLivePersonIdCardCheckRequest name(String name) {
        this.name = name;
        return this;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public InteractiveLivePersonIdCardCheckRequest cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public boolean isNeedAvatar() {
        return needAvatar;
    }

    public void setNeedAvatar(boolean needAvatar) {
        this.needAvatar = needAvatar;
    }

    public InteractiveLivePersonIdCardCheckRequest needAvatar(boolean needAvatar) {
        this.needAvatar = needAvatar;
        return this;
    }

    public PicType getPicType() {
        return picType;
    }

    public void setPicType(PicType picType) {
        this.picType = picType;
    }

    public InteractiveLivePersonIdCardCheckRequest picType(PicType picType) {
        this.picType = picType;
        return this;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public InteractiveLivePersonIdCardCheckRequest dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public InteractiveLivePersonIdCardCheckRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/liveperson/audit";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("name", name);
        params.put("cardNo", cardNo);
        params.put("token", token);
        params.put("needAvatar", String.valueOf(needAvatar));
        params.put("dataId", dataId);
        params.put("picType", String.valueOf(picType.getType()));
        return params;
    }

    @Override
    public Class<InteractiveLivePersonIdCardCheckResponse> getResponseClass() {
        return InteractiveLivePersonIdCardCheckResponse.class;
    }

    @Override
    public String toString() {
        return "InteractiveLivePersonIdCardCheckRequest(" +
                "super=" + super.toString() +
                ", token=" + token +
                ", name=" + name +
                ", cardNo=" + cardNo +
                ", needAvatar=" + needAvatar +
                ", picType=" + picType +
                ", dataId=" + dataId +
                ')';
    }
}
