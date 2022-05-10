/*
 * @(#) DeviceQueryResponse.java 2022-05-10
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.fingerprint;


import com.netease.yidun.sdk.core.response.DataResponse;

public class DeviceQueryResponse extends DataResponse<DeviceQueryResult> {

    public DeviceQueryResponse(int code, String msg, DeviceQueryResult data) {
        super(code, msg, data);
    }

    @Override
    public String toString() {
        return "DeviceQueryResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
