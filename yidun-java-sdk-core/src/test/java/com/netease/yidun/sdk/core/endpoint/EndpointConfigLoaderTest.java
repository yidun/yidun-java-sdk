package com.netease.yidun.sdk.core.endpoint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class EndpointConfigLoaderTest {

    @Test
    public void loadFromResourceFiles() {
        Map<String, Map<String, List<String>>> domainMap = EndpointConfigLoader.loadFromResourceFiles();

        assertEquals(3, domainMap.size());

        Map<String, List<String>> prodEntry1 = domainMap.get("test-product-1");
        assertEquals(1, prodEntry1.size());
        assertEquals(Collections.singletonList("test-domain-1"),
                prodEntry1.get("test-region-1"));

        Map<String, List<String>> prodEntry2 = domainMap.get("test-product-2");
        assertEquals(1, prodEntry2.size());
        assertEquals(Arrays.asList("test-domain-2", "test-domain-2-2"),
                prodEntry2.get("test-region-2"));

        Map<String, List<String>> prodEntry3 = domainMap.get("test-product-3");
        assertEquals(2, prodEntry3.size());
        assertEquals(Collections.singletonList("test-domain-3"),
                prodEntry3.get("test-region-3"));
        assertEquals(Collections.singletonList("test-domain-3-2"),
                prodEntry3.get("test-region-3-2"));
    }

    @Test
    public void load() {
        Map<String, Map<String, List<String>>> domainMap = EndpointConfigLoader
                .load(createValidConfigFileEnumeration());

        assertEquals(4, domainMap.size());

        Map<String, List<String>> prod1 = domainMap.get("test-product-1");
        assertEquals(1, prod1.size());
        assertEquals(Collections.singletonList("test-domain-1"),
                prod1.get("test-region-1"));

        Map<String, List<String>> prod2 = domainMap.get("test-product-2");
        assertEquals(1, prod2.size());
        assertEquals(Arrays.asList("test-domain-2", "test-domain-2-2"),
                prod2.get("test-region-2"));

        Map<String, List<String>> prod3 = domainMap.get("test-product-3");
        assertEquals(2, prod3.size());
        assertEquals(Arrays.asList("test-domain-3", "another-test-domain-3"),
                prod3.get("test-region-3"));
        assertEquals(Collections.singletonList("test-domain-3-2"),
                prod3.get("test-region-3-2"));

        Map<String, List<String>> prodAnother = domainMap.get("another-test-product-a");
        assertEquals(1, prodAnother.size());
        assertEquals(Collections.singletonList("another-test-domain-a"),
                prodAnother.get("another-test-region-a"));
    }

    @Test
    public void loadBlankConfigFile() {
        Enumeration<URL> configFileEnumeration = createConfigFileEnumeration("blank_yidun_regional_endpoints.json");

        Map<String, Map<String, List<String>>> domainMap = EndpointConfigLoader.load(configFileEnumeration);

        assertTrue(domainMap.isEmpty());
    }

    @Test
    public void loadInvalidFormatConfigFile() {
        Enumeration<URL> configFileEnumeration = createConfigFileEnumeration(
                "invalid_format_yidun_regional_endpoints.json");

        Map<String, Map<String, List<String>>> domainMap = EndpointConfigLoader.load(configFileEnumeration);

        assertTrue(domainMap.isEmpty());
    }

    @Test
    public void mergeNewAsTail() {
        testMergeOrder(false);
    }

    @Test
    public void mergeNewAsHead() {
        testMergeOrder(true);
    }

    private void testMergeOrder(boolean newDomainFirst) {
        Map<String, Map<String, List<String>>> existingDomainMap = new HashMap<String, Map<String, List<String>>>() {
            {
                put("p1", new HashMap<String, List<String>>() {
                    {
                        put("r1", new ArrayList<>(Collections.singleton("d1")));
                    }
                });
            }
        };
        Collection<EndpointConfigEntry> newEntries = new ArrayList<EndpointConfigEntry>() {
            {
                add(new EndpointConfigEntry("p1", "r1", Collections.singletonList("d2")));
            }
        };

        if (newDomainFirst) {
            EndpointConfigLoader.mergeConfig(existingDomainMap, newEntries, true);
        } else {
            EndpointConfigLoader.mergeConfig(existingDomainMap, newEntries);
        }

        List<String> mergedDomains = existingDomainMap.get("p1").get("r1");

        assertEquals(2, mergedDomains.size());

        if (newDomainFirst) {
            assertEquals("d2", mergedDomains.get(0));
            assertEquals("d1", mergedDomains.get(1));
        } else {
            assertEquals("d1", mergedDomains.get(0));
            assertEquals("d2", mergedDomains.get(1));
        }
    }

    private static Enumeration<URL> createValidConfigFileEnumeration() {
        return createConfigFileEnumeration(
                "yidun_regional_endpoints.json",
                "another_yidun_regional_endpoints.json");
    }

    private static Enumeration<URL> createConfigFileEnumeration(String... configFileNames) {
        ClassLoader classLoader = EndpointConfigLoader.class.getClassLoader();

        Iterator<URL> urlIterator = Arrays.stream(configFileNames)
                .map(classLoader::getResource)
                .iterator();

        return new Enumeration<URL>() {
            @Override
            public boolean hasMoreElements() {
                return urlIterator.hasNext();
            }

            @Override
            public URL nextElement() {
                return urlIterator.next();
            }
        };
    }
}
