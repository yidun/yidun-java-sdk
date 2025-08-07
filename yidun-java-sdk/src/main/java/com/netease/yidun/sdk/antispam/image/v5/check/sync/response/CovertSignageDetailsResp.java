/*
 * @(#) CovertSignageDetailsResp.java 2025-07-31
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
public class CovertSignageDetailsResp implements Serializable {
    private static final long serialVersionUID = -2710613847117266355L;

    /**
     * 1: 数据生成者 2: 数据传播者
     */
    private Integer role;

    /**
     * 隐式生成的平台/个人信息
     */
    private CovertSignageDetailsPlatformResp platform;

    public Integer getRole() {
        return role;
    }

    public CovertSignageDetailsPlatformResp getPlatform() {
        return platform;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public void setPlatform(CovertSignageDetailsPlatformResp platform) {
        this.platform = platform;
    }
}
