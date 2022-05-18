/*
 * @(#) IClient.java 2020-07-09
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.client;

import com.netease.yidun.sdk.core.exception.YidunSdkException;
import com.netease.yidun.sdk.core.request.BaseRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;

public interface Client {

    <R extends BaseResponse> R execute(BaseRequest<R> request) throws YidunSdkException;
}
