/*
 * @(#) VideoCallbackOcrV4Response.java 2022-11-07
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author liangtingchen
 * @version 2022-11-07
 */
@Data
public class VideoCallbackAdV4Response {
    private String taskId;
    private String dataId;
    /**
     * 是否重复
     */
    private Boolean duplicateFlag;
    /**
     * 重复详情
     */
    private String duplicateDetail;
    /**
     * 截图
     */
    private List<VideoDataAdV4Response> pictures;

    @Data
    public static class VideoDataAdV4Response {
        private Long startTime;
        private Long endTime;
        private List<VideoAdItemBo> details;
        private String pictureId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class VideoAdItemBo implements Serializable {
        /**
         * 识别物体类型 1: 聊天截屏、2: 手机商品图、3: 诱导按键、4: 广告表情包、5: 图片弹窗、6: 重复图片
         */
        private Integer type;
        /**
         * 分数
         */
        private Float rate;
    }
}
