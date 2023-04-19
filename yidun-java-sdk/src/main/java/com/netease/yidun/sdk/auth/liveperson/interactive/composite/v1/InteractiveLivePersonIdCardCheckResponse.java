package com.netease.yidun.sdk.auth.liveperson.interactive.composite.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 交互式活体人脸核身响应
 */
public class InteractiveLivePersonIdCardCheckResponse extends ResultResponse<InteractiveLivePersonIdCardCheckResult> {

    public InteractiveLivePersonIdCardCheckResponse(
            int code, String msg, InteractiveLivePersonIdCardCheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "InteractiveLivePersonIdCardCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
