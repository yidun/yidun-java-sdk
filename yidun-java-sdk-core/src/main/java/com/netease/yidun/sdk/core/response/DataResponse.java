/*
 * @(#) DataResponse.java 2022-05-10
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.response;


public class DataResponse<T> extends CommonResponse {

    private T data;

    public DataResponse(int code, String msg, T data) {
        super(code, msg);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataResponse("
                + "super=" + super.toString()
                + ", result=" + data
                + ")";
    }
}
