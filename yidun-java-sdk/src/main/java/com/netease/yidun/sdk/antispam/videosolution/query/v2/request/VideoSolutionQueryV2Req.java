/*
 * @(#) VideoSolutionQueryRequest.java 2020-06-22
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.videosolution.query.v2.request;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.videosolution.query.v2.response.VideoSolutionQueryV2Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * @author maxiaofeng
 * @version 2020-06-22
 */
@Data
public class VideoSolutionQueryV2Req extends PostFormRequest<VideoSolutionQueryV2Resp> {
    private static final Gson GSON = new Gson();

    private Set<String> taskIds;

    private Set<String> dataIds;

    public VideoSolutionQueryV2Req() {
        productCode = "videoSolutionCommon";
        uriPattern = "/v2/videosolution/query/task";
        version = "v2.1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        if (taskIds != null) {
            params.put("taskIds", GSON.toJson(taskIds));
        }
        if (dataIds != null) {
            params.put("dataIds", GSON.toJson(dataIds));
        }
        return params;
    }

    @Override
    public Class<VideoSolutionQueryV2Resp> getResponseClass() {
        return VideoSolutionQueryV2Resp.class;
    }
}
