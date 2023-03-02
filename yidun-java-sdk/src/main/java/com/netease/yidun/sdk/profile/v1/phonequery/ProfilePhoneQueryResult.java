package com.netease.yidun.sdk.profile.v1.phonequery;

import java.util.List;

public class ProfilePhoneQueryResult {

    /**
     * 是否查询成功
     */
    private Boolean success;

    /**
     * 属性详情
     */
    private List<ProfilePhoneRiskResult> riskDetails;

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

    public List<ProfilePhoneRiskResult> getRiskDetails() {
        return riskDetails;
    }

    public void setRiskDetails(List<ProfilePhoneRiskResult> riskDetails) {
        this.riskDetails = riskDetails;
    }
}