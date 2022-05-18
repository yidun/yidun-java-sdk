package com.netease.yidun.sdk.core.endpoint.failover;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FixedWindowBreakStrategyConfigTest {

    @Test
    public void testDefault() {
        FixedWindowBreakStrategy.Config config = new FixedWindowBreakStrategy.Config();

        assertEquals(600000, config.statWindowMillis());
        assertEquals(40, config.circuitBreakerFailThresholdPercentage());
        assertEquals(50, config.circuitBreakerRequestVolumeThreshold());
        assertEquals(1200000, config.circuitBreakerSleepWindowMillis());
    }

    @Test
    public void testGetterSetter() {
        FixedWindowBreakStrategy.Config config = new FixedWindowBreakStrategy.Config();

        config.setStatWindowMillis(10);
        config.setCircuitBreakerFailThresholdPercentage(20);
        config.setCircuitBreakerRequestVolumeThreshold(30);
        config.setCircuitBreakerSleepWindowMillis(40);

        assertEquals(10, config.getStatWindowMillis());
        assertEquals(20, config.getCircuitBreakerFailThresholdPercentage());
        assertEquals(30, config.getCircuitBreakerRequestVolumeThreshold());
        assertEquals(40, config.getCircuitBreakerSleepWindowMillis());
    }

    @Test
    public void testFluentGetterSetter() {
        FixedWindowBreakStrategy.Config config = new FixedWindowBreakStrategy.Config()
                .statWindowMillis(10)
                .circuitBreakerFailThresholdPercentage(20)
                .circuitBreakerRequestVolumeThreshold(30)
                .circuitBreakerSleepWindowMillis(40);

        assertEquals(10, config.statWindowMillis());
        assertEquals(20, config.circuitBreakerFailThresholdPercentage());
        assertEquals(30, config.circuitBreakerRequestVolumeThreshold());
        assertEquals(40, config.getCircuitBreakerSleepWindowMillis());
    }
}
