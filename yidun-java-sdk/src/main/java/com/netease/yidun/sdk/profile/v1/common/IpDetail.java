package com.netease.yidun.sdk.profile.v1.common;

import com.netease.yidun.sdk.profile.v1.ipquery.ProfileIpRiskResult;

import java.util.List;

public class IpDetail {

    /**
     * 用户风险信息
     */
    private List<ProfileIpRiskResult> riskDetails;

    public List<ProfileIpRiskResult> getRiskDetails() {
        return riskDetails;
    }

    public void setRiskDetails(List<ProfileIpRiskResult> riskDetails) {
        this.riskDetails = riskDetails;
    }
}
