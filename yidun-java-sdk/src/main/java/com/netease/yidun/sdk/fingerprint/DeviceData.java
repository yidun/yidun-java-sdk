/*
 * @(#) DeviceData.java 2022-05-10
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.fingerprint;

/**
 * 设备信息
 */
public class DeviceData {

    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * 客户端SDK类型 详见官网<a href="https://support.dun.163.com/documents/609099986339037184?docId=624010587874123776">说明文档</a>
     */
    private int sdkType;
    /**
     * 风险检测结果
     */
    private DeviceCheckResult checkResult;


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getSdkType() {
        return sdkType;
    }

    public void setSdkType(int sdkType) {
        this.sdkType = sdkType;
    }

    public DeviceCheckResult getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(DeviceCheckResult checkResult) {
        this.checkResult = checkResult;
    }

    @Override
    public String toString() {
        return "DeviceData(" +
                "deviceId=" + deviceId +
                ", sdkType=" + sdkType +
                ", checkResult=" + checkResult +
                ')';
    }
}
