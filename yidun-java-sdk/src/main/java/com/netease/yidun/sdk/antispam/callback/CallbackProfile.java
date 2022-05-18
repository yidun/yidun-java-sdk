package com.netease.yidun.sdk.antispam.callback;

public class CallbackProfile {
    private static final Integer DEFAULT_CONCURRENCY = 3;

    /**
     * 回调的业务ID
     */
    private String businessId;
    /**
     * 获取回调数据的并发度
     */
    private Integer concurrency = DEFAULT_CONCURRENCY;

    public CallbackProfile() {
    }

    public CallbackProfile(String businessId) {
        this.businessId = businessId;
    }

    public CallbackProfile(String businessId, Integer concurrency) {
        this.businessId = businessId;
        this.concurrency = concurrency;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Integer getConcurrency() {
        return concurrency;
    }

    public void setConcurrency(Integer concurrency) {
        this.concurrency = concurrency;
    }
}
