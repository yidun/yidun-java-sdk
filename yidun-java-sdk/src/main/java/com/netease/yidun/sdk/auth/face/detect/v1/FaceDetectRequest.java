package com.netease.yidun.sdk.auth.face.detect.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 人脸检测请求
 */
public class FaceDetectRequest extends BizPostFormRequest<FaceDetectResponse> {

    public FaceDetectRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/facedetect/check";
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
    @NotBlank(message = "待检测照片不能为空")
    private String picImage;

    public PicType getPicType() {
        return picType;
    }

    public void setPicType(PicType picType) {
        this.picType = picType;
    }

    public FaceDetectRequest picType(PicType picType) {
        this.picType = picType;
        return this;
    }

    public String getPicImage() {
        return picImage;
    }

    public void setPicImage(String picImage) {
        this.picImage = picImage;
    }

    public FaceDetectRequest picImage(String picImage) {
        this.picImage = picImage;
        return this;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("picImage", picImage);
        params.put("picType", String.valueOf(picType.getType()));
        return params;
    }

    @Override
    public Class<FaceDetectResponse> getResponseClass() {
        return FaceDetectResponse.class;
    }

    @Override
    public String toString() {
        return "FaceDetectRequest(" +
                "super=" + super.toString() +
                ", picType=" + picType +
                ", picImage=" + picImage +
                ")";
    }
}
