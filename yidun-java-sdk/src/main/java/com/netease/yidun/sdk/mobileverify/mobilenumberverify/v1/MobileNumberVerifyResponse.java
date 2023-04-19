package com.netease.yidun.sdk.mobileverify.mobilenumberverify.v1;

import com.netease.yidun.sdk.core.response.CommonResponse;

public class MobileNumberVerifyResponse extends CommonResponse {
    /**
     * 操作结果信息
     */
    private MobileNumberVerifyResult data;

    public MobileNumberVerifyResult getData() {
        return data;
    }

    public void setData(MobileNumberVerifyResult data) {
        this.data = data;
    }

    public MobileNumberVerifyResponse(int code, String msg, MobileNumberVerifyResult data) {
        super(code, msg);
        this.data = data;
    }

    @Override
    public String toString() {
        return "MobileNumberVerifyResponse(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}
