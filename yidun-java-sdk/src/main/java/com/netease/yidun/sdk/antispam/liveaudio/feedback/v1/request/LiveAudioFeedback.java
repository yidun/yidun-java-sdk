package com.netease.yidun.sdk.antispam.liveaudio.feedback.v1.request;

import java.util.List;
import lombok.Data;

@Data
public class LiveAudioFeedback {
    /**
     * 直播UUID
     */
    private String taskId;
    /**
     * 直播状态 100：直播结束
     */
    private Integer status;
    /**
     * 背景图
     */
    private String backgroundImage;
    /**
     * 观看人数
     */
    private Integer viewCount;
    /**
     * 弹幕数
     */
    private Integer barrageCount;
    /**
     * 垃圾弹幕数
     */
    private Integer garbageBarrageCount;
    /**
     * 举报数
     */
    private Integer reportCount;
    /**
     * 新增异常值
     */
    private Integer addScore;
    /**
     * 直播标签, 优化乱序
     */
    private LiveAudioTag liveTag;
    /**
     * 分数监控类型
     */
    private Integer scoreMonitorType;

    /**
     * 直播间收入
     */
    private Double liveIncome;

    @Data
    public static class LiveAudioTag {
        /**
         * 直播标签数组
         */
        private List<String> tag;
        /**
         * 直播标签更新时间
         */
        private long updateTime;
    }
}
