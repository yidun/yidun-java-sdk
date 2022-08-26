package com.netease.yidun.sdk.antispam.text.v5.check.async.batch;

import com.netease.yidun.sdk.antispam.text.v5.check.async.single.TextAsyncCheckResult;
import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 文本批量异步检测响应
 */
public class TextAsyncBatchCheckResponse extends ResultResponse<TextAsyncCheckResult> {

    public TextAsyncBatchCheckResponse(int code, String msg, TextAsyncCheckResult result) {
        super(code, msg, result);
    }

    public TextAsyncBatchCheckResponse(){
        super();
    }

    @Override
    public String toString() {
        return "TextAsyncBatchCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
