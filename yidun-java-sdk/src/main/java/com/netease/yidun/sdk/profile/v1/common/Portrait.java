/*
 * @(#) Portrait.java 2022-06-09
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.profile.v1.common;

import com.netease.yidun.sdk.profile.v1.riskquery.QueryAccountInfo;
import com.netease.yidun.sdk.profile.v1.riskquery.QueryIpInfo;
import com.netease.yidun.sdk.profile.v1.riskquery.QueryPhoneInfo;

public class Portrait {
    /**
     * 手机号
     */
    private QueryPhoneInfo queryPhoneInfo;
    /**
     * 账号
     */
    private QueryAccountInfo queryAccountInfo;
    /**
     * ip
     */
    private QueryIpInfo queryIpInfo;

    public QueryPhoneInfo getQueryPhoneInfo() {
        return queryPhoneInfo;
    }

    public void setQueryPhoneInfo(QueryPhoneInfo queryPhoneInfo) {
        this.queryPhoneInfo = queryPhoneInfo;
    }

    public QueryAccountInfo getQueryAccountInfo() {
        return queryAccountInfo;
    }

    public void setQueryAccountInfo(QueryAccountInfo queryAccountInfo) {
        this.queryAccountInfo = queryAccountInfo;
    }

    public QueryIpInfo getQueryIpInfo() {
        return queryIpInfo;
    }

    public void setQueryIpInfo(QueryIpInfo queryIpInfo) {
        this.queryIpInfo = queryIpInfo;
    }
}
