package com.netease.yidun.sdk.antispam.liveaudio.barrage.v1.request;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.liveaudio.barrage.v1.response.LiveAudioBarrageV1Resp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class LiveAudioBarrageV1Req extends BizPostFormRequest<LiveAudioBarrageV1Resp> {
    private static final Gson GSON = new Gson();
    private List<LiveAudioBarrage> barrages;

    public LiveAudioBarrageV1Req() {
        productCode = "liveAudio";
        uriPattern = "/v1/liveaudio/barrage/push";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("barrages", GSON.toJson(barrages));
        return params;
    }

    @Override
    public Class<LiveAudioBarrageV1Resp> getResponseClass() {
        return LiveAudioBarrageV1Resp.class;
    }
}
