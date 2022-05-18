package com.netease.yidun.sdk.core.endpoint.failover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;

public class FixedWindowMetricsTest {

    private static final String productCode = "product-code-1";
    private static final String regionCode = "region-code-1";
    private static final String domain = "domain-1";
    private static final long currentTimeMillis = 1623326113472L;
    private static final long statWindowMillis = 10 * 60 * 1000;
    private static final String statKey = "product-code-1:region-code-1:domain-1:1623325800000";

    @Test
    public void reset() {
        FixedWindowMetrics metrics = new FixedWindowMetrics(statWindowMillis);
        Map<String, FixedWindowMetrics.Data> statMap = getStatMap(metrics);

        // 初始状态下执行 reset
        metrics.reset(productCode, regionCode, domain, currentTimeMillis);

        assertEquals(1, statMap.size());
        assertEquals(0, statMap.get(statKey).successCount.get());
        assertEquals(0, statMap.get(statKey).failCount.get());

        // 已有历史数据的状态下执行 reset
        statMap.get(statKey).successCount.set(1);
        statMap.get(statKey).failCount.set(2);

        metrics.reset(productCode, regionCode, domain, currentTimeMillis);

        assertEquals(1, statMap.size());
        assertEquals(0, statMap.get(statKey).successCount.get());
        assertEquals(0, statMap.get(statKey).failCount.get());
    }

    @Test
    public void requestSuccess() {
        FixedWindowMetrics metrics = new FixedWindowMetrics(statWindowMillis);
        Map<String, FixedWindowMetrics.Data> statMap = getStatMap(metrics);

        // 首次调用
        metrics.requestSuccess(productCode, regionCode, domain, currentTimeMillis);

        // 验证首次调用结果
        assertEquals(1, statMap.size());
        assertEquals(1, statMap.get(statKey).successCount.get());
        assertEquals(0, statMap.get(statKey).failCount.get());

        // 再次调用并验证结果
        metrics.requestSuccess(productCode, regionCode, domain, currentTimeMillis);
        assertEquals(1, statMap.size());
        assertEquals(2, statMap.get(statKey).successCount.get());
        assertEquals(0, statMap.get(statKey).failCount.get());
    }

    @Test
    public void requestFail() {
        FixedWindowMetrics metrics = new FixedWindowMetrics(statWindowMillis);
        Map<String, FixedWindowMetrics.Data> statMap = getStatMap(metrics);

        // 首次调用
        metrics.requestFail(productCode, regionCode, domain, currentTimeMillis);

        // 验证首次调用结果
        assertEquals(1, statMap.size());
        assertEquals(0, statMap.get(statKey).successCount.get());
        assertEquals(1, statMap.get(statKey).failCount.get());

        // 再次调用并验证结果
        metrics.requestFail(productCode, regionCode, domain, currentTimeMillis);
        assertEquals(1, statMap.size());
        assertEquals(0, statMap.get(statKey).successCount.get());
        assertEquals(2, statMap.get(statKey).failCount.get());
    }

    @Test
    public void testConcurrentSuccessAndFail() {
        FixedWindowMetrics metrics = new FixedWindowMetrics(statWindowMillis);

        // 开始并发调用
        int invokeCount = 30000;
        ArrayBlockingQueue<Future<?>> tasks = new ArrayBlockingQueue<>(invokeCount);
        ExecutorService executor = Executors.newFixedThreadPool(100);
        IntStream.range(0, invokeCount)
                .parallel()
                .forEach(i -> {
                    Runnable cmd = i % 3 == 0
                            ? () -> metrics.requestSuccess(productCode, regionCode, domain, currentTimeMillis)
                            : () -> metrics.requestFail(productCode, regionCode, domain, currentTimeMillis);
                    tasks.add(executor.submit(cmd));
                });

        // 等待调用结束
        try {
            for (Future<?> task : tasks) {
                task.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        // 验证
        Map<String, FixedWindowMetrics.Data> statMap = getStatMap(metrics);
        assertEquals(1, statMap.size());
        FixedWindowMetrics.Data statData = statMap.get(statKey);
        assertEquals(10000, statData.successCount.get());
        assertEquals(20000, statData.failCount.get());
    }

    @Test
    public void testConcurrentInvokeBreakTimeMap() {
        FixedWindowMetrics metrics = new FixedWindowMetrics(statWindowMillis);

        // 调用一次后会生成统计对象
        metrics.reset(productCode, regionCode, domain, currentTimeMillis);
        Map<String, FixedWindowMetrics.Data> statMap = getStatMap(metrics);
        FixedWindowMetrics.Data data = statMap.get(statKey);

        // 开始并发调用
        int invokeCount = 30000;
        ArrayBlockingQueue<Future<?>> tasks = new ArrayBlockingQueue<>(invokeCount);
        ExecutorService executor = Executors.newFixedThreadPool(100);
        IntStream.range(0, invokeCount)
                .parallel()
                .forEach(i -> tasks.add(executor.submit(
                        () -> metrics.reset(productCode, regionCode, domain, currentTimeMillis))));

        // 等待调用结束
        try {
            for (Future<?> task : tasks) {
                task.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        // 验证
        assertEquals(1, statMap.size());
        assertSame(data, getStatMap(metrics).get(statKey));
        assertEquals(0, data.successCount.get());
        assertEquals(0, data.failCount.get());
    }

    @Test
    public void testStatMapLru() {
        FixedWindowMetrics metrics = new FixedWindowMetrics(statWindowMillis);
        Map<String, FixedWindowMetrics.Data> statMap = getStatMap(metrics);

        // 先添加元素到上限
        for (int i = 1; i <= 1024; i++) {
            statMap.put(String.valueOf(i), null);
        }

        // 验证
        assertEquals(1024, statMap.size());
        for (int i = 1; i <= 1024; i++) {
            assertTrue(statMap.containsKey(String.valueOf(i)));
        }

        // 访问第一个添加的元素，打乱原访问顺序
        statMap.get("1");

        // 添加新元素。该操作会淘汰 key "2"
        statMap.put("1025", null);

        // 验证
        assertEquals(1024, statMap.size());
        assertTrue(statMap.containsKey("1"));
        for (int i = 3; i <= 1025; i++) {
            assertTrue(statMap.containsKey(String.valueOf(i)));
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, FixedWindowMetrics.Data> getStatMap(FixedWindowMetrics metrics) {
        try {
            return (Map<String, FixedWindowMetrics.Data>) FieldUtils.readField(metrics, "statMap", true);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
