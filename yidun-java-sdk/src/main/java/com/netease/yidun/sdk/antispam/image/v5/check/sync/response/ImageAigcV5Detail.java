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
    /**
     *  2:确定
     *  1:嫌疑
     *  0:正常
     *
     */
    private Integer aigcLevel;
    /**
     * aigc分数
     */
    private Float aigcRate;
    /**
     *人工智能生成标识信息
     */
    private ImageAigcV5SignageResp signage;


    public Integer getAigcLevel() {
        return aigcLevel;
    }

    public Float getAigcRate() {
        return aigcRate;
    }

    public ImageAigcV5SignageResp getSignage() {
        return signage;
    }

    public Boolean getIsAigc() {
        return isAigc;
    }

    public void setAigcLevel(Integer aigcLevel) {
        this.aigcLevel = aigcLevel;
    }

    public void setAigcRate(Float aigcRate) {
        this.aigcRate = aigcRate;
    }

    public void setSignage(ImageAigcV5SignageResp signage) {
        this.signage = signage;
    }

    public void setIsAigc(Boolean isAigc) {
        isAigc = isAigc;
    }
}
