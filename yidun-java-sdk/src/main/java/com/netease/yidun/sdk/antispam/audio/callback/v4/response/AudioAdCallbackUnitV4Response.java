/*
 * @(#) AudioAdCallbackUnitV4Response.java 2024-08-15
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.audio.callback.v4.response;

import lombok.Data;

/**
 * @author yaoyi02
 * @version 2024-08-15
 */
@Data
public class AudioAdCallbackUnitV4Response {
    /**
     * 任务id
     */
    private String taskId;
    /**
     * 数据id
     */
    private String dataId;
    /**
     * callback
     */
    private String callback;
    /**
     * 是否重复
     */
    private Boolean duplicateFlag;
    /**
     * 重复详情
     */
    private String duplicateDetail;
}
