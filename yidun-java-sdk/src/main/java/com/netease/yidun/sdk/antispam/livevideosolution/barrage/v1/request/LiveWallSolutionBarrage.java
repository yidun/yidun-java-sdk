package com.netease.yidun.sdk.antispam.livevideosolution.barrage.v1.request;

import java.util.List;

import lombok.Data;

@Data
public class LiveWallSolutionBarrage {
    /**
     * 弹幕id
     */
    private String id;
    /**
     * 直播UUID
     */
    private String taskId;
    /**
     * 直播UUID
     */
    private String dataId;
    /**
     * 弹幕发送时间
     */
    private Long publishTime;
    /**
     * 弹幕内容
     */
    private String content;
    /**
     * 高亮标签
     */
    private List<String> hint;
    /**
     * 0-正常 1-嫌疑 2-确定
     */
    private Integer level;

    private Integer spamType;
}
