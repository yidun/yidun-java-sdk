
package com.netease.yidun.sdk.antispam.enums;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LiveAudioSubmitCodeEnum {

    SUCCESS(0, "提交成功"),
    FAIL(1, "提交失败"),
    CONCURRENCY_LIMIT(2, "并发超限"),
    REPEAT_DETECTION(3, "重复提交");

    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回描述信息
     */
    private String description;

    private static final Map<Integer, LiveAudioSubmitCodeEnum> SUBMIT_CODE_MAP = new HashMap<>();
    static {
        for (LiveAudioSubmitCodeEnum LiveAudioSubmitCodeEnum : LiveAudioSubmitCodeEnum.values()) {
            SUBMIT_CODE_MAP.put(LiveAudioSubmitCodeEnum.getCode(), LiveAudioSubmitCodeEnum);
        }
    }

    public static LiveAudioSubmitCodeEnum getByCode(Integer code) {
        return SUBMIT_CODE_MAP.get(code);
    }

}
