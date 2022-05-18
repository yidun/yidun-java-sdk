package com.netease.yidun.sdk.antispam.videosolution.callback.v2.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class VideoSolutionCallbackV2Resp extends CommonResponse {
    private List<VideoSolutionCallbackV2Result> result;

}
