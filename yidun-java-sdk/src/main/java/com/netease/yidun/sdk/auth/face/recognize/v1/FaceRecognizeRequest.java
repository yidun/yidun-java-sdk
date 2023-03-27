package com.netease.yidun.sdk.auth.face.recognize.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 人脸检索请求
 */
public class FaceRecognizeRequest extends BizPostFormRequest<FaceRecognizeResponse> {

    public FaceRecognizeRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/facerecognize/check";
        this.businessId = businessId;
    }

    /**
     * 图片类型 1-url 2-base64
     */
    @NotNull(message = "picType不能为空")
    private PicType picType;

    /**
     * 待检测照片
     */
    @NotBlank(message = "待检索照片不能为空")
    private String avatar;

    public PicType getPicType() {
        return picType;
    }

    public void setPicType(PicType picType) {
        this.picType = picType;
    }

    public FaceRecognizeRequest picType(PicType picType) {
        this.picType = picType;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public FaceRecognizeRequest avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("avatar", avatar);
        params.put("picType", String.valueOf(picType.getType()));
        return params;
    }

    @Override
    public Class<FaceRecognizeResponse> getResponseClass() {
        return FaceRecognizeResponse.class;
    }

    @Override
    public String toString() {
        return "FaceRegRequest(" +
                "super=" + super.toString() +
                ", picType=" + picType +
                ", avatar=" + avatar +
                ")";
    }
}
