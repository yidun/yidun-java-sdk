/*
 * @(#) VideoDataQualityV4Response.java 2023-02-22
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaValueAddServiceResponse;
import lombok.Data;

import java.util.List;

/**
 * @author yaoyi02
 * @version 2023-02-22
 */
@Data
public class VideoDataQualityV4Response {
    private Long startTime;
    private Long endTime;
    private List<MediaValueAddServiceResponse.ImageQualityImageDetail> details;
}
