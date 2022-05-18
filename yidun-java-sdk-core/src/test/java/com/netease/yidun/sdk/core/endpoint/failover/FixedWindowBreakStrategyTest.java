package com.netease.yidun.sdk.core.endpoint.failover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.Clock;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;

public class FixedWindowBreakStrategyTest {

    private static final String productCode = "product-code-1";
    private static final String regionCode = "region-code-1";
    private static final String domain = "domain-1";
    private static final long currentTimeMillis = 1623326113472L;
    private static final String breakerKey = "product-code-1:region-code-1:domain-1";
    private static final int statWindowMillis = 60000;
    private static final int circuitBreakerFailThresholdPercentage = 40;
    private static final int circuitBreakerRequestVolumeThreshold = 10;
    private static final int circuitBreakerSleepWindowMillis = 30000;

    @Test
    public void requestFailOnHalfOpen() {
        long firstTimeMillis = currentTimeMillis;
        long secondTimeMillis = currentTimeMillis + 1;

        FixedWindowMetrics metrics = mock(FixedWindowMetrics.class);
        when(metrics.requestFail(productCode, regionCode, domain, firstTimeMillis))
                .thenReturn(new MetricsData(0, 1));
        when(metrics.requestFail(productCode, regionCode, domain, secondTimeMillis))
                .thenReturn(new MetricsData(0, 2));

        Clock clock = mock(Clock.class);
        when(clock.millis()).thenReturn(firstTimeMillis, secondTimeMillis);
        FixedWindowBreakStrategy strategy = new FixedWindowBreakStrategy(clock, createConfig());
        setMetrics(strategy, metrics);

        // 预设熔断器和统计器的状态
        Breaker breaker = new Breaker();
        breaker.status().set(BreakerStatusEnum.HALF_OPEN);
        strategy.breakerMap().put(breakerKey, breaker);

        // 第一次请求失败，熔断器状态变为OPEN，设置新的熔断时间戳
        strategy.requestFail(productCode, regionCode, domain);
        // 第二次请求失败，不再变更状态
        strategy.requestFail(productCode, regionCode, domain);

        // 验证
        assertEquals(BreakerStatusEnum.OPEN, breaker.status().get());
        assertEquals(currentTimeMillis, breaker.lastBreakTimeMillis().get());

        verify(clock, times(2)).millis();
        verify(metrics, times(1)).requestFail(productCode, regionCode, domain, firstTimeMillis);
        verify(metrics, times(1)).requestFail(productCode, regionCode, domain, secondTimeMillis);
        verifyNoMoreInteractions(clock, metrics);
    }

    @Test
    public void breakTriggered() {
        long firstTimeMillis = currentTimeMillis;
        long secondTimeMillis = currentTimeMillis + 1;

        FixedWindowMetrics metrics = mock(FixedWindowMetrics.class);
        when(metrics.requestFail(productCode, regionCode, domain, firstTimeMillis))
                .thenReturn(new MetricsData(6, 4));
        when(metrics.requestFail(productCode, regionCode, domain, secondTimeMillis))
                .thenReturn(new MetricsData(6, 5));

        Clock clock = mock(Clock.class);
        when(clock.millis()).thenReturn(firstTimeMillis, secondTimeMillis);
        FixedWindowBreakStrategy strategy = new FixedWindowBreakStrategy(clock, createConfig());
        setMetrics(strategy, metrics);

        // 预设熔断器和统计器的状态
        Breaker breaker = new Breaker();
        breaker.status().set(BreakerStatusEnum.CLOSED);
        strategy.breakerMap().put(breakerKey, breaker);

        // 第一次请求失败，熔断器状态变为OPEN，设置新的熔断时间戳
        strategy.requestFail(productCode, regionCode, domain);
        // 第二次请求失败，不再变更状态
        strategy.requestFail(productCode, regionCode, domain);

        // 验证
        assertEquals(BreakerStatusEnum.OPEN, breaker.status().get());
        assertEquals(currentTimeMillis, breaker.lastBreakTimeMillis().get());

        verify(clock, times(2)).millis();
        verify(metrics, times(1)).requestFail(productCode, regionCode, domain, firstTimeMillis);
        verify(metrics, times(1)).requestFail(productCode, regionCode, domain, secondTimeMillis);
        verifyNoMoreInteractions(clock, metrics);
    }

