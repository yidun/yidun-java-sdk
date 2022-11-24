/*
 * @(#) VideoDataOcrV4Response.java 2022-11-07
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import lombok.Data;

import java.util.List;

/**
 * @author yaoyi
 * @version 2022-11-07
 */
@Data
public class VideoDataDiscernV4Response {
    private Long startTime;
    private Long endTime;
    private List<VideoDiscernItemBo> details;
}
