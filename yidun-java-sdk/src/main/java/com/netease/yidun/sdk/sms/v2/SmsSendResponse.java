package com.netease.yidun.sdk.sms.v2;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 短信发送请求的响应
 */
public class SmsSendResponse extends CommonResponse {

    /**
     * 操作结果信息
     */
    private ResultInfo data;

    public ResultInfo getData() {
        return data;
    }

    public void setData(ResultInfo data) {
        this.data = data;
    }

    public SmsSendResponse(int code, String msg, ResultInfo data) {
        super(code, msg);
        this.data = data;
    }

    @Override
    public String toString() {
        return "SmsSendResponse(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}
