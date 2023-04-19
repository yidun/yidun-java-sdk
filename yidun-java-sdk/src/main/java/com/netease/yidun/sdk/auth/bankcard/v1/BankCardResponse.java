package com.netease.yidun.sdk.auth.bankcard.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 银行卡认证响应
 */
public class BankCardResponse extends ResultResponse<BankCardResult> {

    public BankCardResponse(int code, String msg, BankCardResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "BankCardResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
