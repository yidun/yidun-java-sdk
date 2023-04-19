package com.netease.yidun.sdk.auth.constant;

/**
 * 图片类别
 */
public enum PicType {
    /**
     * url格式
     */
    URL(1),
    /**
     * base64格式
     */
    BASE64(2);

    int type;

    public int getType() {
        return type;
    }

    PicType(int type) {
        this.type = type;
    }
}
