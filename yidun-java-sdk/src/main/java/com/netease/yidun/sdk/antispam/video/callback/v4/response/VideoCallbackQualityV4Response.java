/*
 * @(#) VideoCallbackQualityV4Response.java 2023-02-22
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import lombok.Data;

import java.util.List;

/**
 * @author yaoyi02
 * @version 2023-02-22
 */
@Data
public class VideoCallbackQualityV4Response {
    private String taskId;
    private String dataId;
    private List<VideoDataQualityV4Response> pictures;
}
