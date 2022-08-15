package com.netease.yidun.sdk.antispam.videosolution;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.videosolution.submit.v2.request.VideoSolutionSubmitV2Req;
import com.netease.yidun.sdk.antispam.videosolution.submit.v2.response.VideoSolutionSubmitV2Resp;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class VideoSolutionCheckClient extends AntispamClient {

    public VideoSolutionCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public VideoSolutionSubmitV2Resp check(VideoSolutionSubmitV2Req request) {
        return client.execute(request);
    }

    @Override
    protected String clientName() {
        return "VideoSolutionCheck";
    }
}
