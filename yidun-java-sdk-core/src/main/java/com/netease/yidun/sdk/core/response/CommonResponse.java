/*
 * @(#) CommonResponse.java 2020-07-09
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.response;

public abstract class CommonResponse implements BaseResponse {

    private int code;
    private String msg;

    public CommonResponse() {
    }

    public CommonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CommonResponse("
                + "code=" + code
                + ", msg=" + msg
                + ")";
    }
}
