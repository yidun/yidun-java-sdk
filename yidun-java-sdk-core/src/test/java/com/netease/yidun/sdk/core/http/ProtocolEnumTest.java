package com.netease.yidun.sdk.core.http;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProtocolEnumTest {

    @Test
    public void testToString() {
        assertEquals("http", ProtocolEnum.HTTP.toString());
        assertEquals("https", ProtocolEnum.HTTPS.toString());
    }
}
