/*
 * @(#) RiskResult.java 2022-04-24
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.profile.v1.riskquery;

import com.netease.yidun.sdk.profile.v1.common.AccountDetail;
import com.netease.yidun.sdk.profile.v1.common.PhoneDetail;
import com.netease.yidun.sdk.profile.v1.common.IpDetail;

public class ProfileRiskResult {

    /**
     * 账号风险画像详情
     */
    private AccountDetail accountDetail;

    /**
     * 手机号风险画像详情
     */
    private PhoneDetail phoneDetail;

    /**
     * ip风险画像详情
     */
    private IpDetail ipDetail;


    public AccountDetail getAccountDetail() {
        return accountDetail;
    }

    public void setAccountDetail(AccountDetail accountDetail) {
        this.accountDetail = accountDetail;
    }

    public PhoneDetail getPhoneDetail() {
        return phoneDetail;
    }

    public void setPhoneDetail(PhoneDetail phoneDetail) {
        this.phoneDetail = phoneDetail;
    }

    public IpDetail getIpDetail() {
        return ipDetail;
    }

    public void setIpDetail(IpDetail ipDetail) {
        this.ipDetail = ipDetail;
    }
}
