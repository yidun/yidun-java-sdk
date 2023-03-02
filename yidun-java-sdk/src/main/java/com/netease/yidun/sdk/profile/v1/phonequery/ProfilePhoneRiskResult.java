/*
 * @(#) RiskResult.java 2022-04-24
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.profile.v1.phonequery;

import com.netease.yidun.sdk.profile.v1.ipquery.ProfileRiskInfo;

import java.util.List;

public class ProfilePhoneRiskResult {

    /**
     * 风险信息
     */
    private List<ProfileRiskInfo> riskInfoList;

    /**
     * 属性详情
     */
    private PhonePropDetails propDetails;

    /**
     * 检测手机号
     */
    private String phone;

    public List<ProfileRiskInfo> getRiskInfoList() {
        return riskInfoList;
    }

    public void setRiskInfoList(List<ProfileRiskInfo> riskInfoList) {
        this.riskInfoList = riskInfoList;
    }

    public PhonePropDetails getPropDetails() {
        return propDetails;
    }

    public void setPropDetails(PhonePropDetails propDetails) {
        this.propDetails = propDetails;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
