package com.netease.yidun.sdk.core.endpoint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.netease.yidun.sdk.core.exception.YidunSdkException;

public class AbstractEndpointResolverTest {

    private String productCode = "product-code-1";
    private String regionCode = "region-code-1";
    private List<String> domainList = Arrays.asList("a.b.c", "x.y.z");
    private Map<String, List<String>> domainMap = Collections.singletonMap("product-code-1:region-code-1", domainList);
    private TestResolver resolver = new TestResolver(domainMap);

    @Test
    public void testExist() {
        List<String> actualDomains = resolver.resolve(productCode, regionCode);
        assertSame(domainList, actualDomains);
    }

    @Test
    public void testNonExist() {
        String nonExistRegion = "non-exist-region-404";
        String expectedMsg = "No available domain. productCode=product-code-1, regionCode=non-exist-region-404";

        YidunSdkException e = null;
        try {
            resolver.resolve(productCode, nonExistRegion);
        } catch (YidunSdkException ex) {
            e = ex;
        }

        assertEquals(expectedMsg, e.getMessage());
    }

    private static class TestResolver extends AbstractEndpointResolver {

        protected TestResolver(Map<String, List<String>> domainMap) {
            super(domainMap);
        }
    }
}
