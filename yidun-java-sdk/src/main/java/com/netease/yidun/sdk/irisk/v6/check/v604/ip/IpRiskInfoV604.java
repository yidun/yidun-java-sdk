package com.netease.yidun.sdk.irisk.v6.check.v604.ip;

import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpRiskInfo;

public class IpRiskInfoV604 extends IpRiskInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 画像中最近命中风险信息名称
     */
    private String recentTopRisk;

    public String getRecentTopRisk() {
        return recentTopRisk;
    }

    public void setRecentTopRisk(String recentTopRisk) {
        this.recentTopRisk = recentTopRisk;
    }

    @Override
    public String toString() {
        return "IpRiskInfoV604{" +
                "super=" + super.toString() +
                ", recentTopRisk='" + recentTopRisk + '\'' +
                '}';
    }
}
