package com.netease.yidun.sdk.auth.ocr.licenseplate.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 车牌OCR请求
 */
public class LicensePlateOcrRequest extends BizPostFormRequest<LicensePlateOcrResponse> {

    @NotBlank(message = "图片不能为空")
    @Size(min = 1, max = 4194303, message = "图片长度不合法")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LicensePlateOcrRequest image(String image) {
        this.image = image;
        return this;
    }

    public LicensePlateOcrRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/ocr/license_plate";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("image", image);
        return params;
    }

    @Override
    public Class<LicensePlateOcrResponse> getResponseClass() {
        return LicensePlateOcrResponse.class;
    }

    @Override
    public String toString() {
        return "LicensePlateOcrRequest(" +
                "super=" + super.toString() +
                "image=" + image +
                ")";
    }
}
