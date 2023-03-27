package com.netease.yidun.sdk.auth.ocr.idcard.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 身份证OCR请求
 */
public class IdCardOcrRequest extends BizPostFormRequest<IdCardOcrResponse> {

    /**
     * 身份证正面照
     */
    private String frontPicture;
    /**
     * 身份证反面照
     */
    private String backPicture;
    /**
     * 所传头像照片类型
     */
    @NotNull(message = "picType不能为空")
    private PicType picType;

    @Size(max = 64, message = "dataId长度不合法")
    private String dataId;

    public String getFrontPicture() {
        return frontPicture;
    }

    public void setFrontPicture(String frontPicture) {
        this.frontPicture = frontPicture;
    }

    public IdCardOcrRequest frontPicture(String frontPicture) {
        this.frontPicture = frontPicture;
        return this;
    }

    public String getBackPicture() {
        return backPicture;
    }

    public void setBackPicture(String backPicture) {
        this.backPicture = backPicture;
    }

    public IdCardOcrRequest backPicture(String backPicture) {
        this.backPicture = backPicture;
        return this;
    }

    public PicType getPicType() {
        return picType;
    }

    public void setPicType(PicType picType) {
        this.picType = picType;
    }

    public IdCardOcrRequest picType(PicType picType) {
        this.picType = picType;
        return this;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public IdCardOcrRequest dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public IdCardOcrRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/ocr/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("frontPicture", frontPicture);
        params.put("backPicture", backPicture);
        params.put("picType", String.valueOf(picType.getType()));
        params.put("dataId", dataId);
        return params;
    }

    @Override
    public Class<IdCardOcrResponse> getResponseClass() {
        return IdCardOcrResponse.class;
    }

    @Override
    public String toString() {
        return "IdCardOcrRequest(" +
                "super=" + super.toString() +
                ", frontPicture=" + frontPicture +
                ", backPicture=" + backPicture +
                ", picType=" + picType +
                ", dataId='" + dataId +
                ")";
    }

}
