/*
 * @(#) VideoCallbackAigcV4Response.java 2025-04-23
 *
 * Copyright 2025 NetEase.com, Inc. All rights reserved.
 */
package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import lombok.Data;

import java.util.List;

@Data
public class VideoCallbackAigcV4Response {
    private String taskId;
    private String dataId;
    private List<VideoDataAigcV4Response> pictures;
}

