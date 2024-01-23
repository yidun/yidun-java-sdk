
package com.netease.yidun.sdk.antispam.enums;

/**
 * 视频检测失败原因
 * @author yd-dev
 */
public enum VideoFailReasonEnum {
    /**
     * 请求重复
     */
    VIDEO_REQUEST_DUP(110, "请求重复"),
    /**
     * 参数错误
     */
    VIDEO_PARAM_ERROR(120, "参数错误"),
    /**
     * 解析错误
     */
    VIDEO_PARSE_ERROR(130, "解析错误"),
    /**
     * 数据类型错误
     */
    VIDEO_URL_ERROR(140, "数据类型错误"),
    /**
     * 视频大小超限 > 5G
     */
    VIDEO_EXCEED(160, "视频大小超限"),
    ;

    private final int code;
    private final String description;

    VideoFailReasonEnum(int code, String description) {
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
