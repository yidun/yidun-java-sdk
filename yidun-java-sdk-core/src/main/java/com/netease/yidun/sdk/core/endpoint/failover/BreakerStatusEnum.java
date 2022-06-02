

package com.netease.yidun.sdk.core.endpoint.failover;

/**
 * 域名熔断器的状态
 */
public enum BreakerStatusEnum {
    /**
     * 熔断器已关闭，域名处于可用状态
     */
    CLOSED,
    /**
     * 熔断器已打开，域名处于不可用状态
     */
    OPEN,
    /**
     * 熔断器处于半开状态，仅允许少量请求试探性地访问域名。建议半开状态下，只允许第1个请求访问。
     */
    HALF_OPEN;
}
