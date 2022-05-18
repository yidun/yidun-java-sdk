package com.netease.yidun.sdk.antispam.livevideosolution.feedback.v1.request;

import java.util.List;

import lombok.Data;

@Data
public class LiveWallSolutionFeedback {
    /**
     * 直播UUID
     */
    private String taskId;

    /**
     * 观看人数,-1或者null代表不更新
     */
    private Integer viewCount;

    /**
     * 礼物数，-1或者null代表不更新
     */
    private Integer giftCount;

    /**
     * 弹幕数,-1或者null代表不更新
     */
    private Integer barrageCount;

    /**
     * 直播状态 100：直播结束 @see LiveVideoFeedBackStatusEnum
     */
    private Integer status;

    /**
     * 新增分数
     */
    private Integer addScore;

    /**
     * 直播标签, 优化乱序
     */
    private LiveTag liveTag;

    @Data
    public static class LiveTag {
        /**
         * 直播标签数组
         */
        private List<String> labels;
        /**
         * 直播标签更新时间
         */
        private long updateTime;
    }
}
