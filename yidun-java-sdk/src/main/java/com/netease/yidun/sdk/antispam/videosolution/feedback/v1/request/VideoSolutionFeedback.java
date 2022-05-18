package com.netease.yidun.sdk.antispam.videosolution.feedback.v1.request;

import java.util.List;

import lombok.Data;

@Data
public class VideoSolutionFeedback {
    /**
     * 点播 taskId
     */
    private String taskId;

    /**
     * 标签
     */
    private List<String> tags;

    /**
     * 嫌疑类型
     */
    private Integer level;

    /**
     * 垃圾类型
     */
    private Integer label;
}
