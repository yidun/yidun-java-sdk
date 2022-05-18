package com.netease.yidun.sdk.antispam.audio.query.v3.request;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.audio.query.v3.response.AudioQueryV3Response;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class AudioQueryV3Request extends BizPostFormRequest<AudioQueryV3Response> {
    private static final Gson GSON = new Gson();
    private Set<String> taskIds = new HashSet<>();

    public AudioQueryV3Request() {
        productCode = "audioCommon";
        uriPattern = "/v3/audio/query/task";
        version = "v3";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("taskIds", GSON.toJson(taskIds));
        return params;
    }

    @Override
    public Class<AudioQueryV3Response> getResponseClass() {
        return AudioQueryV3Response.class;
    }
}
