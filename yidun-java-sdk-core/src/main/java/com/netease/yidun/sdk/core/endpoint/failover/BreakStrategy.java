/*
 * @(#) FailoverStrategy.java 2020-07-23
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.endpoint.failover;

/**
 * 域名熔断策略
 */
public interface BreakStrategy {

    /**
     * 声明一次请求成功。每次请求成功后调用此方法
     *
     * @param productCode productCode 产品代号
     * @param regionCode 产品（服务）所在区域代号
     * @param domain 目标服务的域名
     */
    void requestSuccess(String productCode, String regionCode, String domain);

    /**
     * 声明一次请求失败。每次请求失败后调用此方法
     *
     * @param productCode productCode 产品代号
     * @param regionCode 产品（服务）所在区域代号
     * @param domain 目标服务的域名
     */
    void requestFail(String productCode, String regionCode, String domain);

    /**
     * 尝试访问域名。每次在访问域名前都调用此方法，以确定域名是否可用。注意：此方法非幂等。
     *
     * @return true: 允许访问; false: 不允许访问
     */
    boolean attemptAccess(String productCode, String regionCode, String domain);
}
