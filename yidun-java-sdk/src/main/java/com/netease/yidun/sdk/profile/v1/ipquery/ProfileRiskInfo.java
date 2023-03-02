package com.netease.yidun.sdk.profile.v1.ipquery;

/**
 * @author fengyunlong
 * @version 2023-03-01
 */
public class ProfileRiskInfo {

    /**
     * 风险等级，0-低风险，1-中风险，2-高风险
     */
    private Integer riskLevel;

    /**
     * 风险类型：13001-恶意引流、13002-真人欺诈、13003-团伙设备聚集
     */
    private Integer riskType;

    /**
     * 风险分值：0~1
     */
    private Double riskScore;

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Integer getRiskType() {
        return riskType;
    }

    public void setRiskType(Integer riskType) {
        this.riskType = riskType;
    }

    public Double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Double riskScore) {
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return "ProfileRiskInfo(" +
                "riskLevel=" + riskLevel +
                ", riskType=" + riskType +
                ", riskScore=" + riskScore +
                ")";
    }
}
