package com.netease.yidun.sdk.antispam.enums;

import java.util.HashMap;
import java.util.Map;

public enum KeywordCategory {

    NORMAL       (0,   "正常"),
    PORN        (100, "色情"),
    SEXY        (110, "性感"),
    AD          (200, "广告"),
    QR_CODE     (210, "二维码"),
    AD_LAW     (260, "广告法"),
    TERRORISM   (300, "暴恐"),
    CONTRABAND  (400, "违禁"),
    POLITICS    (500, "涉政"),
    ABUSE       (600, "谩骂"),
    FLOOD       (700, "灌水"),
    OTHER       (900, "其他"),
    VALUES_INVOLVED(1100, "涉价值观");
    ;

    private static final Map<Integer, KeywordCategory> KEYWORD_CATEGORY_MAP = new HashMap<>();

    static {
        for (KeywordCategory type : KeywordCategory.values()) {
            KEYWORD_CATEGORY_MAP.put(type.getValue(), type);
        }
    }

    private int value;
    private String description;

    KeywordCategory(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static KeywordCategory valueOf(Integer value) {
        return KEYWORD_CATEGORY_MAP.get(value);
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}