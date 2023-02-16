package com.netease.yidun.sdk.irisk.v1.mediacheck;

import com.netease.yidun.sdk.core.response.CommonResponse;


public class IRiskMediaCheckResponse extends CommonResponse {

    private IRiskMediaCheckResult data;

    public IRiskMediaCheckResponse(int code, String msg, IRiskMediaCheckResult data) {
        super(code, msg);
        this.data = data;
    }

    public IRiskMediaCheckResult getData() {
        return data;
    }

    public void setData(IRiskMediaCheckResult data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IRiskMediaCheckResponse(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}
