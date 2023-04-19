package com.netease.yidun.sdk.auth.mobilenumber.idname.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 手机号与所有者身份证号及姓名验证响应
 */
public class MobileNumberOwnerIdNameCheckResponse extends ResultResponse<MobileNumberOwnerIdNameCheckResult> {

    public MobileNumberOwnerIdNameCheckResponse(int code, String msg, MobileNumberOwnerIdNameCheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "MobileNumberOwnerIdNameCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
