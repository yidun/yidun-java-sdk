package com.netease.yidun.sdk.auth.entryexitpermit.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 出入境证件核验响应
 */
public class EntryExitPermitCheckResponse extends ResultResponse<EntryExitPermitCheckResult> {

    public EntryExitPermitCheckResponse(int code, String msg, EntryExitPermitCheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "EntryExitPermitCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
