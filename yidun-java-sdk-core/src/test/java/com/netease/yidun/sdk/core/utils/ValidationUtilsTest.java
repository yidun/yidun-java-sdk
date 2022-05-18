package com.netease.yidun.sdk.core.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.junit.Test;

public class ValidationUtilsTest {

    @Test
    public void validate() {
        TestObject obj = new TestObject();

        IllegalArgumentException e = null;
        try {
            ValidationUtils.validate(obj);
        } catch (IllegalArgumentException ex) {
            e = ex;
        }

        String[] subMsgs = e.getMessage().split(". ");
        assertEquals(5, subMsgs.length);
        Set<String> subMsgSet = Arrays.stream(subMsgs).collect(Collectors.toSet());
        assertTrue(subMsgSet.contains("a不能为空"));
        assertTrue(subMsgSet.contains("b不能为null"));
        assertTrue(subMsgSet.contains("c的长度超出范围"));
        assertTrue(subMsgSet.contains("d的值太小"));
        assertTrue(subMsgSet.contains("e的值太大"));
    }

    private static class TestObject {
        @NotBlank(message = "a不能为空")
        private String a;

        @NotNull(message = "b不能为null")
        private String b;

        @Size(min = 1, max = 3, message = "c的长度超出范围")
        private String c = "";

        @Min(value = 1, message = "d的值太小")
        private int d;

        @Max(value = -1, message = "e的值太大")
        private int e;
    }
}
