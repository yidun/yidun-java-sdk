/*
 * @(#) IpRiskInfo.java 2023-11-15
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.irisk.v6.check.v603.ip;

import java.io.Serializable;

import com.netease.yidun.sdk.irisk.v6.check.abst.ip.AbstractIpRiskInfo;

public class IpRiskInfo extends AbstractIpRiskInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 风险类型：
     * 14001-恶意引流、14002-网络诈骗、14003-虚假注册、14004-欺诈团伙、14005-风险设备关联、14006-多重认证、14007-认证高频、14008-多次认证失败、14009-电商欺诈、14010-电信涉诈拦截卡、14011-其他、14012-虚假注册
     * （多种风险类型以","分割）
     */
    private String riskType;

    /**
     * 风险等级：
     * 0-低风险，1-中风险，2-高风险
     */
    private Integer riskLevel;

    /**
     * 风险分值：0.0~1.0，分值越高被黑产持有的概率越高
     */
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
        return "IpRiskInfo{" +
                "riskType='" + riskType + '\'' +
                ", riskLevel=" + riskLevel +
                ", riskScore=" + riskScore +
                '}';
    }
}
