/*
 * @(#) VideoImageAigcItemBo.java 2025-07-15
 *
 * Copyright 2025 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhuliyang02
 * @version 2025-07-15
 */
public class VideoImageAigcV4Response implements Serializable {
    private static final long serialVersionUID = -1L;
    /**
     * 即易盾生成的uuid，唯一标识一张图片
     */
    private String taskId;
    /**
     * 产品方传的图片标识，原样返回
     */
    private String name;
    /**
     * 客户图片唯一标识
     */
    private String dataId;

    private List<VideoImageAigcItemBo> details;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public List<VideoImageAigcItemBo> getDetails() {
        return details;
    }

    public void setDetails(List<VideoImageAigcItemBo> details) {
        this.details = details;
    }

    public static class VideoImageAigcItemBo implements Serializable {
        private static final long serialVersionUID = -1L;
        /**
         * 是否aigc
         */
        private Boolean isAigc;
        /**
         * aigc分数
         */
        private Float aigcRate;

        public Boolean getAigc() {
            return isAigc;
        }

        public void setAigc(Boolean aigc) {
            isAigc = aigc;
        }

        public Float getAigcRate() {
            return aigcRate;
        }

        public void setAigcRate(Float aigcRate) {
            this.aigcRate = aigcRate;
        }


    }
}
