package com.netease.yidun.sdk.antispam.audio.feedback.v1.response;

import com.netease.yidun.sdk.core.response.CommonResponse;
import java.util.List;
import lombok.Data;

@Data
public class AudioFeedbackResponse extends CommonResponse {
    private List<AudioFeedbackUnitResp> result;
}
