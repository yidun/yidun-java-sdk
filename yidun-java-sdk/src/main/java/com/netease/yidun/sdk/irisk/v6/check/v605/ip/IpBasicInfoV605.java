/*
 * @(#) IpBasicInfoV605.java 2026-09-23
 *
 * Copyright 2026 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.irisk.v6.check.v605.ip;

import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpBasicInfo;

import java.io.Serializable;

public class IpBasicInfoV605 extends IpBasicInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 行政区码，如440305表示深圳南山区
     */
    private String areaCode;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return "IpBasicInfoV605{" +
                "super=" + super.toString() +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}
