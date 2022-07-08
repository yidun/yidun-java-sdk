package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;


import java.io.Serializable;
import java.util.List;

/**
 * @author wangmiao5
 * @version 2021-06-07 14:45:27
 */
public class ImageAnticheatDetailHitInfoV5 implements Serializable {
    /**
     * 反作弊结果
     */
    private Integer suggestion;

    private List<ImageAnticheatHitInfo> hitInfos;

    public Integer getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Integer suggestion) {
        this.suggestion = suggestion;
    }

    public List<ImageAnticheatHitInfo> getHitInfos() {
        return hitInfos;
    }

    public void setHitInfos(List<ImageAnticheatHitInfo> hitInfos) {
        this.hitInfos = hitInfos;
    }
}
