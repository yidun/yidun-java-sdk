package com.netease.yidun.sdk.mobileverify.oneclicklogin.v1;

import com.netease.yidun.sdk.core.response.CommonResponse;

public class MobileNumberGetResponse extends CommonResponse {
    /**
     * 操作结果信息
     */
    private MobileNumberResult data;

    public MobileNumberResult getData() {
        return data;
    }

    public void setData(MobileNumberResult data) {
        this.data = data;
    }

    public MobileNumberGetResponse(int code, String msg, MobileNumberResult data) {
        super(code, msg);
        this.data = data;
    }

    @Override
    public String toString() {
        return "MobileNumberGetResponse(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}
