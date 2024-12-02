package com.netease.yidun.sdk.irisk.v6.check.v600.deviceinfo;

import lombok.Data;

import java.util.List;


@Data
public class IosDeviceInfo {
    /**
     * 开机时间
     */
    private String bootTime;

    /**
     * 硬盘大小，单位字节
     */
    private String totalDiskSpace;

    /**
     * 非完美越狱失效状态
     */
    private Integer auxo;

    /**
     * mac序列号
     */
    private String macSerialnumber;

    /**
     * 0:未开启电池权限
     */
    private String chargeStatus;

    /**
     * 客户端本地随机生成的设备ID
     */
    private String deviceId;

    /**
     * 是否安装CydiaSubstrate
     */
    private Integer isCydiaSubstrate;

    /**
     * 是否有反越狱插件
     */
    private Integer isAntiJailbreak;

    /**
     * 总内存，单位字节
     */
    private String totalMemory;

    /**
     * 手机操作系统版本
     */
    private String osVersion;

    /**
     * 运营商名称
     */
    private String carrierName;

    /**
     * 手机型号
     */
    private String model;

    /**
     * 当前电量信息
     */
    private String batteryLevel;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * iOS设备标识符
     */
    private String idfv;

    /**
     * 运营商设备标识
     */
    private String uaid;

    /**
     * cpu 使用率
     */
    private String cpuUseRate;

    /**
     * 网络连接类型
     */
    private Integer networkType;

    /**
     * 动态加载库
     */
    private List<String> loadedDyLibsInfo;

    /**
     * 设备的屏幕宽度
     */
    private String screenWidth;

    /**
     * 设备的屏幕高度
     */
    private String screenHeight;
}
