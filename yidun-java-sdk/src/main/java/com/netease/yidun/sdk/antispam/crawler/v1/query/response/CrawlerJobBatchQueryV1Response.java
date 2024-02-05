package com.netease.yidun.sdk.antispam.crawler.v1.query.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.io.Serializable;
import java.util.List;

/**
 * 网站任务检测批量查询接口响应对象v1.0
 */
public class CrawlerJobBatchQueryV1Response extends CommonResponse {

    private static final long serialVersionUID = 6542855958013399948L;

    private List<CrawlerJobBatchQueryV1Result> result;

    public List<CrawlerJobBatchQueryV1Result> getResult() {
        return result;
    }

    public void setResult(List<CrawlerJobBatchQueryV1Result> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CrawlerJobBatchQueryV1Response{" +
                "result=" + result +
                '}';
    }

    public static class CrawlerJobBatchQueryV1Result implements Serializable {
        private static final long serialVersionUID = -4472938282672481928L;

        /**
         * 本次查询的任务id
         */
        private Long jobId;

        /**
         * 任务状态
         */
        private Integer status;

        public Long getJobId() {
            return jobId;
        }

        public void setJobId(Long jobId) {
            this.jobId = jobId;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "CrawlerJobBatchQueryV1Result{" +
                    "jobId=" + jobId +
                    ", status=" + status +
                    '}';
        }
    }

}
