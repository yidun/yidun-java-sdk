package com.netease.yidun.sdk.auth.idcard.v1;

/**
 * 实证认证-实名校验结果
 */
public class IdCardCheckResult {

    /**
     * 认证结果，1-通过 2-不通过, 0-待定
     */
    private Integer status;

    /**
     * 原因详情
     * 2-输入姓名和身份证号不一致
     * 3-查无此身份证
     * 4-身份证照片信息与输入信息不一致
     * 7-结果获取失败，请重试
     */
    private Integer reasonType;

    /**
     * 本次请求数据标识
     */
    private String taskId;

    /**
     * 本次请求是否收费标识，1-收费，0-不收费
     */
    private Integer isPayed;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getReasonType() {
        return reasonType;
    }

    public void setReasonType(Integer reasonType) {
        this.reasonType = reasonType;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    @Override
    public String toString() {
        return "IdCardCheckResult(" +
                "status=" + status +
                ", taskId=" + taskId +
                ", reasonType=" + reasonType +
                ", isPayed=" + isPayed +
                ")";
    }
}
