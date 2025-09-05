/*
 * @(#) ImageAigcV5SignageResp.java 2025-07-31
 *
 * Copyright 2025 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import lombok.ToString;

import java.io.Serializable;

/**
 * @author qihuanwei
 * @version 2025-07-31
 */
@ToString
public class ImageAigcV5SignageResp implements Serializable {

    private static final long serialVersionUID = 8496743827610540339L;

    /**
     * 是否含有显式标识。
     *  1 :包含显式标识
     *  0 :不包含显式标识
     */
    private Integer overtSignage;

    /**
     * 是否含有隐式标识。
     *  1 :包含隐式标识
     *  0 :不包含隐式标识
     */
    private Integer covertSignage;

    /**
     * 隐式标识详细信息
     */
    private CovertSignageDetailsResp covertSignageDetails;

    public Integer getOvertSignage() {
        return overtSignage;
    }

    public Integer getCovertSignage() {
        return covertSignage;
    }

    public CovertSignageDetailsResp getCovertSignageDetails() {
        return covertSignageDetails;
    }

    public void setOvertSignage(Integer overtSignage) {
        this.overtSignage = overtSignage;
    }

    public void setCovertSignage(Integer covertSignage) {
        this.covertSignage = covertSignage;
    }

    public void setCovertSignageDetails(CovertSignageDetailsResp covertSignageDetails) {
        this.covertSignageDetails = covertSignageDetails;
    }
}
