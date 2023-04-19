package com.netease.yidun.sdk.auth.ocr.businesslicense.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 营业执照OCR响应
 */
public class BusinessLicenseOcrResponse extends ResultResponse<BusinessLicenseOcrResult> {

    public BusinessLicenseOcrResponse(int code, String msg, BusinessLicenseOcrResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "BusinessLicenseOcrResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
