package com.netease.yidun.sdk.antispam.liveaudio.query.v1.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class LiveAudioQueryExtraV1Resp extends CommonResponse {
    private LiveAudioQueryExtraV1Result result;

    @Data
    public static class LiveAudioQueryExtraV1Result implements BaseResponse {
        /**
         * 语音识别
         */
        private List<LiveAudioQueryAsrResp> asr;
    }

    @Data
    public static class LiveAudioQueryAsrResp implements BaseResponse {
        private String taskId;
        private Long startTime;
        private Long endTime;
        private String content;
    }
}
