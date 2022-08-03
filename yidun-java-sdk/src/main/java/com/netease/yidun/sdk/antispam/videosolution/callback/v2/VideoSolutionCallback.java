
package com.netease.yidun.sdk.antispam.videosolution.callback.v2;

import java.util.List;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.request.VideoSolutionCallbackV2Req;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionCallbackV2Resp;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionCallbackV2Result;

public abstract class VideoSolutionCallback extends AbstractCallbackHandler<VideoSolutionCallbackV2Result> {

    public VideoSolutionCallback(CallbackProfile profile) {
        super(null, profile);
    }

    public VideoSolutionCallback(AntispamRequester requester) {
        super(requester);
    }

    public VideoSolutionCallback(AntispamRequester requester, CallbackProfile profile) {
        super(requester, profile);
    }

    @Override
    protected List<VideoSolutionCallbackV2Result> requestCallback(String businessId, String requestId) {
        VideoSolutionCallbackV2Req request = new VideoSolutionCallbackV2Req();
        request.setYidunRequestId(requestId);
        VideoSolutionCallbackV2Resp callbackResponse = antispamRequester.getVideoSolutionCommonClient()
                .callback(request);
        if (callbackResponse == null) {
            return null;
        }
        return callbackResponse.getResult();
    }

}
