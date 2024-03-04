package com.netease.yidun.sdk.irisk.v1.list;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * @author zhouyutong01
 * 名单添加-返回
 */
public class IRiskListAddResponse extends CommonResponse {
    public IRiskListAddResponse(int code, String msg) {
        super(code, msg);
    }

    @Override
    public String toString() {
        return "IRiskListAddResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
