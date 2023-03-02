package com.netease.yidun.sdk.profile.v1.ipquery;

import com.netease.yidun.sdk.profile.v1.common.IpLocation;

public class IpPropDetails {
    /**
     * ip地址信息
     */
    private IpLocation ipLocation;

    public IpLocation getIpLocation() {
        return ipLocation;
    }

    public void setIpLocation(IpLocation ipLocation) {
        this.ipLocation = ipLocation;
    }

}