package com.netease.yidun.sdk.profile.v1.common;

import com.netease.yidun.sdk.profile.v1.userquery.ProfileUserRiskResult;

import java.util.List;

public class AccountDetail {

    /**
     * 用户风险信息
     */
    private List<ProfileUserRiskResult> riskDetails;

    public List<ProfileUserRiskResult> getRiskDetails() {
        return riskDetails;
    }

    public void setRiskDetails(List<ProfileUserRiskResult> riskDetails) {
        this.riskDetails = riskDetails;
    }
}
