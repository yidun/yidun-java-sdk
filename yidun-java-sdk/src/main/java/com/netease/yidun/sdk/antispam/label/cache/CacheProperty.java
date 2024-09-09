package com.netease.yidun.sdk.antispam.label.cache;

public class CacheProperty {
    private static final Integer DEFAULT_REFRESH_INTERVAL_MINUTE = 60;

    /**
     * 缓存刷新间隔，单位：分钟
     */
    private Integer refreshIntervalMinute = DEFAULT_REFRESH_INTERVAL_MINUTE;

    public Integer getRefreshIntervalMinute() {
        return refreshIntervalMinute;
    }

    public void setRefreshIntervalMinute(Integer refreshIntervalMinute) {
        this.refreshIntervalMinute = refreshIntervalMinute;
    }
}
