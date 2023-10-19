package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangmiao5
 * @version 2021-06-07 14:45:27
 */
public class ImageRiskControlDetailHitInfoV5 implements Serializable {
    /**
     * 风控结果
     */
    private Integer riskLevel;

    /**
     * 命中详情
     */
    private List<ImageRiskControlHitInfo> hitInfos;

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public List<ImageRiskControlHitInfo> getHitInfos() {
        return hitInfos;
    }

    public void setHitInfos(List<ImageRiskControlHitInfo> hitInfos) {
        this.hitInfos = hitInfos;
    }
}
