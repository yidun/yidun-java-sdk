package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LiveAudioLanguageCallbackRespV3 {
    private String taskId;
    private Long startTime;
    private Long endTime;
    private String content;
    private String callback;
    private String segmentId;
    private String speakerId;
}
