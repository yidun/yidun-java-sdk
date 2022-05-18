package com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryV1Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class LiveWallSolutionQueryV1Req extends PostFormRequest<LiveWallSolutionQueryV1Resp> {
    private static final Gson GSON = new Gson();
    private List<String> taskIds;

    public LiveWallSolutionQueryV1Req() {
        productCode = "liveVideoSolutionCommon";
        uriPattern = "/v1/livewallsolution/query/task";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("taskIds", GSON.toJson(taskIds));
        return params;
    }

    @Override
    public Class<LiveWallSolutionQueryV1Resp> getResponseClass() {
        return LiveWallSolutionQueryV1Resp.class;
    }
}
