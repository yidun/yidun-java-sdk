package com.netease.yidun.sdk.antispam.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 分类信息枚举
 */
public enum LabelEnum {
    NORMAL(0, "正常"),
    PORN(100, "色情"),
    SEXY(110, "性感低俗"),
    AD(200, "广告"),
    QRCODE(210, "二维码"),
    AD_LAW(260, "广告法"),
    TERRORISM(300, "暴恐"),
    CONTRABAND(400, "违禁"),
    POLITICS(500, "涉政"),
    ABUSE(600, "谩骂"),
    FLOOD(700, "灌水"),
    NAUSEA(800, "恶心类"),
    OTHER(900, "其他"),
    BLACK_SCREEN(1020, "黑屏"),
    HANGUP      (1030, "挂机"),
    SILENT      (1040, "黑麦"),
    SCREECH     (1050, "噪音"),
    VALUES_INVOLVED(1100, "涉价值观"),
    ;

    private static Map<Integer, LabelEnum> valueMap = new HashMap<>();

    static {
        for (LabelEnum labelLevel : LabelEnum.values()) {
            valueMap.put(labelLevel.getCode(), labelLevel);
        }
    }

    private int code;
    private String description;

    LabelEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static LabelEnum getByCode(int code) {
        return valueMap.get(code);
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
