package com.netease.yidun.sdk.antispam.crawler.v1.query.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.io.Serializable;
import java.util.List;

/**
 * 微博检测批量查询接口响应对象v1.0
 */
public class WeiboBatchQueryV1Response extends CommonResponse {

    private static final long serialVersionUID = -4814622856741193372L;
    private List<WeiboBatchQueryV1Result> result;

    public List<WeiboBatchQueryV1Result> getResult() {
        return result;
    }

    public void setResult(List<WeiboBatchQueryV1Result> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WeiboBatchQueryV1Response{" +
                "result=" + result +
                '}';
    }

    public static class WeiboBatchQueryV1Result implements Serializable {

        private static final long serialVersionUID = 8769952444993363310L;
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
            return "WeiboBatchQueryV1Result{" +
                    "jobId=" + jobId +
                    ", status=" + status +
                    '}';
        }
    }

}
