/*
 * @(#) ImageCheckResultV3.java 2016年12月15日
 *
 * Copyright 2010 NetEase.com, Inc. All rights reserved.
 */
package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * v5用户画像结果
 *
 * @author hzhumin1
 * @version 2021-05-18
 */
@ToString
public class ImageRiskControlV5Resp implements Serializable {
    /**
     * 任务id
     */
    private String taskId;

    /**
     * 数据id
     */
    private String dataId;

    /**
     * 智能风控命中详情
     */
    private List<ImageRiskControlDetailHitInfoV5> details;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public List<ImageRiskControlDetailHitInfoV5> getDetails() {
        return details;
    }

    public void setDetails(List<ImageRiskControlDetailHitInfoV5> details) {
        this.details = details;
    }
}
