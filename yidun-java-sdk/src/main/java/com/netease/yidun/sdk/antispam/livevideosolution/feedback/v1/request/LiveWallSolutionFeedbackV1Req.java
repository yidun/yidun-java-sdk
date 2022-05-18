package com.netease.yidun.sdk.antispam.livevideosolution.feedback.v1.request;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.livevideosolution.feedback.v1.response.LiveWallSolutionFeedbackV1Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class LiveWallSolutionFeedbackV1Req extends PostFormRequest<LiveWallSolutionFeedbackV1Resp> {
    private static final Gson GSON = new Gson();
    private List<LiveWallSolutionFeedback> realTimeInfoList;

    public LiveWallSolutionFeedbackV1Req() {
        productCode = "liveVideoSolutionCommon";
        uriPattern = "/v1/livewallsolution/feedback";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("realTimeInfoList", GSON.toJson(realTimeInfoList));
        return params;
    }

    @Override
    public Class<LiveWallSolutionFeedbackV1Resp> getResponseClass() {
        return LiveWallSolutionFeedbackV1Resp.class;
    }
}
