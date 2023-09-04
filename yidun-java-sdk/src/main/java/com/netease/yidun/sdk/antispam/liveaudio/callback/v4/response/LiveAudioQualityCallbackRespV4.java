/*
 * @(#) LiveAudioLanguageUnit.java 2021-04-22
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maxiaofeng
 * @version 2021-04-22
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LiveAudioQualityCallbackRespV4 {
    /**
     * 音频uuid
     */
    private String taskId;
    private String dataId;
    private Long startTime;
    private Long endTime;
    private String callback;
    private String speakerId;
    private LiveAudioQualityDetails details;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LiveAudioQualityDetails {
        private Boolean silent;
    }

}
