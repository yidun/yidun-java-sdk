package com.netease.yidun.sdk.irisk.v6.check.v602;

import com.netease.yidun.sdk.irisk.v6.check.v600.hitinfo.HitInfo;

/**
 * 命中标签信息
 */
public class HitInfoV602 extends HitInfo {
    private Integer riskLevel;

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Override
    public String toString() {
        return "HitInfoV602{" +
                "super=" + super.toString() +
                "riskLevel=" + riskLevel +
                '}';
    }
}
