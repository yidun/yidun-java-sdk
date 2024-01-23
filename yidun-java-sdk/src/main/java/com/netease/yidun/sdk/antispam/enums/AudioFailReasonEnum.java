
package com.netease.yidun.sdk.antispam.enums;

/**
 * 音频检测失败原因枚举
 * @author yd-dev
 */
public enum AudioFailReasonEnum {

    /**
     * 文件格式错误
     */
    FORMAT_ERROR(1, "文件格式错误"),
    /**
     * 文件下载失败
     */
    DOWNLOAD_FILE_FAILED(2, "文件下载失败"),
    /**
     * 解析失败
     */
    ANALYZE_FAILED(3, "解析失败"),
    /**
     * 音频流不存在
     */
    STREAM_NOT_EXIST(4, "音频流不存在"),
    ;
    private final int code;
    private final String description;

    AudioFailReasonEnum(int code, String description) {
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
