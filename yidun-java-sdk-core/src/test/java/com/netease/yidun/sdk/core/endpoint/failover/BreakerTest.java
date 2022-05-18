package com.netease.yidun.sdk.core.endpoint.failover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;

public class BreakerTest {

    @Test
    public void testDefaultValue() {
        Breaker breaker = new Breaker();

        assertEquals(BreakerStatusEnum.CLOSED, breaker.status().get());
        assertEquals(-1, breaker.lastBreakTimeMillis().get());
    }

    @Test
    public void testToString() {
        String expectedStr = "Breaker(status=CLOSED, lastBreakTimeMillis=-1)";
        Breaker breaker = new Breaker();

        assertEquals(expectedStr, breaker.toString());
    }

    @Test
    public void testGetterSetter() throws IllegalAccessException {
        Breaker breaker = new Breaker();

        Object status = FieldUtils.readField(breaker, "status", true);
        Object lastBreakTimeMillis = FieldUtils.readField(breaker, "lastBreakTimeMillis", true);

        assertSame(status, breaker.status());
        assertSame(status, breaker.getStatus());
        assertSame(lastBreakTimeMillis, breaker.lastBreakTimeMillis());
        assertSame(lastBreakTimeMillis, breaker.getLastBreakTimeMillis());
    }
}
