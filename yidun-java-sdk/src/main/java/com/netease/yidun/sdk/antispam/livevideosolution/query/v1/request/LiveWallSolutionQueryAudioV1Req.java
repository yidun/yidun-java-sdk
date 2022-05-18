package com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request;

import java.util.Map;

import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryAudioV1Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class LiveWallSolutionQueryAudioV1Req extends PostFormRequest<LiveWallSolutionQueryAudioV1Resp> {
    /**
     * taskId
     */
    private String taskId;

    /**
     * 起始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;

    public LiveWallSolutionQueryAudioV1Req() {
        productCode = "liveVideoSolutionCommon";
        uriPattern = "/v1/livewallsolution/query/audio/task";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("taskId", taskId);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        return params;
    }

    @Override
    public Class<LiveWallSolutionQueryAudioV1Resp> getResponseClass() {
        return LiveWallSolutionQueryAudioV1Resp.class;
    }
}
