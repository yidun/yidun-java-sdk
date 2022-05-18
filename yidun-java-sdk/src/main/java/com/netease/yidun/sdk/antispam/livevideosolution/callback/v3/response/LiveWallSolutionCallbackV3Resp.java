package com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class LiveWallSolutionCallbackV3Resp extends CommonResponse {
    private List<LiveVideoSolutionCallbackV3Result> result;




}
