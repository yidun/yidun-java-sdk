package com.netease.yidun.sdk.core.utils;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UrlUtilsTest {

    @Test
    public void encodeString() {
        assertEquals("%E4%B8%AD%E6%96%87", UrlUtils.encode("中文"));
    }

    @Test
    public void encodeMap() {
        Map<String, String> map = new HashMap<>();
        map.put(null, "null-key");
        map.put("", "empty-key");
        map.put(" ", "blank-key");
        map.put("参1", "1");
        map.put("param2", "值2");
        map.put("参3", "值3");
        map.put("param4", "b");
        map.put("param5", null);
        map.put("param6", "");

        String expectedValue = "" +
                "+=blank-key" +
                "&param5" +
                "&param6" +
                "&%E5%8F%821=1" +
                "&%E5%8F%823=%E5%80%BC3" +
                "&param4=b" +
                "&param2=%E5%80%BC2";

        assertEquals(expectedValue, UrlUtils.encode(map));
    }
}
