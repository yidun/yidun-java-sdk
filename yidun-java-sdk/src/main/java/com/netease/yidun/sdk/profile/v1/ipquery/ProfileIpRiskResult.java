/*
 * @(#) RiskResult.java 2022-04-24
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.profile.v1.ipquery;

import java.util.List;

public class ProfileIpRiskResult {

    /**
     * 风险信息
     */
    private List<ProfileRiskInfo> riskInfoList;

    /**
     * 属性详情
     */
    private IpPropDetails propDetails;

    /**
     * 检测IP
     */
    private String ip;


    public List<ProfileRiskInfo> getRiskInfoList() {
        return riskInfoList;
    }

    public void setRiskInfoList(List<ProfileRiskInfo> riskInfoList) {
        this.riskInfoList = riskInfoList;
    }

    public IpPropDetails getPropDetails() {
        return propDetails;
    }

    public void setPropDetails(IpPropDetails ipPropDetails) {
        this.propDetails = ipPropDetails;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
