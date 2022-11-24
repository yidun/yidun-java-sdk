/*
 * @(#) AttackRecordApiController.java 2015年12月30日
 *
 * Copyright 2010 NetEase.com, Inc. All rights reserved.
 */
package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 图片命中日常场景信息
 *
 * @author yaoyi
 * @version 2019-01-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiveVideoDiscernItemBo implements Serializable {
    private static final long serialVersionUID = 4340424076688152703L;
    /**
     * 识别物体类型 1 场景
     */
    private Integer type;
    /**
     * 识别名称
     */
    private String discernName;
    /**
     * 分数
     */
    private Float rate;
}
