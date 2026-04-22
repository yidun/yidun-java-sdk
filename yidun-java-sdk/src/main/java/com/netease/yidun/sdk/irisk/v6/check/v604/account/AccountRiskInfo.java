package com.netease.yidun.sdk.irisk.v6.check.v604.account;

import java.io.Serializable;

public class AccountRiskInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String riskType;

    private Integer riskLevel;

    private Double riskScore;

    /**
     * 画像中最近命中风险信息名称
     */
    private String recentTopRisk;

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

    public String getRecentTopRisk() {
        return recentTopRisk;
    }

    public void setRecentTopRisk(String recentTopRisk) {
        this.recentTopRisk = recentTopRisk;
    }

    @Override
    public String toString() {
        return "AccountRiskInfo{" +
                "riskType='" + riskType + '\'' +
                ", riskLevel=" + riskLevel +
                ", riskScore=" + riskScore +
                ", recentTopRisk='" + recentTopRisk + '\'' +
                '}';
    }
}
