package com.netease.yidun.sdk.profile.v1.userquery;

import java.util.List;

public class ProfileUserQueryResult {

    /**
     * 是否查询成功
     */
    private Boolean success;

    /**
     * 详情
     */
    private List<ProfileUserRiskResult> riskDetails;

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

    public List<ProfileUserRiskResult> getRiskDetails() {
        return riskDetails;
    }

    public void setRiskDetails(List<ProfileUserRiskResult> riskDetails) {
        this.riskDetails = riskDetails;
    }
}