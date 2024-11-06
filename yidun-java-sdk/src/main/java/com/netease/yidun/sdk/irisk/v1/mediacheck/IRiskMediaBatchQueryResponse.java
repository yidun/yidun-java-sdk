package com.netease.yidun.sdk.irisk.v1.mediacheck;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;


/**
 * @author zhouyutong01
 * 图片检测-结果查询
 */
public class IRiskMediaBatchQueryResponse extends CommonResponse {

    private List<IRiskMediaQueryResult> data;

    public IRiskMediaBatchQueryResponse(int code, String msg, List<IRiskMediaQueryResult> data) {
        super(code, msg);
        this.data = data;
    }


    public List<IRiskMediaQueryResult> getData() {
        return data;
    }

    public void setData(List<IRiskMediaQueryResult> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IRiskMediaBatchQueryResponse(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}
