package com.netease.yidun.sdk.irisk.v6.detail;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * @author wuhanyu@corp.netease.com
 * @version 2024/2/2
 */
public class IRiskDetailV6Response extends CommonResponse {
    /**
     * 返回数据
     */
    private IRiskDetailV6Result data;

    public IRiskDetailV6Response(int code, String msg, IRiskDetailV6Result data) {
        super(code, msg);
        this.data = data;
    }

    public IRiskDetailV6Result getData() {
        return data;
    }

    public void setData(IRiskDetailV6Result data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IRiskDetailV6Response(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}
