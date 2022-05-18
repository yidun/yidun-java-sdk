
package com.netease.yidun.sdk.antispam.enums;

/**
 * 音频语音识别结果码
 */
public enum AudioAsrResultCodeEnum {
    SUCCESS(0, "成功"),
    FORMAT_ERROR(1, "文件格式错误"),
    DOWNLOAD_FILE_FAILED(2, "文件下载失败"),
    ANALYZE_FAILED(3, "解析失败"),
    STREAM_NOT_EXIST(4, "音频流不存在"),
    SYNC_DURATION_LIMIT(5, "同步检测时长超长"),
    SYNC_CHECK_EARLY_END(6, "同步检测提前结束");

    private int code;
    private String description;

    AudioAsrResultCodeEnum(int code, String description) {
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
