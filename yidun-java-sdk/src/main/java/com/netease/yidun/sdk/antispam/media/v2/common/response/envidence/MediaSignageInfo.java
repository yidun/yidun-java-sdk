/*
 * @(#) MediaVideoSignageInfo.java 2025-09-08
 *
 * Copyright 2025 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import java.io.Serializable;

/**
 * @version 2025-09-08
 */
public class MediaSignageInfo implements Serializable {
    private static final long serialVersionUID = -1888338916731782509L;
    /**
     * 显式标识
     *
     * @see AigcSignageEnum
     *
     */
    private Integer overtSignage;
    /**
     * 隐式标识
     *
     * @see AigcSignageEnum
     *
     */
    private Integer covertSignage;
    /**
     * 隐式标识详细信息
     */
    private MediaCovertSignageDetails covertSignageDetails;

    public Integer getOvertSignage() {
        return overtSignage;
    }

    public void setOvertSignage(Integer overtSignage) {
        this.overtSignage = overtSignage;
    }

    public Integer getCovertSignage() {
        return covertSignage;
    }

    public void setCovertSignage(Integer covertSignage) {
        this.covertSignage = covertSignage;
    }

    public MediaCovertSignageDetails getCovertSignageDetails() {
        return covertSignageDetails;
    }

    public void setCovertSignageDetails(MediaCovertSignageDetails covertSignageDetails) {
        this.covertSignageDetails = covertSignageDetails;
    }
}
