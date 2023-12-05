/*
 * @(#) IpInfo.java 2023-11-15
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.irisk.v6.check.v603.ip;

import java.io.Serializable;

import com.netease.yidun.sdk.irisk.v6.check.abst.ip.AbstractIpBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.abst.ip.AbstractIpInfo;
import com.netease.yidun.sdk.irisk.v6.check.abst.ip.AbstractIpRiskInfo;

public class IpInfo<B extends AbstractIpBasicInfo,R extends AbstractIpRiskInfo>  extends AbstractIpInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private B basicInfo;

    private R ipRiskInfo;

    public B getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(B basicInfo) {
        this.basicInfo = basicInfo;
    }

    public R getIpRiskInfo() {
        return ipRiskInfo;
    }

    public void setIpRiskInfo(R ipRiskInfo) {
        this.ipRiskInfo = ipRiskInfo;
    }

    @Override
    public String toString() {
        return "IpInfo{" +
                "basicInfo=" + basicInfo +
                ", ipRiskInfo=" + ipRiskInfo +
                '}';
    }
}
