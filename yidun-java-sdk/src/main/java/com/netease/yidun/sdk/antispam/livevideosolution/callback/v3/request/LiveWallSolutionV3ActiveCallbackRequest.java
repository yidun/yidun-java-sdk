package com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response.LiveVideoSolutionCallbackV3Result;

/**
 * 直播音视频解决方案主动回调实体
 */
public class LiveWallSolutionV3ActiveCallbackRequest extends ActiveCallbackRequest {

    private static final long serialVersionUID = -6549474990441615563L;

    public LiveVideoSolutionCallbackV3Result parseCallbackData() {
        return parseCallbackData(LiveVideoSolutionCallbackV3Result.class);
    }

}
