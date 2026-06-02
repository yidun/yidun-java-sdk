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
public class VideoDiscernItemBo implements Serializable {
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
    /**
     * 识别标识
     */
    private String discernKey;
    /**
     * 位置信息（仅在旗帜识别type=15时返回）
     */
    private LocationInformation locationInformation;

    @Data
    public static class LocationInformation implements Serializable {
        private static final long serialVersionUID = -3764711982403460001L;
        /** 左上角X坐标 */
        private Float x1;
        /** 左上角Y坐标 */
        private Float y1;
        /** 右下角X坐标 */
        private Float x2;
        /** 右下角Y坐标 */
        private Float y2;
    }
}
