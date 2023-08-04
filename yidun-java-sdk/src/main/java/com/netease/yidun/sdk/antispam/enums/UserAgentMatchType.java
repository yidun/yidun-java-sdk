package com.netease.yidun.sdk.antispam.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangwu
 * @version 2019-12-25
 */
public enum UserAgentMatchType {
    /**
     * 匹配规则
     */
    PARTIAL(1, "部分匹配"),
    COMPLETE(2, "完全匹配"),
    ;

    UserAgentMatchType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static final Map<Integer, UserAgentMatchType> VALUE_MAP = new HashMap<>();

    static {
        for (UserAgentMatchType type : UserAgentMatchType.values()) {
            VALUE_MAP.put(type.getValue(), type);
        }
    }

    public static UserAgentMatchType getByValue(Integer value) {
        return VALUE_MAP.get(value);
    }

    private Integer value;
    private String desc;

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
