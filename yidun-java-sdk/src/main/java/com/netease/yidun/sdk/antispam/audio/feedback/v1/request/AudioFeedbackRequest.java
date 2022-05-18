package com.netease.yidun.sdk.antispam.audio.feedback.v1.request;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.audio.feedback.v1.response.AudioFeedbackResponse;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class AudioFeedbackRequest extends BizPostFormRequest<AudioFeedbackResponse> {
    private List<AudioFeedback> feedbacks;
    private static final Gson GSON = new Gson();

    public AudioFeedbackRequest() {
        productCode = "audioCommon";
        uriPattern = "/v1/audio/feedback";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("feedbacks", GSON.toJson(feedbacks));
        return params;
    }

    @Override
    public Class<AudioFeedbackResponse> getResponseClass() {
        return AudioFeedbackResponse.class;
    }
}
