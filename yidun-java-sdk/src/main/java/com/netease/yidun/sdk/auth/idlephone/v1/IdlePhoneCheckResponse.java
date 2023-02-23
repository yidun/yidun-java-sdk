package com.netease.yidun.sdk.auth.idlephone.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 号码状态检测校验响应
 */
public class IdlePhoneCheckResponse extends ResultResponse<IdlePhoneCheckResult> {

    public IdlePhoneCheckResponse(int code, String msg, IdlePhoneCheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "IdCardCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
