/*
 * @(#) DeviceQueryResult.java 2022-05-10
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.fingerprint;

/**
 * 设备指纹查询结果
 */
public class DeviceQueryResult {
    /**
     * 此次查询请求的唯一标识
     */
    private String taskId;
    /**
     * token生成时间。UNIX时间戳，单位：毫秒
     */
    private Long tokenCreationTime;
    /**
     * 设备信息
     */
    private DeviceData device;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Long getTokenCreationTime() {
        return tokenCreationTime;
    }

    public void setTokenCreationTime(Long tokenCreationTime) {
        this.tokenCreationTime = tokenCreationTime;
    }

    public DeviceData getDevice() {
        return device;
    }

    public void setDevice(DeviceData device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "DeviceQueryResult(" +
                "taskId=" + taskId +
                ", tokenCreationTime=" + tokenCreationTime +
                ", device=" + device.toString() +
                ')';
    }
}
