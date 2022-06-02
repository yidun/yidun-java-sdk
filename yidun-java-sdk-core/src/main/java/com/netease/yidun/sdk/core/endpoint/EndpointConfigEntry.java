

package com.netease.yidun.sdk.core.endpoint;

import java.util.ArrayList;
import java.util.List;

public class EndpointConfigEntry {

    private String productCode;
    private String regionCode;
    private List<String> domains;

    public EndpointConfigEntry() {
    }

    public EndpointConfigEntry(String productCode, String regionCode, List<String> domains) {
        this.productCode = productCode;
        this.regionCode = regionCode;
        this.domains = domains;
    }

    public String getProductCode() {
        return productCode;
    }

    public String productCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public EndpointConfigEntry productCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String regionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public EndpointConfigEntry regionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public List<String> getDomains() {
        return domains;
    }

    public List<String> domains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public EndpointConfigEntry domains(List<String> domains) {
        this.domains = domains;
        return this;
    }

    public EndpointConfigEntry domain(String domain) {
        if (domains == null) {
            domains = new ArrayList<>();
        }
        domains.add(domain);
        return this;
    }

    @Override
    public String toString() {
        return "EndpointConfigEntry(" +
                "productCode=" + productCode +
                ", regionCode=" + regionCode +
                ", domains=" + domains +
                ")";
    }
}
