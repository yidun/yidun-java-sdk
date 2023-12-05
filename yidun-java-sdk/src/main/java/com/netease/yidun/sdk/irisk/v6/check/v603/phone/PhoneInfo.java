/*
 * @(#) PhoneInfo.java 2023-11-15
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.irisk.v6.check.v603.phone;

import com.netease.yidun.sdk.irisk.v6.check.abst.phone.AbstractPhoneBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.abst.phone.AbstractPhoneInfo;

public class PhoneInfo<B extends AbstractPhoneBasicInfo, R extends PhoneRiskInfo>  extends AbstractPhoneInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private B basicInfo;

    private R phoneRiskInfo;

    public B getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(B basicInfo) {
        this.basicInfo = basicInfo;
    }

    public R getPhoneRiskInfo() {
        return phoneRiskInfo;
    }

    public void setPhoneRiskInfo(R phoneRiskInfo) {
        this.phoneRiskInfo = phoneRiskInfo;
    }

    @Override
    public String toString() {
        return "PhoneInfo(" +
                "basicInfo=" + basicInfo +
                ", phoneRiskInfo=" + phoneRiskInfo +
                ')';
    }
}
