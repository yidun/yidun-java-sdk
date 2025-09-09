/*
 * @(#) MediaCovertSignagePlatform.java 2025-09-08
 *
 * Copyright 2025 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import java.io.Serializable;

/**
 * @author hzchenyingyou
 * @version 2025-09-08
 */
public class MediaCovertSignagePlatform implements Serializable {
    private static final long serialVersionUID = 6028578132187671861L;

    /**
     * 类型说明
     *
     */
    private Integer type;

    /**
     * 平台信息
     */
    private String info;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
