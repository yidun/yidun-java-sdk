/*
 * @(#) LlmV53CheckInfo.java 2025-12-17
 *
 * Copyright 2025 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author admin
 * @version 2026-07-10
 */
public class LlmV53CheckInfo implements Serializable {
    private static final long serialVersionUID = -8325642804450469991L;
    /**
     * 任务id
     */
    private String taskId;

    /**
     * 数据id
     */
    private String dataId;

    /**
     * 详情
     */
    private List<LlmCheckInfo> details;

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

    public List<LlmCheckInfo> getDetails() {
        return details;
    }

    public void setDetails(List<LlmCheckInfo> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "LlmV53CheckInfo{" +
                "taskId='" + taskId + '\'' +
                ", dataId='" + dataId + '\'' +
                ", details=" + details +
                '}';
    }
}
