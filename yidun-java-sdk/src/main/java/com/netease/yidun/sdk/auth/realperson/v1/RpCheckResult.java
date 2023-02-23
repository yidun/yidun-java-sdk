package com.netease.yidun.sdk.auth.realperson.v1;

/**
 * 实人认证结果
 */
public class RpCheckResult {

    /**
     * 本次请求数据标识，可以根据该标识在控制台进行数据查询
     */
    private String taskId;

    /**
     * 姓名身份证号认证结果
     */
    private Integer status;

    /**
     * 认证结果对应的原因
     */
    private Integer reasonType;

    /**
     * 用户所传头像与身份证头像的相似度得分
     */
    private Double similarityScore;

    /**
     * 人脸比对认证结果
     */
    private Integer faceMatched;

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

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    @Override
    public String toString() {
        return "RpCheckResult(" +
                "taskId=" + taskId +
                ", status=" + status +
                ", reasonType=" + reasonType +
                ", similarityScore=" + similarityScore +
                ", faceMatched=" + faceMatched +
                ", isPayed=" + isPayed +
                ")";
    }
}