    @Test
    public void breakNotTriggered() {
        long firstTimeMillis = currentTimeMillis;
        long secondTimeMillis = currentTimeMillis + 1;

        FixedWindowMetrics metrics = mock(FixedWindowMetrics.class);
        when(metrics.requestFail(productCode, regionCode, domain, firstTimeMillis))
                .thenReturn(new MetricsData(4, 4));
        when(metrics.requestFail(productCode, regionCode, domain, secondTimeMillis))
                .thenReturn(new MetricsData(7, 3));

        Clock clock = mock(Clock.class);
        when(clock.millis()).thenReturn(firstTimeMillis, secondTimeMillis);
        FixedWindowBreakStrategy strategy = new FixedWindowBreakStrategy(clock, createConfig());
        setMetrics(strategy, metrics);

        // 预设熔断器和统计器的状态
        Breaker breaker = new Breaker();
        breaker.status().set(BreakerStatusEnum.CLOSED);
        strategy.breakerMap().put(breakerKey, breaker);

        // 第一次请求失败，总请求次数未达到阈值，不会触发熔断
        strategy.requestFail(productCode, regionCode, domain);
        // 第二次请求失败，失败次数占比未达到阈值，不会触发熔断
        strategy.requestFail(productCode, regionCode, domain);

        // 验证
        assertEquals(BreakerStatusEnum.CLOSED, breaker.status().get());
        assertEquals(-1, breaker.lastBreakTimeMillis().get());

        verify(clock, times(2)).millis();
        verify(metrics, times(1)).requestFail(productCode, regionCode, domain, firstTimeMillis);
        verify(metrics, times(1)).requestFail(productCode, regionCode, domain, secondTimeMillis);
        verifyNoMoreInteractions(clock, metrics);
    }

    @Test
    public void requestSuccessOnHalfOpen() {
        FixedWindowMetrics metrics = mock(FixedWindowMetrics.class);
        Clock clock = mockClock();
        FixedWindowBreakStrategy strategy = new FixedWindowBreakStrategy(clock, createConfig());
        setMetrics(strategy, metrics);

        // 预设熔断器和统计器的状态
        Breaker breaker = new Breaker();
        breaker.status().set(BreakerStatusEnum.HALF_OPEN);
        strategy.breakerMap().put(breakerKey, breaker);

        strategy.requestSuccess(productCode, regionCode, domain);

        // 验证
        verify(clock, times(1)).millis();
        verify(metrics, times(1)).reset(productCode, regionCode, domain, currentTimeMillis);
        verify(metrics, times(1)).requestSuccess(productCode, regionCode, domain, currentTimeMillis);
        verifyNoMoreInteractions(clock, metrics);
    }

    @Test
    public void requestSuccessOnNonHalfOpen() {
        FixedWindowMetrics metrics = mock(FixedWindowMetrics.class);
        Clock clock = mockClock();
        FixedWindowBreakStrategy strategy = new FixedWindowBreakStrategy(clock, createConfig());
        setMetrics(strategy, metrics);

        strategy.requestSuccess(productCode, regionCode, domain);

        // 验证
        verify(clock, times(1)).millis();
        verify(metrics, times(1)).requestSuccess(productCode, regionCode, domain, currentTimeMillis);
        verifyNoMoreInteractions(clock, metrics);
    }

    @Test
    public void attemptAccessWithBreakerClosed() {
        String domain1Unstated = "domain-1";
        String domain2BreakerClosed = "domain-2";

        Clock clock = mockClock();
        FixedWindowBreakStrategy strategy = new FixedWindowBreakStrategy(clock, createConfig());

        // 预设熔断器状态
        // 初始状态下，域名熔断器的状态是 CLOSED
        Breaker breaker = new Breaker();
        breaker.lastBreakTimeMillis().set(System.currentTimeMillis());
        strategy.breakerMap().put("product-code-1:region-code-1:domain-2", breaker);

        // 验证
        assertTrue(strategy.attemptAccess(productCode, regionCode, domain1Unstated));
        assertTrue(strategy.attemptAccess(productCode, regionCode, domain2BreakerClosed));

        assertEquals(2, strategy.breakerMap().size());
        assertTrue(strategy.breakerMap().containsKey("product-code-1:region-code-1:domain-1"));
        assertTrue(strategy.breakerMap().containsKey("product-code-1:region-code-1:domain-2"));

        verifyNoMoreInteractions(clock);
    }

    @Test
    public void attemptAccessWithInSleepWindow() {
        String domain1EqualsSleepTime = "domain-1";
        String domain2LessThanSleepTime = "domain-2";

        Clock clock = mockClock();
        FixedWindowBreakStrategy strategy = new FixedWindowBreakStrategy(clock, createConfig());

        // 预设熔断器状态
        Breaker breaker1 = new Breaker();
        breaker1.status().set(BreakerStatusEnum.OPEN);
        breaker1.lastBreakTimeMillis().set(currentTimeMillis - circuitBreakerSleepWindowMillis);
        strategy.breakerMap().put("product-code-1:region-code-1:domain-1", breaker1);

        Breaker breaker2 = new Breaker();
        breaker2.status().set(BreakerStatusEnum.OPEN);
        breaker2.lastBreakTimeMillis().set(currentTimeMillis - circuitBreakerSleepWindowMillis + 1);
        strategy.breakerMap().put("product-code-1:region-code-1:domain-2", breaker2);

        // 验证
        assertFalse(strategy.attemptAccess(productCode, regionCode, domain1EqualsSleepTime));
        assertFalse(strategy.attemptAccess(productCode, regionCode, domain2LessThanSleepTime));

        verify(clock, times(2)).millis();
        verifyNoMoreInteractions(clock);
    }

