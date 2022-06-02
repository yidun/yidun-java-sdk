package com.netease.yidun.sdk.antispam.videosolution.query.v1.request;

import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.response.VideoSolutionQueryV1Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class VideoSolutionQueryV1Req extends PostFormRequest<VideoSolutionQueryV1Resp> {
    private static final Gson GSON = new Gson();
    private Set<String> taskIds;

    public VideoSolutionQueryV1Req() {
        productCode = "videoSolutionCommon";
        uriPattern = "/v1/videosolution/query/task";
        version = "v1.1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        if (taskIds != null) {
            params.put("taskIds", GSON.toJson(taskIds));
        }
        return params;
    }

    @Override
    public Class<VideoSolutionQueryV1Resp> getResponseClass() {
        return VideoSolutionQueryV1Resp.class;
    }
}
