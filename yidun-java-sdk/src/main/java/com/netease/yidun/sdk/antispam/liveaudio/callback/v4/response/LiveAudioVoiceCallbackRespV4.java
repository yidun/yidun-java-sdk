
package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liangtingchen
 * @version 2022-07-14
 */
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
    /**
     * 年龄段类型
     */
    private String mainAgeGroup;
    private Double mainAgeGroupRate;
    private String callback;
    private String segmentId;
}
