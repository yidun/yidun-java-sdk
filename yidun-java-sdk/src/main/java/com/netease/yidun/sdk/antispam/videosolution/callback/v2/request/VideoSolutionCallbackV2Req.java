package com.netease.yidun.sdk.antispam.videosolution.callback.v2.request;

import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionCallbackV2Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;

import lombok.Data;

@Data
public class VideoSolutionCallbackV2Req extends PostFormRequest<VideoSolutionCallbackV2Resp> {

    public VideoSolutionCallbackV2Req() {
        productCode = "videoSolutionCommon";
        uriPattern = "/v2/videosolution/callback/results";
        version = "v2";
    }

    @Override
    public Class<VideoSolutionCallbackV2Resp> getResponseClass() {
        return VideoSolutionCallbackV2Resp.class;
    }
}
