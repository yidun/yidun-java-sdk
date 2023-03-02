package com.netease.yidun.sdk.profile.v1.phonequery;

import com.netease.yidun.sdk.profile.v1.common.ChildPropInfo;
import com.netease.yidun.sdk.profile.v1.common.PhoneLocation;

public class PhonePropDetails {

    /**
     * 未成年人标签详情
     */
    private ChildPropInfo under18;

    /**
     * 手机号信息
     */
    private PhoneLocation phoneLocation;


    public ChildPropInfo getUnder18() {
        return under18;
    }

    public void setUnder18(ChildPropInfo under18) {
        this.under18 = under18;
    }

    public PhoneLocation getPhoneLocation() {
        return phoneLocation;
    }

    public void setPhoneLocation(PhoneLocation phoneLocation) {
        this.phoneLocation = phoneLocation;
    }

}