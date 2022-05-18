package com.netease.yidun.sdk.antispam.image.v5.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片检测状态
 */
public enum ImageCheckStatusEnum {
    UN_CHECK(0, "未开始"),
    CHECKING(1, "检测中"),
    SUCCESS(2, "检测成功"),
    FAIL(3, "检测失败");

    private static Map<Integer, ImageCheckStatusEnum> valuesMap = new HashMap<>(2);

    static {
        for (ImageCheckStatusEnum status : ImageCheckStatusEnum.values()) {
            valuesMap.put(status.value, status);
        }
    }

    @Getter
    private int value;
    @Getter
    private String desc;

    ImageCheckStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static ImageCheckStatusEnum getByValue(int value) {
        return valuesMap.get(value);
    }

}
