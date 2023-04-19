package com.netease.yidun.sdk.auth.liveperson.video.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 视频活体检测响应
 */
public class VideoLivePersonCheckResponse extends ResultResponse<VideoLivePersonCheckResult> {

    public VideoLivePersonCheckResponse(int code, String msg, VideoLivePersonCheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "VideoLivePersonCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
