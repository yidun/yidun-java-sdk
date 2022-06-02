package com.netease.yidun.sdk.antispam.livevideosolution.barrage.v1.request;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.livevideosolution.barrage.v1.response.LiveWallSolutionBarrageV1Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class LiveWallSolutionBarrageV1Req extends PostFormRequest<LiveWallSolutionBarrageV1Resp> {
    private static final Gson GSON = new Gson();
    private List<LiveWallSolutionBarrage> barrages;

    public LiveWallSolutionBarrageV1Req() {
        productCode = "liveVideoSolutionCommon";
        uriPattern = "/v1/livewallsolution/barrage/push";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        if (barrages != null) {
            params.put("barrages", GSON.toJson(barrages));
        }
        return params;
    }

    @Override
    public Class<LiveWallSolutionBarrageV1Resp> getResponseClass() {
        return LiveWallSolutionBarrageV1Resp.class;
    }
}
