package com.netease.yidun.sdk.antispam.media.v2.common.constant;

/**
 * 数据类型
 */
public enum DataType {

    /**
     * 融媒体数据类型
     */
    TEXT("text", "文本"),
    IMAGE("image", "图片"),
    AUDIO("audio", "点播语音"),
    AUDIO_VIDEO("audiovideo", "点播音视频"),
    FILE("file", "文档");

    private String type;

    private String desc;

    DataType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
