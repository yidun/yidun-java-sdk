package com.netease.yidun.sdk.antispam.liveaudio.feedback.v1.request;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.antispam.liveaudio.feedback.v1.response.LiveAudioFeedbackV1Resp;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class LiveAudioFeedbackV1Req extends BizPostFormRequest<LiveAudioFeedbackV1Resp> {
    private static final Gson GSON = new Gson();
    public static final int COMPLETE_CODE = 100;
    private List<LiveAudioFeedback> feedbacks;

    public LiveAudioFeedbackV1Req() {
        productCode = "liveAudio";
        uriPattern = "/v1/liveaudio/feedback";
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
    public Class<LiveAudioFeedbackV1Resp> getResponseClass() {
        return LiveAudioFeedbackV1Resp.class;
    }
}
