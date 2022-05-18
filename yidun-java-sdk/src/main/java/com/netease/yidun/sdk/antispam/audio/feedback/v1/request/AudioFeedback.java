package com.netease.yidun.sdk.antispam.audio.feedback.v1.request;

public class AudioFeedback {
    /**
     * 点播UUID
     */
    private String taskId;

    /**
     * 嫌疑类型 0-正常 2-异常
     */
    private Integer level;

    /**
     * 垃圾类型
     */
    private Integer label;

    public AudioFeedback() {
    }

    public AudioFeedback(String taskId, Integer level, Integer label) {
        this.taskId = taskId;
        this.level = level;
        this.label = label;
    }
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

}
