package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;

public class ImageV5UserRiskDetail implements Serializable {
    private static final long serialVersionUID = -7942244764008363902L;
    /**
     * 账号
     */
    private String account;
    /**
     * 用户账号风险级别
     */
    private Integer accountLevel;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(Integer accountLevel) {
        this.accountLevel = accountLevel;
    }
}
