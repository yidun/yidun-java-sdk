package com.netease.yidun.sdk.antispam.crawler.v1.submit.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.io.Serializable;

/**
 * 微博检测提交接口响应对象v1.0
 */
public class WeiboSubmitV1Response extends CommonResponse {

    private static final long serialVersionUID = 2116536601320990284L;
    private WeiboSubmitResult result;

    public WeiboSubmitResult getResult() {
        return result;
    }

    public void setResult(WeiboSubmitResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WeiboSubmitV1Response{" +
                "result=" + result +
                '}';
    }

    public static class WeiboSubmitResult implements Serializable {

        private static final long serialVersionUID = -8470517047781570836L;
        private Long jobId;
        private String taskId;

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

        @Override
        public String toString() {
            return "WeiboSubmitResult{" +
                    "jobId=" + jobId +
                    ", taskId='" + taskId + '\'' +
                    '}';
        }
    }
}
