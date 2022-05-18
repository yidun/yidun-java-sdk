package com.netease.yidun.sdk.antispam.image.v5.enums;

import java.util.HashMap;
import java.util.Map;

public enum ImageTypeEnum {
    URL(1, "url"),
    BASE64(2, "base64");

    private static final Map<Integer, ImageTypeEnum> VALUE_MAP = new HashMap<>();

    static {
        for (ImageTypeEnum item : ImageTypeEnum.values()) {
            VALUE_MAP.put(item.getType(), item);
        }
    }

    private int type;
    private String desc;

    private ImageTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static ImageTypeEnum getByType(int type) {
        return VALUE_MAP.get(type);
    }
}
