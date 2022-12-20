package com.netease.yidun.sdk.antispam.videosolution.callback.v2.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionCallbackV2Result;

/**
 * 点播音视频解决方案主动回调实体
 */
public class VideoSolutionV2ActiveCallbackRequest extends ActiveCallbackRequest {

    private static final long serialVersionUID = -984953145622232435L;

    public VideoSolutionCallbackV2Result parseCallbackData() {
        return parseCallbackData(VideoSolutionCallbackV2Result.class);
    }

}
