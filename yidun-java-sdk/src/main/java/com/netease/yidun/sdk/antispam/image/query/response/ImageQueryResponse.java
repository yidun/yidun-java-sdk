/*
 * @(#) ImageQueryResponse.java 2024-04-15
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.image.query.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;

/**
 * @author xietieli
 * @version 2024-04-15
 */
public class ImageQueryResponse extends CommonResponse {
    private static final long serialVersionUID = -3622966042776581772L;

    private List<ImageQueryResp> result;

    public List<ImageQueryResp> getResult() {
        return result;
    }

    public void setResult(List<ImageQueryResp> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ImageQueryResponse{" +
                "result=" + result +
                '}';
    }

    public static class ImageQueryResp {
        /**
         * 图片名称
         */
        private String name;
        /**
         * 任务id
         */
        private String taskId;
        /**
         * status
         */
        private int status;
        /**
         * 审核来源
         */
        private Integer censorSource;
        /**
         * 审核时间
         */
        private Long censorTime;
        /**
         * 审核结果
         */
        private Integer suggestion;
        /**
         * 图片nos地址, 失效时间6小时
         */
        private String url;
        /**
         * 图片md5
         */
        private String imgMd5;
        /**
         * 图片标签
         */
        private List<ImageLabelQueryResp> labels;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Integer getCensorSource() {
            return censorSource;
        }

        public void setCensorSource(Integer censorSource) {
            this.censorSource = censorSource;
        }

        public Long getCensorTime() {
            return censorTime;
        }

        public void setCensorTime(Long censorTime) {
            this.censorTime = censorTime;
        }

        public Integer getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Integer suggestion) {
            this.suggestion = suggestion;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImgMd5() {
            return imgMd5;
        }

        public void setImgMd5(String imgMd5) {
            this.imgMd5 = imgMd5;
        }

        public List<ImageLabelQueryResp> getLabels() {
            return labels;
        }

        public void setLabels(List<ImageLabelQueryResp> labels) {
            this.labels = labels;
        }

        @Override
        public String toString() {
            return "ImageQueryResponse{" +
                    "name='" + name + '\'' +
                    ", taskId='" + taskId + '\'' +
                    ", status=" + status +
                    ", censorSource=" + censorSource +
                    ", censorTime=" + censorTime +
                    ", suggestion=" + suggestion +
                    ", url='" + url + '\'' +
                    ", imgMd5='" + imgMd5 + '\'' +
                    ", labels=" + labels +
                    '}';
        }
    }

    /**
     * 检测接口返回的图片label对象
     */
    public static class ImageLabelQueryResp {
        /**
         * 对外的图片label
         */
        private int label;
        /**
         * 判断结果，0-正常，1-不确定，2-确定
         */
        private int level;
        /**
         * 得分，范围为0到1
         */
        private float rate;
        /**
         * 二级分类
         */
        private String subLabel;

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public float getRate() {
            return rate;
        }

        public void setRate(float rate) {
            this.rate = rate;
        }

        public String getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(String subLabel) {
            this.subLabel = subLabel;
        }

        @Override
        public String toString() {
            return "ImageLabelQueryResp{" +
                    "label=" + label +
                    ", level=" + level +
                    ", rate=" + rate +
                    ", subLabel='" + subLabel + '\'' +
                    '}';
        }
    }
}
