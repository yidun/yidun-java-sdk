/*
 * @(#) IRiskCheckV603Result.java 2023-12-05
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.irisk.v6.check.v603;

import com.netease.yidun.sdk.irisk.v6.check.abst.ip.AbstractIpInfo;
import com.netease.yidun.sdk.irisk.v6.check.abst.phone.AbstractPhoneInfo;
import com.netease.yidun.sdk.irisk.v6.check.v600.IRiskCheckV600Result;
import com.netease.yidun.sdk.irisk.v6.check.v602.HitInfoV602;

/**
 * @author guantihua
 * @version 2023-12-05
 */
public class IRiskCheckV603Result<H extends HitInfoV602, P extends AbstractPhoneInfo, I extends AbstractIpInfo>
        extends IRiskCheckV600Result<H> {

    private String pcId;

    private P phoneInfo;

    private I ipInfo;

    private Integer action;

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    public P getPhoneInfo() {
        return phoneInfo;
    }

    public void setPhoneInfo(P phoneInfo) {
        this.phoneInfo = phoneInfo;
    }

    public I getIpInfo() {
        return ipInfo;
    }

    public void setIpInfo(I ipInfo) {
        this.ipInfo = ipInfo;
    }

    @Override
    public String toString() {
        return "IRiskCheckV603Result{" +
                "super=" + super.toString() +
                "pcId='" + pcId + '\'' +
                ", phoneInfo=" + phoneInfo +
                ", ipInfo=" + ipInfo +
                ", action=" + action +
                '}';
    }
}
