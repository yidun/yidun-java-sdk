package com.netease.yidun.sdk.auth.liveperson.video.composite.v1;

import com.netease.yidun.sdk.auth.liveperson.interactive.ActionImage;

import java.util.List;

/**
 * 视频活体人脸核身结果
 */
public class VideoLivePersonIdCardCheckResult {

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
     * 人脸核身结果
     */
    private Integer status;

    /**
     * 结果对应的原因
     */
    private Integer reasonType;

    /**
     * 头像比对的相似度
     */
    private Double similarityScore;

    /**
     * 人像比对是否通过
     */
    private Integer faceMatched;

    /**
     * 动作照片
     */
    private List<ActionImage> actionImages;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReasonType() {
        return reasonType;
    }

    public void setReasonType(Integer reasonType) {
        this.reasonType = reasonType;
    }

    public Double getSimilarityScore() {
        return similarityScore;
    }

    public void setSimilarityScore(Double similarityScore) {
        this.similarityScore = similarityScore;
    }

    public Integer getFaceMatched() {
        return faceMatched;
    }

    public void setFaceMatched(Integer faceMatched) {
        this.faceMatched = faceMatched;
    }

    public List<ActionImage> getActionImages() {
        return actionImages;
    }

    public void setActionImages(List<ActionImage> actionImages) {
        this.actionImages = actionImages;
    }

    @Override
    public String toString() {
        return "VideoLivePersonIdCardCheckResult(" +
                "taskId=" + taskId +
                ", picType=" + picType +
                ", avatar=" + avatar +
                ", status=" + status +
                ", reasonType=" + reasonType +
                ", similarityScore=" + similarityScore +
                ", faceMatched=" + faceMatched +
                ", actionImages=" + actionImages +
                ")";
    }
}
