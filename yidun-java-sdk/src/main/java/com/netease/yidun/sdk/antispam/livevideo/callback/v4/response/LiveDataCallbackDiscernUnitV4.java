/*
 * @(#) VideoCallbackOcrUnitV4.java 2022-11-08
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import com.netease.yidun.sdk.antispam.video.callback.v4.response.LiveVideoDiscernItemBo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yaoyi
 * @version 2022-11-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiveDataCallbackDiscernUnitV4 {
    private String taskId;
    private String dataId;
    private String speakerId;
    private Long beginTime;
    private Long endTime;
    private List<LiveVideoDiscernItemBo> details;
}
