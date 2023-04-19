package com.netease.yidun.sdk.auth.realperson.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 实人认证响应
 */
public class RpCheckResponse extends ResultResponse<RpCheckResult> {

    public RpCheckResponse(int code, String msg, RpCheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "RpCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
