package com.netease.yidun.sdk.auth.liveperson.video.v1;

/**
 * 视频活体检测结果
 */
public class VideoLivePersonCheckResult {

    private String taskId;

    /**
     * 图片类型：1-URL，2-BASE64
     */
    private Integer picType;

    /**
     * 头像正面照
     */
    private String avatar;

    /**
     * 活体检测结果
     */
    private Integer lpCheckStatus;

    /**
     * 结果对应的原因
     */
    private Integer reasonType;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getPicType() {
        return picType;
    }

    public void setPicType(Integer picType) {
        this.picType = picType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getLpCheckStatus() {
        return lpCheckStatus;
    }

    public void setLpCheckStatus(Integer lpCheckStatus) {
        this.lpCheckStatus = lpCheckStatus;
    }

    public Integer getReasonType() {
        return reasonType;
    }

    public void setReasonType(Integer reasonType) {
        this.reasonType = reasonType;
    }

    @Override
    public String toString() {
        return "VideoLivePersonCheckResult(" +
                "taskId=" + taskId +
                ", picType=" + picType +
                ", avatar=" + avatar +
                ", lpCheckStatus=" + lpCheckStatus +
                ", reasonType=" + reasonType +
                ")";
    }
}
