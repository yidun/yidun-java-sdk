package com.netease.yidun.sdk.antispam.livevideo.callback.v4.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveCallbackUnitV4;

/**
 * 直播视频主动回调实体
 */
public class LiveVideoV4ActiveCallbackRequest extends ActiveCallbackRequest {

    private static final long serialVersionUID = -7051363647122322730L;

    public LiveCallbackUnitV4 parseCallbackData() {
        return parseCallbackData(LiveCallbackUnitV4.class);
    }

}
