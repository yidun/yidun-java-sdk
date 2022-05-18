package com.netease.yidun.sdk.antispam.liveaudio.query.v1.request;

import java.util.Map;

import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQueryExtraV1Resp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class LiveAudioQueryExtraV1Req extends BizPostFormRequest<LiveAudioQueryExtraV1Resp> {

    private String taskId;
    private Long startTime;
    private Long endTime;

    public LiveAudioQueryExtraV1Req() {
        productCode = "liveAudio";
        uriPattern = "/v1/liveaudio/query/extra";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("taskId", getTaskId());
        params.put("startTime", getStartTime());
        params.put("endTime", getEndTime());
        return params;
    }

    @Override
    public Class<LiveAudioQueryExtraV1Resp> getResponseClass() {
        return LiveAudioQueryExtraV1Resp.class;
    }
}
