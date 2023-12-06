/*
 * @(#) CrawlerJobActiveCallbackRequest.java 2023-12-05
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.crawler.v1.callback.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;

import java.util.List;

/**
 * @author xietieli
 * @version 2023-12-05
 */
public class CrawlerJobActiveCallbackRequest extends ActiveCallbackRequest {

    /**
     * 机器检测结果
     */
    private JobAntispamCallbackResponseV4 antispam;
    /**
     * 人工审核结果
     */
    private JobCensorCallbackResponse censor;

    public JobAntispamCallbackResponseV4 getAntispam() {
        return antispam;
    }

    public void setAntispam(JobAntispamCallbackResponseV4 antispam) {
        this.antispam = antispam;
    }

    public JobCensorCallbackResponse getCensor() {
        return censor;
    }

    public void setCensor(JobCensorCallbackResponse censor) {
        this.censor = censor;
    }

    @Override
    public String toString() {
        return "CrawlerJobActiveCallbackRequest{" +
                "antispam=" + antispam +
                ", censor=" + censor +
                '}';
    }

    public CrawlerJobActiveCallbackRequest parseCrawlerJobCallbackData() {
        return parseCallbackData(CrawlerJobActiveCallbackRequest.class);
    }

    private static class JobAntispamCallbackResponseV4 {
        /**
         * 任务jobId
         */
        private Long jobId;
        /**
         * 任务taskId
         */
        private String taskId;
        /**
         * 资源名称
         */
        private String resourceName;
        /**
         * 资源
         */
        private String resource;
        /**
         * 资源类型
         */
        private Integer resourceType;
        /**
         * 检测状态
         */
        private Integer checkStatus;
        /**
         * 检测结果
         */
        private Integer suggestion;
        /**
         * 命中结果
         */
        private List<LabelInfo> labels;
        /**
         * 检测完成时间
         */
        private Long checkTime;
        /**
         * 报告地址
         */
        private String reportUrl;
        /**
         * 检测失败原因code
         */
        private Integer failureReason;
        /**
         * 检测总url数量
         */
        private Integer totalUrlCount;
        /**
         * 嫌疑url数量
         */
        private Integer suspectUrlCount;
        /**
         * 不通过url数量
         */
        private Integer unPassUrlCount;

        public Long getJobId() {
            return jobId;
        }

        public void setJobId(Long jobId) {
            this.jobId = jobId;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getResourceName() {
            return resourceName;
        }

        public void setResourceName(String resourceName) {
            this.resourceName = resourceName;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public Integer getResourceType() {
            return resourceType;
        }

        public void setResourceType(Integer resourceType) {
            this.resourceType = resourceType;
        }

        public Integer getCheckStatus() {
            return checkStatus;
        }

        public void setCheckStatus(Integer checkStatus) {
            this.checkStatus = checkStatus;
        }

        public Integer getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Integer suggestion) {
            this.suggestion = suggestion;
        }

        public List<LabelInfo> getLabels() {
            return labels;
        }

        public void setLabels(List<LabelInfo> labels) {
            this.labels = labels;
        }

        public Long getCheckTime() {
            return checkTime;
        }

        public void setCheckTime(Long checkTime) {
            this.checkTime = checkTime;
        }

        public String getReportUrl() {
            return reportUrl;
        }

        public void setReportUrl(String reportUrl) {
            this.reportUrl = reportUrl;
        }

        public Integer getFailureReason() {
            return failureReason;
        }

        public void setFailureReason(Integer failureReason) {
            this.failureReason = failureReason;
        }

        public Integer getTotalUrlCount() {
            return totalUrlCount;
        }

        public void setTotalUrlCount(Integer totalUrlCount) {
            this.totalUrlCount = totalUrlCount;
        }

        public Integer getSuspectUrlCount() {
            return suspectUrlCount;
        }

        public void setSuspectUrlCount(Integer suspectUrlCount) {
            this.suspectUrlCount = suspectUrlCount;
        }

        public Integer getUnPassUrlCount() {
            return unPassUrlCount;
        }

        public void setUnPassUrlCount(Integer unPassUrlCount) {
            this.unPassUrlCount = unPassUrlCount;
        }

        @Override
        public String toString() {
            return "JobAntispamCallbackResponseV4{" +
                    "jobId=" + jobId +
                    ", taskId='" + taskId + '\'' +
                    ", resourceName='" + resourceName + '\'' +
                    ", resource='" + resource + '\'' +
                    ", resourceType=" + resourceType +
                    ", checkStatus=" + checkStatus +
                    ", suggestion=" + suggestion +
                    ", labels=" + labels +
                    ", checkTime=" + checkTime +
                    ", reportUrl='" + reportUrl + '\'' +
                    ", failureReason=" + failureReason +
                    ", totalUrlCount=" + totalUrlCount +
                    ", suspectUrlCount=" + suspectUrlCount +
                    ", unPassUrlCount=" + unPassUrlCount +
                    '}';
        }
    }


