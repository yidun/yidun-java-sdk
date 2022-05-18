package com.netease.yidun.sdk.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class YidunSdkExceptionTest {

    @Test
    public void testOnlyMessage() {
        String msg = "error-msg";

        YidunSdkException e = new YidunSdkException(msg);

        assertEquals(msg, e.getMessage());
        assertNull(e.getCause());
    }

    @Test
    public void testOnlyCause() {
        Throwable cause = new RuntimeException();

        YidunSdkException e = new YidunSdkException(cause);

        assertEquals(cause.toString(), e.getMessage());
        assertSame(cause, e.getCause());
    }

    @Test
    public void testMessageAndCause() {
        String msg = "error-msg";
        Throwable cause = new RuntimeException();

        YidunSdkException e = new YidunSdkException(msg, cause);

        assertEquals(msg, e.getMessage());
        assertSame(cause, e.getCause());
    }
}
