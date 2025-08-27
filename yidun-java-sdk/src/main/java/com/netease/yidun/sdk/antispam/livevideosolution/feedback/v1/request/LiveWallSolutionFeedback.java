package com.netease.yidun.sdk.antispam.livevideosolution.feedback.v1.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
     * 直播间收入
     */
    private Double liveIncome;

    /**
     * 弹幕数,-1或者null代表不更新
     */
    private Integer barrageCount;
    /**
     * 垃圾弹幕数
     */
    private Integer garbageBarrageCount;
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

    /**
     * 直播回放地址，支持针对已结束的直播进行回放
     */
    private String censorReplayUrl;
    /**
     * 在房间内的主播信息
     */
    private LivingSpeakerInfo livingSpeakerInfo;

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

    @Data
    public static class LivingSpeakerInfo {
        /**
         * 针对接入SDK监听客户，填入在房间内的所有说话人ID信息
         */
        private List<String> livingSpeakerIds;
        /**
         * 更新时间，用来解决乱序问题
         */
        private Long updateTime;
    }
}
