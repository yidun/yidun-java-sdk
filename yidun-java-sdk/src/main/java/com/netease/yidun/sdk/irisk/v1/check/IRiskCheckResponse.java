package com.netease.yidun.sdk.irisk.v1.check;

import com.netease.yidun.sdk.core.response.CommonResponse;


public class IRiskCheckResponse extends CommonResponse {

    private IRiskCheckResult data;

    public IRiskCheckResponse(int code, String msg, IRiskCheckResult data) {
        super(code, msg);
        this.data = data;
    }

    public IRiskCheckResult getData() {
        return data;
    }

    public void setData(IRiskCheckResult data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IRiskCheckResponse(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}
