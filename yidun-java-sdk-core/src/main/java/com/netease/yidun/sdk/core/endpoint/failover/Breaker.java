

package com.netease.yidun.sdk.core.endpoint.failover;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 域名熔断器
 */
public class Breaker {

    /**
     * 熔断器的当前状态
     */
    private final AtomicReference<BreakerStatusEnum> status = new AtomicReference<>(BreakerStatusEnum.CLOSED);
    /**
     * 最近一次执行熔断的时间（UNIX时间戳。单位：毫秒）
     */
    private final AtomicLong lastBreakTimeMillis = new AtomicLong(-1);

    public AtomicReference<BreakerStatusEnum> getStatus() {
        return status;
    }

    public AtomicReference<BreakerStatusEnum> status() {
        return status;
    }

    public AtomicLong getLastBreakTimeMillis() {
        return lastBreakTimeMillis;
    }

    public AtomicLong lastBreakTimeMillis() {
        return lastBreakTimeMillis;
    }

    @Override
    public String toString() {
        return "Breaker(" +
                "status=" + status.get() +
                ", lastBreakTimeMillis=" + lastBreakTimeMillis.get() +
                ")";
    }
}
