package com.netease.yidun.sdk.antispam.label.cache;

public class LabelCacheItem {
    private String name;
    private Long updateTime;

    public LabelCacheItem(String name, Long updateTime) {
        this.name = name;
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
