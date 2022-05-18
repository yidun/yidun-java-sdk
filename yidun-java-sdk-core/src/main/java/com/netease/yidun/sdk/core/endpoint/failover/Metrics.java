/*
 * @(#) Metrics.java 2021-06-21
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.endpoint.failover;

/**
 * 域名的请求数据统计
 */
public interface Metrics {

    /**
     * 重置统计数据
     * 
     * @param productCode productCode 产品代号
     * @param regionCode 产品（服务）所在区域代号
     * @param domain 目标服务的域名
     * @param currentTimeMillis 当前时间（UNIX时间戳。单位：毫秒）
     */
    void reset(String productCode, String regionCode, String domain, long currentTimeMillis);

    /**
     * 声明一次请求成功。每次请求成功后调用此方法
     *
     * @param productCode productCode 产品代号
     * @param regionCode 产品（服务）所在区域代号
     * @param domain 目标服务的域名
     * @param currentTimeMillis 当前时间（UNIX时间戳。单位：毫秒）
     * @return 叠加此次数据后的当前统计数据
     */
    MetricsData requestSuccess(String productCode, String regionCode, String domain, long currentTimeMillis);

    /**
     * 声明一次请求失败。每次请求失败后调用此方法
     *
     * @param productCode productCode 产品代号
     * @param regionCode 产品（服务）所在区域代号
     * @param domain 目标服务的域名
     * @param currentTimeMillis 当前时间（UNIX时间戳。单位：毫秒）
     * @return 叠加此次数据后的当前统计数据
     */
    MetricsData requestFail(String productCode, String regionCode, String domain, long currentTimeMillis);
}
