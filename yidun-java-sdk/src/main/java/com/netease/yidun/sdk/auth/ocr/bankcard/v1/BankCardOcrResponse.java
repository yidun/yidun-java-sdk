
package com.netease.yidun.sdk.auth.ocr.bankcard.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 银行卡OCR响应
 */
public class BankCardOcrResponse extends ResultResponse<BankCardOcrResult> {

    public BankCardOcrResponse(int code, String msg, BankCardOcrResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "BankCardOcrResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
