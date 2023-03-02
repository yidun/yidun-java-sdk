package com.netease.yidun.sdk.profile.v1.common;

import com.netease.yidun.sdk.profile.v1.phonequery.ProfilePhoneRiskResult;

import java.util.List;

public class PhoneDetail {

    /**
     * 用户风险信息
     */
    private List<ProfilePhoneRiskResult> riskDetails;

    public List<ProfilePhoneRiskResult> getRiskDetails() {
        return riskDetails;
    }

    public void setRiskDetails(List<ProfilePhoneRiskResult> riskDetails) {
        this.riskDetails = riskDetails;
    }
}
