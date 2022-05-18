package com.netease.yidun.sdk.core.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayUtilsTest {

    @Test
    public void isEmpty() {
        assertTrue(ArrayUtils.isEmpty(null));
        assertTrue(ArrayUtils.isEmpty(new Object[0]));
        assertFalse(ArrayUtils.isEmpty(new Object[1]));
    }

    @Test
    public void getLength() {
        assertEquals(0, ArrayUtils.getLength(null));
        assertEquals(0, ArrayUtils.getLength(new Object[0]));
        assertEquals(1, ArrayUtils.getLength(new Object[1]));
        assertEquals(2, ArrayUtils.getLength(new Object[2]));
    }
}
