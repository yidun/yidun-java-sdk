package com.netease.yidun.sdk.auth.face.compare.v1;

import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

/**
 * 人脸比对请求
 */
public class FaceCompareRequest extends BizPostFormRequest<FaceCompareResponse> {

    public FaceCompareRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/facecompare/check";
        this.businessId = businessId;
    }

    /**
     * 图片类型 1-url 2-base64
     */
    @NotNull(message = "picType不能为空")
    private PicType picType;

    /**
     * 人脸照1
     */
    @NotBlank(message = "人脸照1不能为空")
    private String avatar1;

    /**
     * 人脸照2
     */
    @NotBlank(message = "人脸照2不能为空")
    private String avatar2;

    /**
     * 数据标识，可传入用户标识等数据，便于数据查询
     */
    @Size(max = 64, message = "dataId长度不合法")
    private String dataId;

    public PicType getPicType() {
        return picType;
    }

    public void setPicType(PicType picType) {
        this.picType = picType;
    }

    public FaceCompareRequest picType(PicType picType) {
        this.picType = picType;
        return this;
    }

    public String getAvatar1() {
        return avatar1;
    }

    public void setAvatar1(String avatar1) {
        this.avatar1 = avatar1;
    }

    public FaceCompareRequest avatar1(String avatar1) {
        this.avatar1 = avatar1;
        return this;
    }

    public String getAvatar2() {
        return avatar2;
    }

    public void setAvatar2(String avatar2) {
        this.avatar2 = avatar2;
    }

    public FaceCompareRequest avatar2(String avatar2) {
        this.avatar2 = avatar2;
        return this;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("avatar1", avatar1);
        params.put("avatar2", avatar2);
        params.put("picType", String.valueOf(picType.getType()));
        return params;
    }

    @Override
    public Class<FaceCompareResponse> getResponseClass() {
        return FaceCompareResponse.class;
    }

    @Override
    public String toString() {
        return "FaceCompareRequest(" +
                "super=" + super.toString() +
                ", picType=" + picType +
                ", avatar1=" + avatar1 +
                ", avatar2=" + avatar2 +
                ", dataId=" + dataId +
                ")";
    }
}
