package com.netease.yidun.sdk.antispam.media.v2.common.constant;

/**
 * 提交配置
 */
public class SubmitConfigConstant {

    /**
     * 指定检测模式，1为同步，2为异步；支持文本和图片，不传则以业务配置为准
     */
    public static final String CHECK_MODE = "checkMode";
    /**
     * 截帧频率配置项 默认5s
     */
    public static String SC_FREQUENCY = "scFrequency";

    /**
     * 音视频去重校验标记位 0为不去重，1为去重
     */
    public static String DUP_CHECK_FLAG = "dupCheckFlag";

    public static enum CheckModeEnum {
        /**
         * 检测模式
         */
        SYNC(1, "同步检测"),
        ASYNC(2, "异步检测");

        int code;
        String desc;

        CheckModeEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }

}
