package com.netease.yidun.sdk.irisk.v6.check.v600.deviceinfo;

import lombok.Data;


@Data
public class AndroidDeviceInfoResult {
    /**
     * 屏幕信息
     */
    private String screenInfo;

    /**
     * app版本号
     */
    private String appVersion;

    /**
     * 设备启动次数
     */
    private Integer bootCount;

    /**
     * 充电状态
     */
    private Integer chargeState;

    /**
     * 是否开启mac随机化
     */
    private Integer macRandom;

    /**
     * 屏幕亮度
     */
    private Integer screenBright;

    /**
     * adb是否开启
     */
    private Integer checkAdb;

    /**
     * 手机已启动时间
     */
    private String upTime;

    /**
     * Android版本
     */
    private String osVersion;

    /**
     * 运营商
     */
    private String carrierName;

    /**
     * 手机总锁屏时间
     */
    private String lockTime;

    /**
     * 是否是虚拟摄像头
     */
    private Integer isFakeCam;

    /**
     * 手机品牌
     */
    private String phoneBrand;

    /**
     * 第一次安装时间
     */
    private String firstSetupTime;

    /**
     * 是否存在sim卡
     */
    private Integer hasSim;

    /**
     * 型号
     */
    private String model;

    /**
     * 投屏状态判断
     */
    private Integer isShareScreen;

    /**
     * 网络连接类型
     */
    private Integer networkType;

    /**
     * 当前电量信息
     */
    private Integer batteryLevel;

    /**
     * 设备广告ID
     */
    private String oaid;

    /**
     * 设备类型
     */
    private Integer deviceType;

    /**
     * 设备cpu信息
     */
    private String cpuInfo;

    /**
     * 设备sd卡总内存大小
     */
    private String sdTotal;

    /**
     * 设备总内存大小
     */
    private String memTotal;

    /**
     * 设备语言设置
     */
    private String language;

    /**
     * 设备当前地区设置
     */
    private String userRegion;

    /**
     * 设备厂商信息
     */
    private String productManufacturer;

    /**
     * 设备系统名称
     */
    private String productOs;

    /**
     * 应用广告ID
     */
    private String aaid;

    /**
     * 设备ROM信息
     */
    private String rom;

    /**
     * 运营商设备标识
     */
    private String uaid;

    /**
     * 模拟器宿主设备指纹
     */
    private String emulatorDid;
}
