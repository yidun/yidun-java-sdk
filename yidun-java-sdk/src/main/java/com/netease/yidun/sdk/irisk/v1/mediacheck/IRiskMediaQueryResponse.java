package com.netease.yidun.sdk.irisk.v1.mediacheck;

import com.netease.yidun.sdk.core.response.CommonResponse;


/**
 * @author zhouyutong01
 * 图片检测-结果查询
 */
public class IRiskMediaQueryResponse extends CommonResponse {

    private IRiskMediaQueryResult data;

    public IRiskMediaQueryResponse(int code, String msg, IRiskMediaQueryResult data) {
        super(code, msg);
        this.data = data;
    }

    public IRiskMediaQueryResult getData() {
        return data;
    }

    public void setData(IRiskMediaQueryResult data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IRiskMediaQueryResponse(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}
