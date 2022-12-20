package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackV4Result;

/**
 * 直播音频主动回调实体
 */
public class LiveAudioV4ActiveCallbackRequest extends ActiveCallbackRequest {

    private static final long serialVersionUID = 5207764769336225179L;

    public LiveAudioCallbackV4Result parseCallbackData() {
        return parseCallbackData(LiveAudioCallbackV4Result.class);
    }

}
