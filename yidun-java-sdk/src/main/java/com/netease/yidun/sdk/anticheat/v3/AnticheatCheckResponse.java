package com.netease.yidun.sdk.anticheat.v3;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 反作弊检测响应
 */
public class AnticheatCheckResponse extends ResultResponse<CheckResult> {

    public AnticheatCheckResponse(int code, String msg, CheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "AnticheatCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
