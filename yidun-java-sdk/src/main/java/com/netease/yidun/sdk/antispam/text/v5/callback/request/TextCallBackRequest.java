package com.netease.yidun.sdk.antispam.text.v5.callback.request;

import com.netease.yidun.sdk.antispam.text.v5.callback.response.TextCallBackResponse;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 文本检测结果获取（轮询模式）
 */
public class TextCallBackRequest extends BizPostFormRequest<TextCallBackResponse> {

    public TextCallBackRequest() {
        productCode = "text-api";
        version = "v5.2";
        uriPattern = "/v5/text/callback/results";
    }

    @Override
    public Class<TextCallBackResponse> getResponseClass() {
        return TextCallBackResponse.class;
    }

    @Override
    public String toString() {
        return "TextCallBackRequest("
                + "super=" + super.toString()
                + ")";
    }
}
