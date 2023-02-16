package com.netease.yidun.sdk.irisk.v1.detail;

import com.netease.yidun.sdk.core.response.CommonResponse;


public class IRiskDetailResponse extends CommonResponse {

    /**
     * 返回数据
     */
    private IRiskDetailResult data;

    public IRiskDetailResponse(int code, String msg, IRiskDetailResult data) {
        super(code, msg);
        this.data = data;
    }

    public IRiskDetailResult getData() {
        return data;
    }

    public void setData(IRiskDetailResult data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IRiskDetailResponse(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}