package com.netease.yidun.sdk.profile.v1.riskquery;

import java.util.List;

public class QueryAccountInfo {
    private String businessKey;
    private List<String> accounts;

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }
}
