package com.netease.yidun.sdk.antispam.media.v2.callback.request;

import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.core.request.PostFormRequest;

/**
 * 融媒体v2回调请求
 */
public class MediaCallbackRequestV2 extends PostFormRequest<MediaCallbackResponseV2> {


    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public MediaCallbackRequestV2() {
        productCode = "media";
        uriPattern = "/v2/mediasolution/callback/results";
        version = "v2";
    }

    @Override
    public Class<MediaCallbackResponseV2> getResponseClass() {
        return MediaCallbackResponseV2.class;
    }

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }
}
