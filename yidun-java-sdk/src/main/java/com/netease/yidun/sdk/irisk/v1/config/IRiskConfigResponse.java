package com.netease.yidun.sdk.irisk.v1.config;

import com.netease.yidun.sdk.core.response.CommonResponse;


public class IRiskConfigResponse extends CommonResponse {

    /**
     * 返回数据
     */
    private IRiskConfigResult data;


    public IRiskConfigResponse(int code, String msg, IRiskConfigResult data) {
        super(code, msg);
        this.data = data;
    }

    public IRiskConfigResult getData() {
        return data;
    }

    public void setData(IRiskConfigResult data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IRiskConfigResponse(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}