    @Test
    public void attemptAccessAfterSleepWindow() {
        Clock clock = mockClock();
        FixedWindowBreakStrategy strategy = new FixedWindowBreakStrategy(clock, createConfig());

        // 预设熔断器状态
        Breaker breaker = new Breaker();
        breaker.status().set(BreakerStatusEnum.OPEN);
        breaker.lastBreakTimeMillis().set(currentTimeMillis - circuitBreakerSleepWindowMillis - 1);
        strategy.breakerMap().put(breakerKey, breaker);

        // 验证
        // 第1次允许访问
        assertTrue(strategy.attemptAccess(productCode, regionCode, domain));
        // 此后不允许访问
        assertFalse(strategy.attemptAccess(productCode, regionCode, domain));
        assertFalse(strategy.attemptAccess(productCode, regionCode, domain));

        verify(clock, times(3)).millis();
        verifyNoMoreInteractions(clock);
    }

    @Test
    public void testGetterSetter() {
        Clock clock = mock(Clock.class);
        FixedWindowBreakStrategy.Config config = createConfig();
        FixedWindowBreakStrategy strategy = new FixedWindowBreakStrategy(clock, config);

        assertSame(clock, strategy.clock());
        assertSame(clock, strategy.getClock());

        assertEquals(statWindowMillis, strategy.statWindowMillis());
        assertEquals(statWindowMillis, strategy.getStatWindowMillis());

        assertEquals(circuitBreakerFailThresholdPercentage, strategy.circuitBreakerFailThresholdPercentage());
        assertEquals(circuitBreakerFailThresholdPercentage, strategy.getCircuitBreakerFailThresholdPercentage());

        assertEquals(circuitBreakerRequestVolumeThreshold, strategy.circuitBreakerRequestVolumeThreshold());
        assertEquals(circuitBreakerRequestVolumeThreshold, strategy.getCircuitBreakerRequestVolumeThreshold());

        assertEquals(circuitBreakerSleepWindowMillis, strategy.circuitBreakerSleepWindowMillis());
        assertEquals(circuitBreakerSleepWindowMillis, strategy.getCircuitBreakerSleepWindowMillis());

        try {
            Object statMap = FieldUtils.readField(strategy, "metrics", true);
            assertSame(statMap, strategy.metrics());
            assertSame(statMap, strategy.getMetrics());

            Object breakTimeMap = FieldUtils.readField(strategy, "breakerMap", true);
            assertSame(breakTimeMap, strategy.breakerMap());
            assertSame(breakTimeMap, strategy.getBreakerMap());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testConstructor() {
        FixedWindowBreakStrategy strategy = FixedWindowBreakStrategy.createDefault();

        assertEquals(Clock.systemDefaultZone(), strategy.clock());

        assertEquals(FixedWindowBreakStrategy.Config.DEFAULT_STAT_WINDOW_MILLIS, strategy.statWindowMillis());

        assertEquals(FixedWindowBreakStrategy.Config.DEFAULT_CIRCUIT_BREAKER_FAIL_THRESHOLD_PERCENTAGE,
                strategy.circuitBreakerFailThresholdPercentage());

        assertEquals(FixedWindowBreakStrategy.Config.DEFAULT_CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,
                strategy.circuitBreakerRequestVolumeThreshold());

        assertEquals(FixedWindowBreakStrategy.Config.DEFAULT_CIRCUIT_BREAKER_SLEEP_WINDOW_MILLIS,
                strategy.circuitBreakerSleepWindowMillis());
    }

    private static Clock mockClock() {
        Clock clock = mock(Clock.class);
        when(clock.millis()).thenReturn(currentTimeMillis);
        return clock;
    }

    private static FixedWindowBreakStrategy.Config createConfig() {
        return new FixedWindowBreakStrategy.Config()
                .statWindowMillis(statWindowMillis)
                .circuitBreakerFailThresholdPercentage(circuitBreakerFailThresholdPercentage)
                .circuitBreakerRequestVolumeThreshold(circuitBreakerRequestVolumeThreshold)
                .circuitBreakerSleepWindowMillis(circuitBreakerSleepWindowMillis);
    }

    private static void setMetrics(FixedWindowBreakStrategy strategy, FixedWindowMetrics metrics) {
        try {
            Field field = FieldUtils.getField(FixedWindowBreakStrategy.class, "metrics", true);
            Field modifiersField = FieldUtils.getDeclaredField(Field.class, "modifiers", true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            FieldUtils.writeField(strategy, "metrics", metrics, true);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
