/*
 * @(#) RiskResult.java 2022-04-24
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.profile.v1.userquery;

import com.netease.yidun.sdk.profile.v1.ipquery.ProfileRiskInfo;

import java.util.List;

public class ProfileUserRiskResult {

    /**
     * 风险信息
     */
    private List<ProfileRiskInfo> riskInfoList;

    /**
     * 属性详情
     */
    private UserPropDetails propDetails;

    /**
     * 检测账号
     */
    private String account;

    public List<ProfileRiskInfo> getRiskInfoList() {
        return riskInfoList;
    }

    public void setRiskInfoList(List<ProfileRiskInfo> riskInfoList) {
        this.riskInfoList = riskInfoList;
    }

    public UserPropDetails getPropDetails() {
        return propDetails;
    }

    public void setPropDetails(UserPropDetails propDetails) {
        this.propDetails = propDetails;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
