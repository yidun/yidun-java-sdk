package com.netease.yidun.sdk.auth.liveperson.interactive.composite.v1;

import com.netease.yidun.sdk.auth.liveperson.interactive.ActionImage;

import java.util.List;

/**
 * 交互式活体人脸核身结果
 */
public class InteractiveLivePersonIdCardCheckResult {

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
    private Integer status;

    /**
     * 公安人像比对是否通过，0-待定 1-通过 2-不通过
     */
    private Integer faceMatched;

    /**
     * 头像比对的相似度
     */
    private Double similarityScore;

    /**
     * 结果对应的原因
     */
    private Integer reasonType;

    /**
     * 动作照片
     */
    private List<ActionImage> actionImages;

    /**
     * 本次请求是否收费标识，1代表收费，0代表不收费
     */
    private Integer isPayed;

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

    public Integer getFaceMatched() {
        return faceMatched;
    }

    public void setFaceMatched(Integer faceMatched) {
        this.faceMatched = faceMatched;
    }

    public Double getSimilarityScore() {
        return similarityScore;
    }

    public void setSimilarityScore(Double similarityScore) {
        this.similarityScore = similarityScore;
    }

    public Integer getReasonType() {
        return reasonType;
    }

    public void setReasonType(Integer reasonType) {
        this.reasonType = reasonType;
    }

    public List<ActionImage> getActionImages() {
        return actionImages;
    }

    public void setActionImages(List<ActionImage> actionImages) {
        this.actionImages = actionImages;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    @Override
    public String toString() {
        return "InteractiveLivePersonIdCardCheckResult(" +
                "taskId=" + taskId +
                ", picType=" + picType +
                ", avatar='" + avatar +
                ", status=" + status +
                ", faceMatched=" + faceMatched +
                ", similarityScore=" + similarityScore +
                ", reasonType=" + reasonType +
                ", actionImages=" + actionImages +
                ", isPayed=" + isPayed +
                ")";
    }
}
