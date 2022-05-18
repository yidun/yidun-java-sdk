/*
 * @(#) DefaultEndpointResolver.java 2020-07-08
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.endpoint;

import static com.netease.yidun.sdk.core.endpoint.EndpointConfigLoader.loadFromResourceFiles;
import static com.netease.yidun.sdk.core.endpoint.EndpointMapUtils.flatKey;

/**
 * 从本地资源文件获取域名配置
 */
public class DefaultEndpointResolver extends AbstractEndpointResolver {

    private DefaultEndpointResolver() {
        super(flatKey(loadFromResourceFiles()));
    }

    public static DefaultEndpointResolver getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final DefaultEndpointResolver INSTANCE = new DefaultEndpointResolver();
    }
}
