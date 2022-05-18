package com.netease.yidun.sdk.core.endpoint;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class CompoundEndpointResolverTest {

    private static final String productCode = "test-product-1";
    private static final String regionCode = "test-region-1";
    private static final String specifiedDomain = "domain-x";

    @Test
    public void test() {
        assertEndpoint(new CompoundEndpointResolver(productCode, regionCode, specifiedDomain));

        assertEndpoint(new CompoundEndpointResolver(productCode, regionCode, Collections.singleton(specifiedDomain)));

        assertEndpoint(new CompoundEndpointResolver(
                new EndpointConfigEntry()
                        .productCode(productCode)
                        .regionCode(regionCode)
                        .domains(Collections.singletonList(specifiedDomain))));

        assertEndpoint(new CompoundEndpointResolver(
                Collections.singleton(
                        new EndpointConfigEntry()
                                .productCode(productCode)
                                .regionCode(regionCode)
                                .domains(Collections.singletonList(specifiedDomain)))));
    }

    private static void assertEndpoint(CompoundEndpointResolver resolver) {
        List<String> domains = resolver.resolve(productCode, regionCode);
        assertEquals(2, domains.size());
        assertEquals(specifiedDomain, domains.get(0));
        assertEquals("test-domain-1", domains.get(1));
    }
}
