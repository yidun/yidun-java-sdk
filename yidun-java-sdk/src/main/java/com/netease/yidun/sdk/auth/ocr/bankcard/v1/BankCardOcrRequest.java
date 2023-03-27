
package com.netease.yidun.sdk.auth.ocr.bankcard.v1;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 银行卡OCR请求
 */
public class BankCardOcrRequest extends BizPostFormRequest<BankCardOcrResponse> {
    /**
     * 图像数据 4M之内
     */
    @NotBlank(message = "图片不能为空")
    @Size(min = 1, max = 4194303, message = "图片长度不合法")
    private String image;
    /**
     * 是否检测图像朝向,默认false不检测
     */
    private String detectDirection;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BankCardOcrRequest image(String image) {
        this.image = image;
        return this;
    }

    public String getDetectDirection() {
        return detectDirection;
    }

    public void setDetectDirection(String detectDirection) {
        this.detectDirection = detectDirection;
    }

    public BankCardOcrRequest detectDirection(String detectDirection) {
        this.detectDirection = detectDirection;
        return this;
    }

    public BankCardOcrRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/ocr/bankcard";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("image", image);
        params.put("detectDirection", detectDirection);
        return params;
    }

    @Override
    public Class<BankCardOcrResponse> getResponseClass() {
        return BankCardOcrResponse.class;
    }

    @Override
    public String toString() {
        return "BankCardOcrRequest("
                + "super=" + super.toString()
                + ", image=" + image
                + ", detectDirection=" + detectDirection
                + ")";
    }
}
