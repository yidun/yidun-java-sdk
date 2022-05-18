package com.netease.yidun.sdk.core.endpoint;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class DefaultEndpointResolverTest {

    @Test
    public void test() {
        test("test-product-1", "test-region-1", Collections.singletonList("test-domain-1"));

        test("test-product-2", "test-region-2", Arrays.asList("test-domain-2", "test-domain-2-2"));

        test("test-product-3", "test-region-3", Collections.singletonList("test-domain-3"));

        test("test-product-3", "test-region-3-2", Collections.singletonList("test-domain-3-2"));
    }

    private void test(String productCode, String regionCode, List<String> expectedDomains) {
        List<String> actualDomains = DefaultEndpointResolver
                .getInstance()
                .resolve(productCode, regionCode);

        assertEquals(expectedDomains, actualDomains);
    }
}
