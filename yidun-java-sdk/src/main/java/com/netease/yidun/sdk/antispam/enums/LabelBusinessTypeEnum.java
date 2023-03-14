/*
 * @(#) LabelBusinessTypeEnum.java 2023-03-14
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.enums;

/**
 * @author zhuliyang02
 * @version 2023-03-14
 */
public enum LabelBusinessTypeEnum {

    TEXT("100", "文本"),
    IMAGE("200", "图片"),
    VIDEO("300", "视频"),
    AUDIO("400", "音频");
    private String code;
    private String description;

    LabelBusinessTypeEnum(String code, String description) {
        this.code = code;
        this.description= description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
