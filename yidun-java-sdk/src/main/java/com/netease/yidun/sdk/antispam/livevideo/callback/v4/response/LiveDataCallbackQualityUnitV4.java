/*
 * @(#) LiveDataCallbackQualityUnitV4.java 2023-02-22
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaValueAddServiceResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yaoyi02
 * @version 2023-02-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiveDataCallbackQualityUnitV4 {
    private String taskId;
    private String dataId;
    private String speakerId;
    private Long beginTime;
    private Long endTime;
    private List<LiveDataQualityResp> details;
    private String pictureId;
}
