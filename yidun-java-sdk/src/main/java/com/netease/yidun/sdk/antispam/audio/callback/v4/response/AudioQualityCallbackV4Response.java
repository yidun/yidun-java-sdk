package com.netease.yidun.sdk.antispam.audio.callback.v4.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AudioQualityCallbackV4Response {
    private String taskId;
    private String dataId;
    private String callback;
    private List<AudioSilentCallbackUnitDetailResponse> silentSegments;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AudioSilentCallbackUnitDetailResponse {
        private Integer startTime;
        private Integer endTime;
        private Long startTimeMillis;
        private Long endTimeMillis;
    }
}
