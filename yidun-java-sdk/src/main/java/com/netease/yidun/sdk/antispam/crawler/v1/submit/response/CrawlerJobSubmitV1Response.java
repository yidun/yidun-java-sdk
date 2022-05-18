/*
 * @(#) CrawlerJobSubmitV1Response.java 2021-11-02
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.crawler.v1.submit.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 网站任务检测提交接口响应对象v1.0
 *
 * @author huangwu
 * @version 2021-11-02
 */
public class CrawlerJobSubmitV1Response extends CommonResponse {

    private CrawlerJobSubmitResult result;

    public static class CrawlerJobSubmitResult {
        private Long jobId;
        private String dataId;

        public Long getJobId() {
            return jobId;
        }

        public void setJobId(Long jobId) {
            this.jobId = jobId;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        @Override
        public String toString() {
            return "CrawlerJobSubmitResult{" +
                    "jobId=" + jobId +
                    ", dataId='" + dataId + '\'' +
                    '}';
        }
    }

    public CrawlerJobSubmitResult getResult() {
        return result;
    }

    public void setResult(CrawlerJobSubmitResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CrawlerJobSubmitV1Response{" +
                "result=" + result +
                "} " + super.toString();
    }
}
