package com.netease.yidun.sdk.antispam.videosolution.feedback.v1.request;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.videosolution.feedback.v1.response.VideoSolutionFeedbackV1Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class VideoSolutionFeedbackV1Req extends PostFormRequest<VideoSolutionFeedbackV1Resp> {
    private static final Gson GSON = new Gson();
    /**
     * 直播信息更新数据(Json数组，最多100条)
     */
    private List<VideoSolutionFeedback> feedbacks;

    public VideoSolutionFeedbackV1Req() {
        productCode = "videoSolutionCommon";
        uriPattern = "/v1/videosolution/feedback";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("feedbacks", GSON.toJson(feedbacks));
        return params;
    }

    @Override
    public Class<VideoSolutionFeedbackV1Resp> getResponseClass() {
        return VideoSolutionFeedbackV1Resp.class;
    }
}
