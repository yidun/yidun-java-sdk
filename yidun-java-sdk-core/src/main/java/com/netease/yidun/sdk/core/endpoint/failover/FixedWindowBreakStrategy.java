/*
 * @(#) FixedWindowCountFailoverStrategy.java 2020-07-23
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.endpoint.failover;

import java.time.Clock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 固定时间窗口统计数据的域名熔断策略
 */
public class FixedWindowBreakStrategy implements BreakStrategy {

    private static final String BREAKER_KEY_FORMAT = "%s:%s:%s";

    private final Clock clock;
    private final int statWindowMillis;
    private final int circuitBreakerFailThresholdPercentage;
    private final int circuitBreakerRequestVolumeThreshold;
    private final int circuitBreakerSleepWindowMillis;

    /**
     * 域名请求数据统计
     */
    private final FixedWindowMetrics metrics;
    /**
     * 域名熔断器映射表
     */
    private final Map<String, Breaker> breakerMap = new ConcurrentHashMap<>();

    public FixedWindowBreakStrategy(Config config) {
        this(Clock.systemDefaultZone(), config);
    }

    public FixedWindowBreakStrategy(Clock clock, Config config) {
        this.clock = clock;
        statWindowMillis = config.statWindowMillis;
        circuitBreakerFailThresholdPercentage = config.circuitBreakerFailThresholdPercentage;
        circuitBreakerRequestVolumeThreshold = config.circuitBreakerRequestVolumeThreshold;
        circuitBreakerSleepWindowMillis = config.circuitBreakerSleepWindowMillis;

        metrics = new FixedWindowMetrics(statWindowMillis);
    }

    public Clock getClock() {
        return clock;
    }

    public Clock clock() {
        return clock;
    }

    public int getStatWindowMillis() {
        return statWindowMillis;
    }

    public int statWindowMillis() {
        return statWindowMillis;
    }

    public int getCircuitBreakerFailThresholdPercentage() {
        return circuitBreakerFailThresholdPercentage;
    }

    public int circuitBreakerFailThresholdPercentage() {
        return circuitBreakerFailThresholdPercentage;
    }

    public int getCircuitBreakerRequestVolumeThreshold() {
        return circuitBreakerRequestVolumeThreshold;
    }

    public int circuitBreakerRequestVolumeThreshold() {
        return circuitBreakerRequestVolumeThreshold;
    }

    public int getCircuitBreakerSleepWindowMillis() {
        return circuitBreakerSleepWindowMillis;
    }

    public int circuitBreakerSleepWindowMillis() {
        return circuitBreakerSleepWindowMillis;
    }

    public FixedWindowMetrics getMetrics() {
        return metrics;
    }

    public FixedWindowMetrics metrics() {
        return metrics;
    }

    public Map<String, Breaker> getBreakerMap() {
        return breakerMap;
    }

    public Map<String, Breaker> breakerMap() {
        return breakerMap;
    }

    @Override
    public void requestSuccess(String productCode, String regionCode, String domain) {
        long currentTimeMillis = clock.millis();

        Breaker breaker = getBreaker(productCode, regionCode, domain);
        if (breaker.status().compareAndSet(BreakerStatusEnum.HALF_OPEN, BreakerStatusEnum.CLOSED)) {
            // 熔断器从半开状态到关闭状态：域名恢复为可用
            // 重置相关统计数据
            metrics.reset(productCode, regionCode, domain, currentTimeMillis);
        }

        metrics.requestSuccess(productCode, regionCode, domain, currentTimeMillis);
    }

    @Override
    public void requestFail(String productCode, String regionCode, String domain) {
        long currentTimeMillis = clock.millis();

        MetricsData data = metrics.requestFail(productCode, regionCode, domain, currentTimeMillis);

        Breaker breaker = getBreaker(productCode, regionCode, domain);
        if (breaker.status().compareAndSet(BreakerStatusEnum.HALF_OPEN, BreakerStatusEnum.OPEN)) {
            // 熔断器从半开状态到全开状态：域名继续被熔断
            // 设置新的熔断时间
            breaker.lastBreakTimeMillis().set(currentTimeMillis);
            return;
        }

        // 根据统计信息确定是否需要熔断
        if (breakTriggered(data.failCount(), data.successCount())
                && breaker.status().compareAndSet(BreakerStatusEnum.CLOSED, BreakerStatusEnum.OPEN)) {
            // 针对第一个触发熔断的请求，设置新的熔断时间
            breaker.lastBreakTimeMillis().set(currentTimeMillis);
        }
    }

    @Override
    public boolean attemptAccess(String productCode, String regionCode, String domain) {
        Breaker breaker = getBreaker(productCode, regionCode, domain);

        final long lastBreakTimeMillis = breaker.lastBreakTimeMillis().get();
        final BreakerStatusEnum status = breaker.status().get();

        // 熔断器处于关闭状态：允许访问
        if (status == BreakerStatusEnum.CLOSED) {
            return true;
        }

        // 还处于熔断导致的禁用时间范围内：不允许访问
        if (isInSleepWindow(lastBreakTimeMillis)) {
            return false;
        }

        // 已超过禁用时间范围：允许第1个请求访问
        return breaker.status().compareAndSet(BreakerStatusEnum.OPEN, BreakerStatusEnum.HALF_OPEN);
    }

    /**
     * 是否还处于熔断导致的禁用时间范围内
     */
    private boolean isInSleepWindow(final long lastBreakTimeMillis) {
        return clock.millis() <= lastBreakTimeMillis + circuitBreakerSleepWindowMillis;
    }

