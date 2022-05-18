package com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request;

import java.util.Map;

import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryMonitorV1Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class LiveWallSolutionQueryMonitorV1Req extends PostFormRequest<LiveWallSolutionQueryMonitorV1Resp> {

    private String taskId;

    public LiveWallSolutionQueryMonitorV1Req() {
        productCode = "liveVideoSolutionCommon";
        uriPattern = "/v1/livewallsolution/query/monitor";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("taskId", taskId);
        return params;
    }

    @Override
    public Class<LiveWallSolutionQueryMonitorV1Resp> getResponseClass() {
        return LiveWallSolutionQueryMonitorV1Resp.class;
    }
}
