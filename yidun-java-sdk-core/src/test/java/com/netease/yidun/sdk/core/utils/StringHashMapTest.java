package com.netease.yidun.sdk.core.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class StringHashMapTest {

    @Test
    public void putBlankKey() {
        StringHashMap map = new StringHashMap();

        String r = map.put(" ", "1");

        assertNull(r);
        assertEquals(0, map.size());
    }

    @Test
    public void putBlankValue() {
        StringHashMap map = new StringHashMap();

        String r = map.put("a", " ");

        assertNull(r);
        assertEquals(0, map.size());
    }

    @Test
    public void putCommonString() {
        StringHashMap map = new StringHashMap();

        String r = map.put("a", "1");
        assertNull(r);
        assertEquals(1, map.size());
        assertEquals("1", map.get("a"));

        r = map.put("a", "2");
        assertEquals("1", r);
        assertEquals(1, map.size());
        assertEquals("2", map.get("a"));
    }

    @Test
    public void putNullObject() {
        StringHashMap map = new StringHashMap();

        String r = map.put("a", (Object) null);

        assertNull(r);
        assertEquals(0, map.size());
    }

    @Test
    public void putNonNullObject() {
        Object obj = mock(Object.class);
        when(obj.toString()).thenReturn("str-1");

        StringHashMap map = new StringHashMap();

        map.put("a", obj);

        assertEquals(1, map.size());
        assertEquals("str-1", map.get("a"));
    }
}
