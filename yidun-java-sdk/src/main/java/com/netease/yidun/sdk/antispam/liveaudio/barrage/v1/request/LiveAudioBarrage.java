package com.netease.yidun.sdk.antispam.liveaudio.barrage.v1.request;

import java.util.List;


public class LiveAudioBarrage {
    /**
     * 弹幕id
     */
    private String id;
    /**
     * 直播UUID
     */
    private String taskId;
    /**
     * 数据 id
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
    /**
     * 垃圾类型
     */
    private Integer spamType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getHint() {
        return hint;
    }

    public void setHint(List<String> hint) {
        this.hint = hint;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSpamType() {
        return spamType;
    }

    public void setSpamType(Integer spamType) {
        this.spamType = spamType;
    }
}
