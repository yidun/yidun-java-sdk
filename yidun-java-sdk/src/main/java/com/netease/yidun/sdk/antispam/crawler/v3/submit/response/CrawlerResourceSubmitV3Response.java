/*
 * @(#) CrawlerSubmitV1Response.java 2020-10-23
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.crawler.v3.submit.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 网站资源检测提交接口响应对象v3.0
 */
public class CrawlerResourceSubmitV3Response extends CommonResponse {

    private CrawlerResourceSubmitResult result;

    public static class CrawlerResourceSubmitResult {
        /**
         * 本次请求数据标识，可以根据该标识查询数据最新结果
         */
        private String taskId;
        /**
         * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
         */
        private String dataId;

        /**
         * 缓冲池当前排队待处理数量
         */
        private Long dealingCount;

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

        public Long getDealingCount() {
            return dealingCount;
        }

        public void setDealingCount(Long dealingCount) {
            this.dealingCount = dealingCount;
        }

        @Override
        public String toString() {
            if (dealingCount != null) {
                return String.format("CrawlerResourceSubmitResult {taskId='%s', dataId='%s', dealingCount=%s", taskId,
                        dataId, dealingCount);
            } else {
                return String.format("CrawlerResourceSubmitResult {taskId='%s', dataId='%s'}", taskId, dataId);
            }
        }
    }

    public CrawlerResourceSubmitResult getResult() {
        return result;
    }

    public void setResult(CrawlerResourceSubmitResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CrawlerResourceSubmitV3Response{" +
                "result=" + result +
                "} " + super.toString();
    }
}
