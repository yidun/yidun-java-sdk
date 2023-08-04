package com.netease.yidun.sdk.antispam.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * URL过滤规则
 *
 * @author huangwu
 * @version 2021-10-20
 */
public enum CrawlerUrlFilterType {
    PREFIX(1, "前缀匹配"),
    SUFFIX(2, "后缀匹配"),
    FUZZY(3, "模糊匹配"),
    ;

    CrawlerUrlFilterType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private final Integer value;
    private final String desc;

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    private static final Map<Integer, CrawlerUrlFilterType> VALUE_MAP = new HashMap<>();

    static {
        for (CrawlerUrlFilterType type : CrawlerUrlFilterType.values()) {
            VALUE_MAP.put(type.getValue(), type);
        }
    }

    public static CrawlerUrlFilterType getByValue(Integer value) {
        return VALUE_MAP.get(value);
    }
}
