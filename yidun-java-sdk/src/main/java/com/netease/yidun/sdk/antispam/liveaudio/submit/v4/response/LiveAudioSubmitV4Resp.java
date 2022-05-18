package com.netease.yidun.sdk.antispam.liveaudio.submit.v4.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;
import lombok.Data;

@Data
public class LiveAudioSubmitV4Resp extends CommonResponse {

    private LiveAudioSubmitV4Result result;

    @Data
    public static class LiveAudioSubmitV4Result implements BaseResponse {
        /**
         * 提交taskId
         */
        private String taskId;
        /**
         * 提交状态
         */
        private Integer status;
    }
}
