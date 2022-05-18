/*
 * @(#) FixedWindowMetrics.java 2021-06-21
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.endpoint.failover;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 固定时间窗口的域名请求数据统计
 */
public class FixedWindowMetrics implements Metrics {

    // TODO: LRULinkedHashMap非线程安全，需评估它在多线程场景下的效果
    private final Map<String, Data> statMap = new LruLinkedHashMap<>(1024);
    private final long statWindowMillis;

    public FixedWindowMetrics(long statWindowMillis) {
        this.statWindowMillis = statWindowMillis;
    }

    @Override
    public void reset(String productCode, String regionCode, String domain, long currentTimeMillis) {
        Data data = getData(productCode, regionCode, domain, currentTimeMillis);
        synchronized (data) {
            data.successCount.set(0);
            data.failCount.set(0);
        }
    }

    @Override
    public MetricsData requestSuccess(String productCode, String regionCode, String domain, long currentTimeMillis) {
        Data data = getData(productCode, regionCode, domain, currentTimeMillis);

        int successCount;
        int failCount;

        synchronized (data) {
            successCount = data.successCount.incrementAndGet();
            failCount = data.failCount.get();
        }

        return new MetricsData(successCount, failCount);
    }

    @Override
    public MetricsData requestFail(String productCode, String regionCode, String domain, long currentTimeMillis) {
        Data data = getData(productCode, regionCode, domain, currentTimeMillis);

        int successCount;
        int failCount;

        synchronized (data) {
            successCount = data.successCount.get();
            failCount = data.failCount.incrementAndGet();
        }

        return new MetricsData(successCount, failCount);
    }

    private Data getData(String productCode, String regionCode, String domain, long timeMillis) {
        String key = genStatKey(productCode, regionCode, domain, timeMillis);

        Data data = statMap.get(key);
        if (data == null) {
            synchronized (statMap) {
                data = statMap.computeIfAbsent(key, k -> new Data());
            }
        }

        return data;
    }

    private String genStatKey(String productCode, String regionCode, String domain, long timeMillis) {
        long statWindow = timeMillis - timeMillis % statWindowMillis;
        return String.format("%s:%s:%s:%s", productCode, regionCode, domain, statWindow);
    }

    static class Data {
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger failCount = new AtomicInteger(0);
    }

    /**
     * 基于LinkedHashMap的LRU缓存
     *
     * @param <K>
     * @param <V>
     */
    static class LruLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        public LruLinkedHashMap(int capacity) {
            super((int) (capacity / 0.75f), 0.75f, true);
            this.capacity = capacity;
        }

        /**
         * 超过容量后开始淘汰
         */
        @Override
        protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }
}
