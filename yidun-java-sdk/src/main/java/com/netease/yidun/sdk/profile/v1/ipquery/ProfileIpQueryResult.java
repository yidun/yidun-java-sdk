package com.netease.yidun.sdk.profile.v1.ipquery;

import java.util.List;

public class ProfileIpQueryResult {

    /**
     * 属性详情
     */
    private List<ProfileIpRiskResult> riskDetails;

    /**
     * 是否查询成功
     */
    private Boolean success;

    /**
     * 查询的唯一标识
     */
    private String taskId;

    public List<ProfileIpRiskResult> getRiskDetails() {
        return riskDetails;
    }

    public void setRiskDetails(List<ProfileIpRiskResult> riskDetails) {
        this.riskDetails = riskDetails;
    }

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
}