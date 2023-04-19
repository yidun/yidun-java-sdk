package com.netease.yidun.sdk.auth.mobilenumber.name.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 手机号与所有者姓名验证响应
 */
public class MobileNumberOwnerNameCheckResponse extends ResultResponse<MobileNumberOwnerNameCheckResult> {

    public MobileNumberOwnerNameCheckResponse(int code, String msg, MobileNumberOwnerNameCheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "MobileNumberOwnerNameCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
