/*
 * @(#) DataRecover.java 2021-11-23
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.recover;

import com.netease.yidun.sdk.core.response.BaseResponse;

public interface RequestRecover {

    /**
     * 当前request类是否支持恢复
     * @param clazz
     * @return
     */
    boolean isSupport(Class<?> clazz);

    boolean doRecover(RecoverMessage message, Class<?> responseClass);

    <T extends BaseResponse> T getFallbackResponse(Class<T> clazz);
}
