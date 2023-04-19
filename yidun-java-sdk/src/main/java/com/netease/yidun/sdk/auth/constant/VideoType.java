package com.netease.yidun.sdk.auth.constant;

/**
 * 视频类别
 */
public enum VideoType {
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

    VideoType(int type) {
        this.type = type;
    }
}
