package com.netease.yidun.sdk.core.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ObjectUtilsTest {

    @Test
    public void defaultIfNull() {
        assertEquals(Integer.valueOf(1), ObjectUtils.defaultIfNull(1, 2));
        assertEquals(Integer.valueOf(2), ObjectUtils.defaultIfNull(null, 2));
    }
}
