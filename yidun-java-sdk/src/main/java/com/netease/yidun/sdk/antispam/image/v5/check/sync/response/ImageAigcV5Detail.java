/*
 * @(#) AttackRecordApiController.java 2015年12月30日
 *
 * Copyright 2010 NetEase.com, Inc. All rights reserved.
 */
package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;

/**
 * 图片命中aigc信息
 *
 * @author hzhumin1
 * @version 2024-03-28
 */
public class ImageAigcV5Detail implements Serializable {
    private static final long serialVersionUID = -2208716537023610122L;
    /**
     * 是否aigc
     */
    private Boolean isAigc;

    public Boolean getIsAigc() {
        return isAigc;
    }

    public void setIsAigc(Boolean isAigc) {
        isAigc = isAigc;
    }
}
