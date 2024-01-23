
package com.netease.yidun.sdk.antispam.enums;

/**
 * 图片检测失败原因
 * @author yd-dev
 */
public enum ImageFailReasonEnum {
    /**
     * 图片下载失败
     */
    IMAGE_DOWNLOAD_FAIL(610, "图片下载失败"),
    /**
     * 图片格式错误
     */
    IMAGE_FORMAT_ERROR(620, "图片格式错误"),
    /**
     * 其它
     */
    OTHER(630, "其它")
    ;

    private final int code;
    private final String description;

    ImageFailReasonEnum(int code, String description) {
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
