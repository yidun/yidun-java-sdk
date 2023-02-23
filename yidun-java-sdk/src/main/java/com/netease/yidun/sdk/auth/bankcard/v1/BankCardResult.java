package com.netease.yidun.sdk.auth.bankcard.v1;

/**
 * 银行卡认证返回结果
 */
public class BankCardResult {

    private Integer status;
    private String taskId;
    private Integer reasonType;
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
        return "BankCardResult(" +
                "status=" + status +
                ", taskId=" + taskId +
                ", reasonType=" + reasonType +
                ", isPayed=" + isPayed +
                ")";
    }
}
