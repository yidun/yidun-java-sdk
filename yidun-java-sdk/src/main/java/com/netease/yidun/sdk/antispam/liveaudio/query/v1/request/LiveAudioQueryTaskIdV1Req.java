package com.netease.yidun.sdk.antispam.liveaudio.query.v1.request;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQueryTaskIdV1Resp;
import java.util.Map;
import lombok.Data;

@Data
public class LiveAudioQueryTaskIdV1Req extends BizPostFormRequest<LiveAudioQueryTaskIdV1Resp> {

    private String taskId;
    private Long startTime;
    private Long endTime;

    public LiveAudioQueryTaskIdV1Req() {
        productCode = "liveAudio";
        uriPattern = "/v1/liveaudio/query/task";
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
    public Class<LiveAudioQueryTaskIdV1Resp> getResponseClass() {
        return LiveAudioQueryTaskIdV1Resp.class;
    }
}
