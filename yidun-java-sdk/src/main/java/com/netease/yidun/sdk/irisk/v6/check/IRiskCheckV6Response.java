package com.netease.yidun.sdk.irisk.v6.check;

import com.netease.yidun.sdk.core.response.CommonResponse;


public class IRiskCheckV6Response extends CommonResponse {

    private IRiskCheckV6Result data;

    public IRiskCheckV6Response(int code, String msg, IRiskCheckV6Result data) {
        super(code, msg);
        this.data = data;
    }

    public IRiskCheckV6Result getData() {
        return data;
    }

    public void setData(IRiskCheckV6Result data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IRiskCheckV6Response(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}
