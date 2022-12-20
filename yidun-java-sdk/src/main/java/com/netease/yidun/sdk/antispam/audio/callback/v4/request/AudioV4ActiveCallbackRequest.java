package com.netease.yidun.sdk.antispam.audio.callback.v4.request;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioCallbackV4Result;
import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;

/**
 * 点播音频主动回调实体
 */
public class AudioV4ActiveCallbackRequest extends ActiveCallbackRequest {

    private static final long serialVersionUID = -984943537379613870L;

    public AudioCallbackV4Result parseCallbackData() {
        return parseCallbackData(AudioCallbackV4Result.class);
    }

}
