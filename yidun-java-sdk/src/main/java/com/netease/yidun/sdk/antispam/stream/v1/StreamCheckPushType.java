/*
 * @(#) StreamCheckPushType.java 2024-06-06
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.stream.v1;

/**
 * @author ruicha
 * @version 2024-06-06
 */
public enum StreamCheckPushType {
    
    // 推送的事件类型，1：流式输出检测  2：输入检测  3：会话结束，默认值为：1
    STREAM_OUTPUT_CHECK(1, "流式输出检测"),
    INPUT_CHECK(2, "输入检测"),
    SESSION_END(3, "会话结束"),
    ;

    private final int code;
    private final String desc;

    StreamCheckPushType(int code, String desc) {
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
