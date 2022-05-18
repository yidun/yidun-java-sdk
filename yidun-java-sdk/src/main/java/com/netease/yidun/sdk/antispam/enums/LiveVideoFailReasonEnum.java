package com.netease.yidun.sdk.antispam.enums;

import java.util.HashMap;
import java.util.Map;

public enum LiveVideoFailReasonEnum {
    // @formatter:off
    DOWNLOAD_ERROR(1, "download failed"),
    AUDIO_STREAM_ERROR(2, "video stream not found"),
    ANALYZE_ERROR(3, "analyze failed"),
    INVALID_FORMAT(4, "invalid format");
    // @formatter:on

    private int code;

    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<Integer, LiveVideoFailReasonEnum> VALUE_MAP = new HashMap<>();

    static {
        for (LiveVideoFailReasonEnum statusEnum : LiveVideoFailReasonEnum.values()) {
            VALUE_MAP.put(statusEnum.getCode(), statusEnum);
        }
    }

    LiveVideoFailReasonEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static LiveVideoFailReasonEnum getByValue(int value) {
        return VALUE_MAP.get(value);
    }
}