    private boolean breakTriggered(int failCount, int successCount) {
        int total = failCount + successCount;
        return total >= circuitBreakerRequestVolumeThreshold
                && failCount * 100 / total >= circuitBreakerFailThresholdPercentage;
    }

    private Breaker getBreaker(String productCode, String regionCode, String domain) {
        String key = genBreakerKey(productCode, regionCode, domain);
        return breakerMap.computeIfAbsent(key, k -> new Breaker());
    }

    private static String genBreakerKey(String productCode, String regionCode, String domain) {
        return String.format(BREAKER_KEY_FORMAT, productCode, regionCode, domain);
    }

    public static FixedWindowBreakStrategy createDefault() {
        return new FixedWindowBreakStrategy(Config.createDefault());
    }

    public static class Config {
        public static final int DEFAULT_STAT_WINDOW_MILLIS = 10 * 60 * 1000;
        public static final int DEFAULT_CIRCUIT_BREAKER_FAIL_THRESHOLD_PERCENTAGE = 40;
        public static final int DEFAULT_CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD = 50;
        public static final int DEFAULT_CIRCUIT_BREAKER_SLEEP_WINDOW_MILLIS = 20 * 60 * 1000;

        private int statWindowMillis = DEFAULT_STAT_WINDOW_MILLIS;
        private int circuitBreakerFailThresholdPercentage = DEFAULT_CIRCUIT_BREAKER_FAIL_THRESHOLD_PERCENTAGE;
        private int circuitBreakerRequestVolumeThreshold = DEFAULT_CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD;
        private int circuitBreakerSleepWindowMillis = DEFAULT_CIRCUIT_BREAKER_SLEEP_WINDOW_MILLIS;

        public int getStatWindowMillis() {
            return statWindowMillis;
        }

        public void setStatWindowMillis(int statWindowMillis) {
            this.statWindowMillis = statWindowMillis;
        }

        public int statWindowMillis() {
            return statWindowMillis;
        }

        /**
         * 统计时间窗口范围。单位：毫秒。默认值：{@link #DEFAULT_STAT_WINDOW_MILLIS}
         */
        public Config statWindowMillis(int millis) {
            statWindowMillis = millis;
            return this;
        }

        public int getCircuitBreakerFailThresholdPercentage() {
            return circuitBreakerFailThresholdPercentage;
        }

        public void setCircuitBreakerFailThresholdPercentage(int circuitBreakerFailThresholdPercentage) {
            this.circuitBreakerFailThresholdPercentage = circuitBreakerFailThresholdPercentage;
        }

        public int circuitBreakerFailThresholdPercentage() {
            return circuitBreakerFailThresholdPercentage;
        }

        /**
         * 触发熔断的错误率（百分比）。如，40表示，在单个统计时间窗口内，若错误次数达到总次数的40%，则会触发熔断：将目标域名标记为不可用。
         * 默认值：{@link #DEFAULT_CIRCUIT_BREAKER_FAIL_THRESHOLD_PERCENTAGE}
         */
        public Config circuitBreakerFailThresholdPercentage(int percentage) {
            circuitBreakerFailThresholdPercentage = percentage;
            return this;
        }

        public int getCircuitBreakerRequestVolumeThreshold() {
            return circuitBreakerRequestVolumeThreshold;
        }

        public void setCircuitBreakerRequestVolumeThreshold(int circuitBreakerRequestVolumeThreshold) {
            this.circuitBreakerRequestVolumeThreshold = circuitBreakerRequestVolumeThreshold;
        }

        public int circuitBreakerRequestVolumeThreshold() {
            return circuitBreakerRequestVolumeThreshold;
        }

        /**
         * 触发熔断需满足的请求总数。在单个统计时间窗口内，{@link #circuitBreakerFailThresholdPercentage} 和
         * {@link #circuitBreakerRequestVolumeThreshold} 需同时满足，才会触发熔断。
         * 默认值：{@link #DEFAULT_CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD}
         */
        public Config circuitBreakerRequestVolumeThreshold(int threshold) {
            circuitBreakerRequestVolumeThreshold = threshold;
            return this;
        }

        public int getCircuitBreakerSleepWindowMillis() {
            return circuitBreakerSleepWindowMillis;
        }

        public void setCircuitBreakerSleepWindowMillis(int circuitBreakerSleepWindowMillis) {
            this.circuitBreakerSleepWindowMillis = circuitBreakerSleepWindowMillis;
        }

        public int circuitBreakerSleepWindowMillis() {
            return circuitBreakerSleepWindowMillis;
        }

        /**
         * 单次熔断的持续时间。单位：毫秒。超过持续时间后，域名会被解封：去除不可用的标记。默认值：{@link #DEFAULT_CIRCUIT_BREAKER_SLEEP_WINDOW_MILLIS}
         */
        public Config circuitBreakerSleepWindowMillis(int millis) {
            circuitBreakerSleepWindowMillis = millis;
            return this;
        }

        @Override
        public String toString() {
            return "FixedWindowBreakStrategy.Config(" +
                    "statWindowMillis=" + statWindowMillis +
                    ", circuitBreakerFailThresholdPercentage=" + circuitBreakerFailThresholdPercentage +
                    ", circuitBreakerRequestVolumeThreshold=" + circuitBreakerRequestVolumeThreshold +
                    ", circuitBreakerSleepWindowMillis=" + circuitBreakerSleepWindowMillis +
                    ")";
        }

        public static Config createDefault() {
            return new Config();
        }
    }
}
