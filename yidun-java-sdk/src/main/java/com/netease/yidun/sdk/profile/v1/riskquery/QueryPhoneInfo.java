package com.netease.yidun.sdk.profile.v1.riskquery;

import java.util.List;

public class QueryPhoneInfo {
    private String businessKey;
    private List<String> phones;

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
