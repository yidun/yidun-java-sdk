package com.netease.yidun.sdk.core.endpoint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EndpointConfigEntryTest {

    private static final String productCode = "p1";
    private static final String regionCode = "r1";
    private static final List<String> domains = Arrays.asList("a.b.c", "x.y.z");

    @Test
    public void testAppendDomain() {
        String newDomain1 = "new1.a.b.c";
        String newDomain2 = "new2.a.b.c";

        EndpointConfigEntry entry = new EndpointConfigEntry()
                .domain(newDomain1)
                .domain(newDomain2);

        assertEquals(2, entry.domains().size());
        assertEquals(newDomain1, entry.domains().get(0));
        assertEquals(newDomain2, entry.domains().get(1));
    }

    @Test
    public void testGetterSetter() {
        EndpointConfigEntry entry = new EndpointConfigEntry()
                .productCode(productCode)
                .regionCode(regionCode)
                .domains(domains);

        assertEquals(productCode, entry.productCode());
        assertEquals(productCode, entry.getProductCode());
        assertEquals(regionCode, entry.regionCode());
        assertEquals(regionCode, entry.getRegionCode());
        assertSame(domains, entry.domains());
        assertSame(domains, entry.getDomains());

        entry.setProductCode(null);
        entry.setRegionCode(null);
        entry.setDomains(null);
        assertNull(entry.productCode());
        assertNull(entry.regionCode());
        assertNull(entry.domains());
    }

    @Test
    public void testConstructorWithParam() {
        EndpointConfigEntry entry = new EndpointConfigEntry(productCode, regionCode, domains);
        assertEquals(productCode, entry.productCode());
        assertEquals(regionCode, entry.regionCode());
        assertSame(domains, entry.domains());
    }

    @Test
    public void testEmptyConstructor() {
        EndpointConfigEntry entry = new EndpointConfigEntry();
        assertNull(entry.productCode());
        assertNull(entry.regionCode());
        assertNull(entry.domains());
    }

    @Test
    public void testToString() {
        String expectedStr = "EndpointConfigEntry(" +
                "productCode=p1" +
                ", regionCode=r1" +
                ", domains=[a.b.c, x.y.z]" +
                ")";

        EndpointConfigEntry entry = new EndpointConfigEntry(productCode, regionCode, domains);

        assertEquals(expectedStr, entry.toString());
    }
}
