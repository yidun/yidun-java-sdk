package com.netease.yidun.sdk.auth.ocr.idcard.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 身份证OCR响应
 */
public class IdCardOcrResponse extends ResultResponse<IdCardOcrResult> {

    public IdCardOcrResponse(int code, String msg, IdCardOcrResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "IdCardOcrResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
