package com.netease.yidun.sdk.antispam.liveaudio.query.v1.request;

import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQueryMonitorV1Resp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import java.util.Map;
import lombok.Data;

@Data
public class LiveAudioQueryMonitorV1Req extends BizPostFormRequest<LiveAudioQueryMonitorV1Resp> {

    private String taskId;

    public LiveAudioQueryMonitorV1Req() {
        productCode = "liveAudio";
        uriPattern = "/v1/liveaudio/query/monitor";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("taskId", getTaskId());
        return params;
    }

    @Override
    public Class<LiveAudioQueryMonitorV1Resp> getResponseClass() {
        return LiveAudioQueryMonitorV1Resp.class;
    }
}
