package com.netease.yidun.sdk.antispam.crawler.v1.query.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.io.Serializable;
import java.util.List;

/**
 * 公众号检测批量查询接口响应对象v1.0
 */
public class OfficialAccountsBatchQueryV1Response extends CommonResponse {

    private static final long serialVersionUID = -2666325874678090338L;

    private List<OfficialAccountsBatchQueryV1Result> result;

    public List<OfficialAccountsBatchQueryV1Result> getResult() {
        return result;
    }

    public void setResult(List<OfficialAccountsBatchQueryV1Result> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "OfficialAccountsBatchQueryV1Response{" +
                "result=" + result +
                '}';
    }

    public static class OfficialAccountsBatchQueryV1Result implements Serializable {

        private static final long serialVersionUID = 2697761259755339279L;
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
            return "OfficialAccountsBatchQueryV1Result{" +
                    "jobId=" + jobId +
                    ", status=" + status +
                    '}';
        }
    }

}
