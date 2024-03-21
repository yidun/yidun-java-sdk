package com.netease.yidun.sdk.irisk.v6.check.v602;

import com.netease.yidun.sdk.irisk.v6.check.v600.hitinfo.HitInfo;

import java.util.List;

/**
 * 命中标签信息
 */
public class HitInfoV602 extends HitInfo {
    private Integer riskLevel;

    /**
     * 603小版本开始支持
     */
    private List<String> rules;

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "HitInfoV602{" +
                "super=" + super.toString() +
                ", riskLevel=" + riskLevel +
                ", rules=" + rules +
                '}';
    }
}
