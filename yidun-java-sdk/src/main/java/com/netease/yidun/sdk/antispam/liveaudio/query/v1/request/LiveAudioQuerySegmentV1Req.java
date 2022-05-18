package com.netease.yidun.sdk.antispam.liveaudio.query.v1.request;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQuerySegmentV1Resp;
import java.util.Map;
import lombok.Data;

@Data
public class LiveAudioQuerySegmentV1Req extends BizPostFormRequest<LiveAudioQuerySegmentV1Resp> {

    private String taskId;
    private Long startTime;
    private Long endTime;

    public LiveAudioQuerySegmentV1Req() {
        productCode = "liveAudio";
        uriPattern = "/v1/liveaudio/query/segment";
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
    public Class<LiveAudioQuerySegmentV1Resp> getResponseClass() {
        return LiveAudioQuerySegmentV1Resp.class;
    }
}
