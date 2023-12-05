/*
 * @(#) PhoneBasicInfo.java 2023-11-15
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.irisk.v6.check.v603.phone;

import java.io.Serializable;

import com.netease.yidun.sdk.irisk.v6.check.abst.phone.AbstractPhoneBasicInfo;


public class PhoneBasicInfo  extends AbstractPhoneBasicInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 运营商
     */
    private String carrier;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "PhoneBasicInfo{" +
                "carrier='" + carrier + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
