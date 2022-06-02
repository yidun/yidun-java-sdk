

package com.netease.yidun.sdk.core;

import static org.junit.Assert.assertEquals;

import com.netease.yidun.sdk.core.utils.ValidationUtils;

public class ValidationHelper {

    public static void testInvalidObject(Object obj, String expectedMsg) {
        IllegalArgumentException e = null;
        try {
            ValidationUtils.validate(obj);
        } catch (IllegalArgumentException ex) {
            e = ex;
        }

        assertEquals(expectedMsg, e.getMessage());
    }
}
