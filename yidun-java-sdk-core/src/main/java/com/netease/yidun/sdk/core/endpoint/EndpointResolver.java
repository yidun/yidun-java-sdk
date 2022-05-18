/*
 * @(#) EndpointResolver.java 2020-07-08
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.endpoint;

import java.util.List;

import com.netease.yidun.sdk.core.exception.YidunSdkException;

/**
 * 产品（服务）域名获取器
 */
public interface EndpointResolver {

    /**
     * 获取指定产品（服务）的域名
     * 
     * @param productCode 产品代号
     * @param regionCode 产品（服务）所在区域代号
     * @return 目标服务的域名列表
     * @throws YidunSdkException 该服务在目标区域尚未注册域名
     */
    List<String> resolve(String productCode, String regionCode) throws YidunSdkException;
}