    /**
     * 人审回调结果
     */
    private static class JobCensorCallbackResponse {
        /**
         * 任务id
         */
        private Long jobId;
        /**
         * 主站url
         */
        private String siteUrl;
        /**
         * 检测结果
         */
        private Integer suggestion;
        /**
         * 命中结果
         */
        private List<LabelInfo> labels;
        /**
         * 人工审核最后时间
         */
        private Long censorTime;
        /**
         * 报告地址
         */
        private String reportUrl;
        /**
         * 检测总url数量
         */
        private Integer totalUrlCount;
        /**
         * 嫌疑url数量
         */
        private Integer suspectUrlCount;
        /**
         * 不通过url数量
         */
        private Integer unPassUrlCount;

        public Long getJobId() {
            return jobId;
        }

        public void setJobId(Long jobId) {
            this.jobId = jobId;
        }

        public String getSiteUrl() {
            return siteUrl;
        }

        public void setSiteUrl(String siteUrl) {
            this.siteUrl = siteUrl;
        }

        public Integer getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Integer suggestion) {
            this.suggestion = suggestion;
        }

        public List<LabelInfo> getLabels() {
            return labels;
        }

        public void setLabels(List<LabelInfo> labels) {
            this.labels = labels;
        }

        public Long getCensorTime() {
            return censorTime;
        }

        public void setCensorTime(Long censorTime) {
            this.censorTime = censorTime;
        }

        public String getReportUrl() {
            return reportUrl;
        }

        public void setReportUrl(String reportUrl) {
            this.reportUrl = reportUrl;
        }

        public Integer getTotalUrlCount() {
            return totalUrlCount;
        }

        public void setTotalUrlCount(Integer totalUrlCount) {
            this.totalUrlCount = totalUrlCount;
        }

        public Integer getSuspectUrlCount() {
            return suspectUrlCount;
        }

        public void setSuspectUrlCount(Integer suspectUrlCount) {
            this.suspectUrlCount = suspectUrlCount;
        }

        public Integer getUnPassUrlCount() {
            return unPassUrlCount;
        }

        public void setUnPassUrlCount(Integer unPassUrlCount) {
            this.unPassUrlCount = unPassUrlCount;
        }

        @Override
        public String toString() {
            return "JobCensorCallbackUnit{" +
                    "jobId=" + jobId +
                    ", siteUrl='" + siteUrl + '\'' +
                    ", suggestion=" + suggestion +
                    ", labels=" + labels +
                    ", censorTime=" + censorTime +
                    ", reportUrl='" + reportUrl + '\'' +
                    ", totalUrlCount=" + totalUrlCount +
                    ", suspectUrlCount=" + suspectUrlCount +
                    ", unPassUrlCount=" + unPassUrlCount +
                    '}';
        }
    }

    public static class LabelInfo {
        private Integer label;

        public Integer getLabel() {
            return label;
        }

        public void setLabel(Integer label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "LabelInfo{" +
                    "label=" + label +
                    '}';
        }
    }
}
