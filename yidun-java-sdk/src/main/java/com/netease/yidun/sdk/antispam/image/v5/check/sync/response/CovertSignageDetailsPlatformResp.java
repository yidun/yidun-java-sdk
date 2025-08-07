/*
 * @(#) CovertSignageDetailsPlatformResp.java 2025-07-31
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
public class CovertSignageDetailsPlatformResp implements Serializable {

    private static final long serialVersionUID = 4850133430659542869L;

    /**
     * 类型说明
     * 1: 公司 2: 个人
     */
    private Integer type;

    /**
     * 平台或者个人详细信息
     * 如果是平台，公司名返回
     * 如果是个人则默认为空
     */
    private String info;

    public Integer getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
