package com.netease.yidun.sdk.core.endpoint.failover;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MetricsDataTest {

    @Test
    public void testToString() {
        String expectedStr = "MetricsData(successCount=1, failCount=2)";
        MetricsData data = new MetricsData(1, 2);
        assertEquals(expectedStr, data.toString());
    }

    @Test
    public void testGetter() {
        MetricsData data = new MetricsData(3, 4);

        assertEquals(3, data.successCount());
        assertEquals(3, data.getSuccessCount());
        assertEquals(4, data.failCount());
        assertEquals(4, data.getFailCount());
    }
}
