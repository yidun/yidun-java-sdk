
package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LiveAudioVoiceCallbackRespV4 {
    /**
     * 音频uuid
     */
    private String taskId;
    private Long startTime;
    private Long endTime;
    private String dataId;
    /**
     * 年龄段类型
     */
    private String mainAgeGroup;
    private Double mainAgeGroupRate;

    private Integer underage;
    /**
     * 音频性别建议值，male/female
     */
    private String mainGender;
    private String callback;
    private String segmentId;
    private String speakerId;
    /**
     * 音频url
     */
    private String url;
}
