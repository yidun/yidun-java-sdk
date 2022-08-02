/*
 * @(#) DataRecover.java 2021-11-23
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.recover;

import com.netease.yidun.sdk.core.response.BaseResponse;

public interface RequestRecover {

    boolean doRecover(RecoverMessage message);

    <T extends BaseResponse> T getFallbackResponse(Class<T> clazz);
}
