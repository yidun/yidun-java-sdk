package com.netease.yidun.sdk.antispam.liveaudio.feedback.v1.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;
import java.util.List;
import lombok.Data;

@Data
public class LiveAudioFeedbackV1Resp extends CommonResponse {

    private List<LiveAudioFeedbackV1Result> result;

    @Data
    public static class LiveAudioFeedbackV1Result implements BaseResponse {
        /**
         * 提交taskId
         */
        private String taskId;
        /**
         * 提交状态 提交成功-0, 服务器异常-1, 数据不存在-2
         */
        private Integer result;
    }
}
