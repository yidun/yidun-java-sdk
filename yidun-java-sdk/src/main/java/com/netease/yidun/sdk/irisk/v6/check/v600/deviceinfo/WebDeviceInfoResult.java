package com.netease.yidun.sdk.irisk.v6.check.v600.deviceinfo;

import lombok.Data;


@Data
public class WebDeviceInfoResult {


    /**
     * web类型
     */
    private Integer runEnvType;

    /**
     * 浏览器标识信息
     */
    private String userAgent;

    /**
     * 浏览器的语言设置
     */
    private String language;

    /**
     * 浏览器所在设备的系统类型
     */
    private String platform;

    /**
     * 地址栏当前url
     */
    private String url;

    /**
     * 屏幕尺寸
     */
    private String screenResolution;

    /**
     * 运营商设备标识
     */
    private String uaid;

}
