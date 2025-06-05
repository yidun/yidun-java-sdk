package com.netease.yidun.sdk.irisk.v6.check.v600.deviceinfo;

import lombok.Data;


@Data
public class AppletDeviceInfoResult {
    /**
     * 当前小程序所在设备的联网类型
     */
    private String networkType;


    /**
     * 运行小程序的设备的品牌
     */
    private String brand;

    /**
     * 运行小程序的系统的平台类型
     */
    private String platform;

    /**
     * 小程序版本号
     */
    private String version;

    /**
     * 小程序类型
     */
    private Integer type;

    /**
     * 运营商设备标识
     */
    private String uaid;

}
