package com.netease.yidun.sdk.antispam.video.callback.v4.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackV4Result;

/**
 * 点播视频主动回调实体
 */
public class VideoV4ActiveCallbackRequest extends ActiveCallbackRequest {

    private static final long serialVersionUID = 8971566341587593405L;

    public VideoCallbackV4Result parseCallbackData() {
        return parseCallbackData(VideoCallbackV4Result.class);
    }

}
