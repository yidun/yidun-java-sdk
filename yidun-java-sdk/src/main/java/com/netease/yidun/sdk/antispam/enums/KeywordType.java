package com.netease.yidun.sdk.antispam.enums;

import java.util.HashMap;
import java.util.Map;

public enum KeywordType {

    NORMAL(1, "普通词"),
    COMBINE(2, "普通组合词"),
    NORMAL_PINYIN(3,"普通拼音词"),
    ;

    private static final Map<Integer, KeywordType> KEYWORD_TYPE_MAP = new HashMap<>();

    static {
        for (KeywordType type : KeywordType.values()) {
            KEYWORD_TYPE_MAP.put(type.getValue(), type);
        }
    }

    private int value;
    private String description;

    KeywordType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static KeywordType valueOf(Integer value) {
        return KEYWORD_TYPE_MAP.get(value);
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}