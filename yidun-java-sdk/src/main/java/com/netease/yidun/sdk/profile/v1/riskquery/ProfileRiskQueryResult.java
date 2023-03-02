package com.netease.yidun.sdk.profile.v1.riskquery;

public class ProfileRiskQueryResult {

    /**
     * 是否查询成功
     */
    private Boolean success;

    /**
     * 详情
     */
    private ProfileRiskResult details;

    /**
     * 查询的唯一标识
     */
    private String taskId;


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public ProfileRiskResult getDetails() {
        return details;
    }

    public void setDetails(ProfileRiskResult details) {
        this.details = details;
    }
}