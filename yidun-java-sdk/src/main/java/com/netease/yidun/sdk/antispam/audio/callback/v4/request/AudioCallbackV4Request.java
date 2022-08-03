package com.netease.yidun.sdk.antispam.audio.callback.v4.request;

import java.util.Map;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioCallbackV4Response;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

public class AudioCallbackV4Request extends BizPostFormRequest<AudioCallbackV4Response> {
    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public AudioCallbackV4Request() {
        productCode = "audioCommon";
        uriPattern = "/v4/audio/callback/results";
        version = "v4";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        if (yidunRequestId != null) {
            params.put("yidunRequestId", getYidunRequestId());
        }
        return params;
    }

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }

    @Override
    public Class<AudioCallbackV4Response> getResponseClass() {
        return AudioCallbackV4Response.class;
    }

}
