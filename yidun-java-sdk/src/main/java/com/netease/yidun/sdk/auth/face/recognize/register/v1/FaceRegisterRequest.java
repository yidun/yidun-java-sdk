package com.netease.yidun.sdk.auth.face.recognize.register.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 人脸注册请求
 */
public class FaceRegisterRequest extends BizPostFormRequest<FaceRegisterResponse> {

    public FaceRegisterRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/facerecg/addFace";
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

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String name;

    /**
     * 唯一id
     */
    @NotBlank(message = "人脸ID不能为空")
    private String faceId;

    public PicType getPicType() {
        return picType;
    }

    public void setPicType(PicType picType) {
        this.picType = picType;
    }

    public FaceRegisterRequest picType(PicType picType) {
        this.picType = picType;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public FaceRegisterRequest avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FaceRegisterRequest name(String name) {
        this.name = name;
        return this;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public FaceRegisterRequest faceId(String faceId) {
        this.faceId = faceId;
        return this;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("avatar", avatar);
        params.put("picType", String.valueOf(picType.getType()));
        params.put("name", name);
        params.put("faceId", faceId);
        return params;
    }

    @Override
    public Class<FaceRegisterResponse> getResponseClass() {
        return FaceRegisterResponse.class;
    }

    @Override
    public String toString() {
        return "FaceRegisterRequest(" +
                "super=" + super.toString() +
                ", picType=" + picType +
                ", avatar=" + avatar +
                ", name=" + name +
                ", faceId=" + faceId +
                ")";
    }
}
