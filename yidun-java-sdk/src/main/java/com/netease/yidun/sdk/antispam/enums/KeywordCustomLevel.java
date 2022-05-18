package com.netease.yidun.sdk.antispam.enums;

import java.util.HashMap;
import java.util.Map;

public enum KeywordCustomLevel {

    SUSPECT   (1, "嫌疑"),
    UN_PASS (2, "不通过");

    public static final Map<Integer, KeywordCustomLevel> VALUE_MAP = new HashMap<>();

    static {
        for (KeywordCustomLevel status : KeywordCustomLevel.values()) {
            VALUE_MAP.put(status.code, status);
        }
    }

    private final int code;

    private final String desc;

    KeywordCustomLevel(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static KeywordCustomLevel getByCode(Integer code) {
        return null == code ? null : VALUE_MAP.get(code);
    }
}