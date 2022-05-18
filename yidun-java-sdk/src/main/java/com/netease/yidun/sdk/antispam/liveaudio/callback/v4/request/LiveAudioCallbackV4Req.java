package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.request;

import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackV4Resp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import lombok.Data;

@Data
public class LiveAudioCallbackV4Req extends BizPostFormRequest<LiveAudioCallbackV4Resp> {

    public LiveAudioCallbackV4Req() {
        productCode = "liveAudio";
        uriPattern = "/v4/liveaudio/callback/results";
        version = "v4";
    }

    @Override
    public Class<LiveAudioCallbackV4Resp> getResponseClass() {
        return LiveAudioCallbackV4Resp.class;
    }
}
