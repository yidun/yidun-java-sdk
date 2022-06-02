

package com.netease.yidun.sdk.core.endpoint.failover;

/**
 * 域名的请求统计数据
 */
public class MetricsData {

    /**
     * 请求成功的次数
     */
    private final int successCount;
    /**
     * 请求失败的次数
     */
    private final int failCount;

    public MetricsData(int successCount, int failCount) {
        this.successCount = successCount;
        this.failCount = failCount;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public int successCount() {
        return successCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public int failCount() {
        return failCount;
    }

    @Override
    public String toString() {
        return "MetricsData(" +
                "successCount=" + successCount +
                ", failCount=" + failCount +
                ")";
    }
}
