package com.netease.yidun.sdk.auth.liveperson.video.composite.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 视频活体人脸核身响应
 */
public class VideoLivePersonIdCardCheckResponse extends ResultResponse<VideoLivePersonIdCardCheckResult> {

    public VideoLivePersonIdCardCheckResponse(int code, String msg, VideoLivePersonIdCardCheckResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "VideoLivePersonIdCardCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
