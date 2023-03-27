package com.netease.yidun.sdk.auth.liveperson.interactive.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 交互式活体检测请求
 */
public class InteractiveLivePersonCheckRequest extends BizPostFormRequest<InteractiveLivePersonCheckResponse> {

    public InteractiveLivePersonCheckRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/liveperson/recheck";
        this.businessId = businessId;
    }

    /**
     * 二次校验token，
     */
    @NotBlank(message = "token不能为空")
    private String token;

    /**
     * 是否需要返回正面照,默认不返照
     */
    private boolean needAvatar;

    /**
     * 照片类型 默认url
     */
    private PicType picType;

    @Size(max = 64, message = "dataId长度不合法")
    private String dataId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public InteractiveLivePersonCheckRequest token(String token) {
        this.token = token;
        return this;
    }

    public boolean isNeedAvatar() {
        return needAvatar;
    }

    public void setNeedAvatar(boolean needAvatar) {
        this.needAvatar = needAvatar;
    }

    public InteractiveLivePersonCheckRequest needAvatar(boolean needAvatar) {
        this.needAvatar = needAvatar;
        return this;
    }

    public PicType getPicType() {
        return picType;
    }

    public void setPicType(PicType picType) {
        this.picType = picType;
    }

    public InteractiveLivePersonCheckRequest picType(PicType picType) {
        this.picType = picType;
        return this;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public InteractiveLivePersonCheckRequest dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("token", token);
        params.put("needAvatar", String.valueOf(needAvatar));
        params.put("dataId", dataId);
        params.put("picType", String.valueOf(picType.getType()));
        return params;
    }

    @Override
    public Class<InteractiveLivePersonCheckResponse> getResponseClass() {
        return InteractiveLivePersonCheckResponse.class;
    }

    @Override
    public String toString() {
        return "InteractiveLivePersonCheckRequest(" +
                "super=" + super.toString() +
                ", token=" + token +
                ", needAvatar=" + needAvatar +
                ", picType=" + picType +
                ", dataId=" + dataId +
                ")";
    }
}
