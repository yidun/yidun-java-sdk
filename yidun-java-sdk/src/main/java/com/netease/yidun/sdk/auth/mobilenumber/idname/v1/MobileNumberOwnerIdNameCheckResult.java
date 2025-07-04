package com.netease.yidun.sdk.auth.mobilenumber.idname.v1;

/**
 * 手机号与所有者身份证号及姓名验证结果
 */
public class MobileNumberOwnerIdNameCheckResult {

    private Integer status;
    private String taskId;
    private Integer reasonType;
    private Integer isPayed;
    private String mobileType;

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

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    @Override
    public String toString() {
        return "MobileNumberOwnerIdNameCheckResult(" +
                "status=" + status +
                ", taskId=" + taskId +
                ", reasonType=" + reasonType +
                ", isPayed=" + isPayed +
                ", mobileType=" + mobileType +
                ")";
    }
}
