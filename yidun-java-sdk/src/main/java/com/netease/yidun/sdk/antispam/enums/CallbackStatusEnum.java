
package com.netease.yidun.sdk.antispam.enums;

public enum CallbackStatusEnum {
    NO_NEED(0, "不需要回调"),
    TOBE_CALLBACK(1, "等待回调"),
    CALLBACKED(2, "已回调"),
    CALLBACK_ERROR(3, "回调失败");

    private int code;
    private String description;

    CallbackStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
