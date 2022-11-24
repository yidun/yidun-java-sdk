/*
 * @(#) VideoCallbackOcrV4Response.java 2022-11-07
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.video.callback.v4.response;


import lombok.Data;

import java.util.List;

/**
 * AI识图
 * @author yaoyi
 * @version 2022-11-07
 */
@Data
public class VideoCallbackDiscernV4Response {
    private String taskId;
    private String dataId;
    private List<VideoDataDiscernV4Response> pictures;
}
