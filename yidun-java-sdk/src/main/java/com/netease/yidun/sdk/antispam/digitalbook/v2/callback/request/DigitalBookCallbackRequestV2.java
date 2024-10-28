package com.netease.yidun.sdk.antispam.digitalbook.v2.callback.request;

import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response.DigitalBookCallbackResponseV2;
import com.netease.yidun.sdk.core.request.PostFormRequest;

/**
 * 融媒体v2回调请求
 */
public class DigitalBookCallbackRequestV2 extends PostFormRequest<DigitalBookCallbackResponseV2> {

    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public DigitalBookCallbackRequestV2() {
        productCode = "digitalBook";
        uriPattern = "/v2/digital/callback/results";
        version = "v2";
    }

    @Override
    public Class<DigitalBookCallbackResponseV2> getResponseClass() {
        return DigitalBookCallbackResponseV2.class;
    }

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }
}
