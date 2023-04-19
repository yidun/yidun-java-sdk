package com.netease.yidun.sdk.auth.idcard.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 实证认证-实名校验响应
 */
public class IdCardCheckResponse extends ResultResponse<IdCardCheckResult> {

    public IdCardCheckResponse(int code, String msg, IdCardCheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "IdCardCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
