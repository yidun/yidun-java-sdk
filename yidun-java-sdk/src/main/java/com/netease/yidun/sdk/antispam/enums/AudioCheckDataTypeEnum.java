
package com.netease.yidun.sdk.antispam.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 点播音频同步检测数据类型
 */
public enum AudioCheckDataTypeEnum {

    URL(0, "url"),
    BASE64(1, "base64");

    private static Map<Integer, AudioCheckDataTypeEnum> valueMap = new HashMap<>();

    static {
        for (AudioCheckDataTypeEnum audioCheckDataTypeEnum : AudioCheckDataTypeEnum.values()) {
            valueMap.put(audioCheckDataTypeEnum.getCode(), audioCheckDataTypeEnum);
        }
    }

    private int code;
    private String description;

    AudioCheckDataTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static AudioCheckDataTypeEnum getByCode(int code) {
        return valueMap.get(code);
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
