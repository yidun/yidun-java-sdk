package com.netease.yidun.sdk.antispam.audio.callback.v4.request;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioCallbackV4Response;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

public class AudioCallbackV4Request extends BizPostFormRequest<AudioCallbackV4Response> {

    public AudioCallbackV4Request() {
        productCode = "audioCommon";
        uriPattern = "/v4/audio/callback/results";
        version = "v4";
    }

    @Override
    public Class<AudioCallbackV4Response> getResponseClass() {
        return AudioCallbackV4Response.class;
    }
}
