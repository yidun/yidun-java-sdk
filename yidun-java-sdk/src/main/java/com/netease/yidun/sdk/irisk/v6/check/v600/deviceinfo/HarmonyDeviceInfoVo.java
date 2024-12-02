package com.netease.yidun.sdk.irisk.v6.check.v600.deviceinfo;

import lombok.Data;


@Data
public class HarmonyDeviceInfoVo {
    /**
     * 设备广告ID
     */
    private String oaid;

    /**
     * 应用广告ID
     */
    private String aaid;

    /**
     * 屏幕信息
     */
    private String screenInfo;

    /**
     * 设备cpu信息
     */
    private String cpuInfo;

    /**
     * 内部存储空间大小
     */
    private String memTotal;

    /**
     * 内部可用存储空间大小
     */
    private String memFree;

    /**
     * 设备语言设置
     */
    private String language;


    /**
     * 硬件设备类型，是平板、电视还是手机
     */
    private String deviceType;

    /**
     * 设备系统版本
     */
    private String osVersion;

    /**
     * 运营商设备标识
     */
    private String uaid;

}
