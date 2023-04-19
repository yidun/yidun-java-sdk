package com.netease.yidun.sdk.auth.liveperson.interactive.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 交互式活体检测响应
 */
public class InteractiveLivePersonCheckResponse extends ResultResponse<InteractiveLivePersonCheckResult> {

    public InteractiveLivePersonCheckResponse(int code, String msg, InteractiveLivePersonCheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "InteractiveLivePersonCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
