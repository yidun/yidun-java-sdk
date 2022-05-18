package com.netease.yidun.sdk.antispam.image.v5.enums;

import java.util.HashMap;
import java.util.Map;

public enum CensorTypeEnum {
    MACHINE(0, "全机器"),
    HUMAN_MACHINE(1, "部分人审"),
    HUMAN(2, "全人审");

    private static Map<Integer, CensorTypeEnum> valuesMap = new HashMap<>(3);

    static {
        for (CensorTypeEnum status : CensorTypeEnum.values()) {
            valuesMap.put(status.value, status);
        }
    }

    private int value;
    private String desc;

    CensorTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static CensorTypeEnum getByValue(int value) {
        return valuesMap.get(value);
    }

}
