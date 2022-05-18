package com.netease.yidun.sdk.core.endpoint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class EndpointMapUtilsTest {

    @Test
    public void flatKey() {
        List<String> domainList11 = new ArrayList<>();
        List<String> domainList12 = new ArrayList<>();
        List<String> domainList21 = new ArrayList<>();
        Map<String, Map<String, List<String>>> map = new HashMap<String, Map<String, List<String>>>() {
            {
                put("p1", new HashMap<String, List<String>>() {
                    {
                        put("r1-1", domainList11);
                        put("r1-2", domainList12);
                    }
                });
                put("p2", new HashMap<String, List<String>>() {
                    {
                        put("r2-1", domainList21);
                    }
                });
            }
        };

        Map<String, List<String>> flattedMap = EndpointMapUtils.flatKey(map);

        assertEquals(3, flattedMap.size());
        assertSame(domainList11, flattedMap.get("p1:r1-1"));
        assertSame(domainList12, flattedMap.get("p1:r1-2"));
        assertSame(domainList21, flattedMap.get("p2:r2-1"));
    }

    @Test
    public void genDomainKey() {
        assertEquals("p:r", EndpointMapUtils.genDomainKey("p", "r"));
        assertEquals(":p:::r:", EndpointMapUtils.genDomainKey(":p:", ":r:"));
    }
}
