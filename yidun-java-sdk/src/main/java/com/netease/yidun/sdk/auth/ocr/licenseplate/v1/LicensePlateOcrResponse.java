package com.netease.yidun.sdk.auth.ocr.licenseplate.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 车牌OCR响应
 */
public class LicensePlateOcrResponse extends ResultResponse<LicensePlateOcrResult> {

    public LicensePlateOcrResponse(int code, String msg, LicensePlateOcrResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "LicensePlateOcrResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
