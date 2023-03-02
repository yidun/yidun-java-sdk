/*
 * @(#) PhoneLocation.java 2022-08-01
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.profile.v1.common;

public class PhoneLocation {

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
}
