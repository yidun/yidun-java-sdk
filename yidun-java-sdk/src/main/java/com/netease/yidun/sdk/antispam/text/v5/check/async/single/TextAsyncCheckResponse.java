package com.netease.yidun.sdk.antispam.text.v5.check.async.single;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 文本单次异步检测响应
 */
public class TextAsyncCheckResponse extends ResultResponse<TextAsyncCheckResult> {


    public TextAsyncCheckResponse(){
        super();
    }

    public TextAsyncCheckResponse(int code, String msg, TextAsyncCheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "TextAsyncCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
