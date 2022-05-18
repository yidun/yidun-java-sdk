package com.netease.yidun.sdk.antispam.image.v5.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 机器或人审结果
 */
public enum CheckResultTypeEnum {

    MACHINE(1, "机器检测"),
    HUMAN_CENSOR(2, "人工审核");

    private int type;

    private String desc;

    CheckResultTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private static final Map<Integer, CheckResultTypeEnum> VALUE_MAP = new HashMap<>();

    static {
        for (CheckResultTypeEnum item : CheckResultTypeEnum.values()) {
            VALUE_MAP.put(item.getType(), item);
        }
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static CheckResultTypeEnum getByType(int type) {
        return VALUE_MAP.get(type);
    }
}
