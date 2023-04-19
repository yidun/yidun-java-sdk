package com.netease.yidun.sdk.sms.v2;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 验证码校验请求的响应
 */
public class OtpVerifyResponse extends CommonResponse {

    /**
     * 校验结果信息
     */
    private MatchInfo data;

    public MatchInfo getData() {
        return data;
    }

    public void setData(MatchInfo data) {
        this.data = data;
    }

    public OtpVerifyResponse(int code, String msg, MatchInfo data) {
        super(code, msg);
        this.data = data;
    }

    @Override
    public String toString() {
        return "OtpVerifyResponse(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}
