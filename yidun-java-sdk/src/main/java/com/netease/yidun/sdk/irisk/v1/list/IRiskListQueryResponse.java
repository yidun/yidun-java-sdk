package com.netease.yidun.sdk.irisk.v1.list;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * @author zhouyutong01
 * 名单查询-返回
 */
public class IRiskListQueryResponse  extends CommonResponse {
    private IRiskListQueryPageResponse data;

    public IRiskListQueryPageResponse getData() {
        return data;
    }

    public void setData(IRiskListQueryPageResponse data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IRiskListQueryResponse(" +
                "data=" + data +
                ')';
    }
}
