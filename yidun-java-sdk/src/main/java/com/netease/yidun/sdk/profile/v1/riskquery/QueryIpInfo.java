package com.netease.yidun.sdk.profile.v1.riskquery;

import java.util.List;

public class QueryIpInfo {
    private String businessKey;
    private List<String> ips;

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public List<String> getIps() {
        return ips;
    }

    public void setIps(List<String> ips) {
        this.ips = ips;
    }
}
