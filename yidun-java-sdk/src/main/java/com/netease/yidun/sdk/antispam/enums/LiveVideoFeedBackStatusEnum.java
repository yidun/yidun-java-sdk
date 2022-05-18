package com.netease.yidun.sdk.antispam.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 直播回馈状态
 */
public enum LiveVideoFeedBackStatusEnum {

    // @formatter:off
    STOP(100, "直播结束");
    // @formatter:on

    private int value;

    private String description;

    private static final Map<Integer, LiveVideoFeedBackStatusEnum> VIDEO_FEED_BACK_STATUS_MAP = new HashMap<>();

    static {
        for (LiveVideoFeedBackStatusEnum checkType : LiveVideoFeedBackStatusEnum.values()) {
            VIDEO_FEED_BACK_STATUS_MAP.put(checkType.getValue(), checkType);
        }
    }

    LiveVideoFeedBackStatusEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static LiveVideoFeedBackStatusEnum getByValue(int value) {
        return VIDEO_FEED_BACK_STATUS_MAP.get(value);
    }
}
