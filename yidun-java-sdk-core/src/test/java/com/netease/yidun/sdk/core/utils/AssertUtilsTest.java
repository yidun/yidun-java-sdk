package com.netease.yidun.sdk.core.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AssertUtilsTest {

    @Test
    public void notBlank_for_blank_str() {
        IllegalArgumentException e = null;
        try {
            AssertUtils.notBlank(" ", "error-1");
        } catch (IllegalArgumentException ex) {
            e = ex;
        }

        assertEquals("error-1", e.getMessage());
    }

    @Test
    public void notBlank_for_non_blank_str() {
        AssertUtils.notBlank("1", "dummy");
    }
}
