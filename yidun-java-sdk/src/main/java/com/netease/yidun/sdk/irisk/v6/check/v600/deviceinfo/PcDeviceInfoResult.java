package com.netease.yidun.sdk.irisk.v6.check.v600.deviceinfo;

import lombok.Data;

@Data
public class PcDeviceInfoResult {
    /**
     * 设备物理地址
     */
    private String mac;

    /**
     * 设备标识符
     */
    private String guid;

    /**
     * 设备系统版本
     */
    private String osVersion;

    /**
     * 屏幕分辨率
     */
    private String screenResolution;

    /**
     * 操作系统型号信息
     */
    private String osType;

    /**
     * 计算机名
     */
    private String computerName;

    /**
     * 设备制造商
     */
    private String manufacturer;

    /**
     * 操作系统名称
     */
    private String osName;
}
