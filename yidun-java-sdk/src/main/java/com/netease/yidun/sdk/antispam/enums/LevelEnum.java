package com.netease.yidun.sdk.antispam.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 分类级别枚举
 */
public enum LevelEnum {
    // @formatter:off
    NORMAL(0, "通过"),
    SUSPECT(1, "嫌疑"),
    CONFIRM(2, "不通过");
    // @formatter:on

    private static Map<Integer, LevelEnum> valueMap = new HashMap<>();

    static {
        for (LevelEnum labelLevel : LevelEnum.values()) {
            valueMap.put(labelLevel.getCode(), labelLevel);
        }
    }

    private int code;
    private String description;

    LevelEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static LevelEnum getByCode(int code) {
        return valueMap.get(code);
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
