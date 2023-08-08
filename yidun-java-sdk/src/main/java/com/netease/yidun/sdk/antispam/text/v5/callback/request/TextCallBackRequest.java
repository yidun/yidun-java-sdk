package com.netease.yidun.sdk.antispam.text.v5.callback.request;

import com.netease.yidun.sdk.antispam.text.v5.callback.response.TextCallBackResponse;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 文本检测结果获取（轮询模式）
 */
public class TextCallBackRequest extends BizPostFormRequest<TextCallBackResponse> {

    public TextCallBackRequest() {
        productCode = "text-api";
        version = "v5.3";
        uriPattern = "/v5/text/callback/results";
    }
    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
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
