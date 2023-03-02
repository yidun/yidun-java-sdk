package com.netease.yidun.sdk.auth.ocr.businesslicense.v1;

import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 营业执照OCR请求
 */
public class BusinessLicenseOcrRequest extends BizPostFormRequest<BusinessLicenseOcrResponse> {

    @NotBlank(message = "图片不能为空")
    @Size(min = 1, max = 4194303, message = "图片长度不合法")
    private String image;

    @Size(max = 10, message = "accuracy最长10个字符")
    private String accuracy;

    @Size(max = 10, message = "detectDirection最长10个字符")
    private String detectDirection;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BusinessLicenseOcrRequest image(String image) {
        this.image = image;
        return this;
    }

    public BusinessLicenseOcrRequest accuracy(String accuracy) {
        this.accuracy = accuracy;
        return this;
    }

    public BusinessLicenseOcrRequest detectDirection(String detectDirection) {
        this.detectDirection = detectDirection;
        return this;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getDetectDirection() {
        return detectDirection;
    }

    public void setDetectDirection(String detectDirection) {
        this.detectDirection = detectDirection;
    }

    public BusinessLicenseOcrRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/ocr/business_license";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("image", image);
        return params;
    }

    @Override
    public Class<BusinessLicenseOcrResponse> getResponseClass() {
        return BusinessLicenseOcrResponse.class;
    }

    @Override
    public String toString() {
        // image 是图片原始数据（base64编码），数据量较大，不适合在此处输出
        return "BusinessLicenseOcrRequest(" +
                "super=" + super.toString() +
                ")";
    }
}
