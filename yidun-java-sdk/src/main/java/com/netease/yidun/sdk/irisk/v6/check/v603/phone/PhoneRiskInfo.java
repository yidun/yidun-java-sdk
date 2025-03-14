/*
 * @(#) PhoneRiskInfo.java 2023-11-15
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.irisk.v6.check.v603.phone;

import com.netease.yidun.sdk.irisk.v6.check.abst.ip.AbstractIpRiskInfo;

public class PhoneRiskInfo  extends AbstractIpRiskInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String riskType;

    private Integer riskLevel;

    private Double riskScore;

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Double riskScore) {
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return "PhoneRiskInfo{" +
                "riskType='" + riskType + '\'' +
                ", riskLevel=" + riskLevel +
                ", riskScore=" + riskScore +
                '}';
    }
}
