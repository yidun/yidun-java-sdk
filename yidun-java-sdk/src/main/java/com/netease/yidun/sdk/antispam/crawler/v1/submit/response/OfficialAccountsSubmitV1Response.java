package com.netease.yidun.sdk.antispam.crawler.v1.submit.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.io.Serializable;

/**
 * 公众号检测提交接口响应对象v1.0
 */
public class OfficialAccountsSubmitV1Response extends CommonResponse {

    private static final long serialVersionUID = -3925218583496818430L;

    private OfficialAccountsSubmitResult result;

    public OfficialAccountsSubmitResult getResult() {
        return result;
    }

    public void setResult(OfficialAccountsSubmitResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "OfficialAccountsSubmitV1Response{" +
                "result=" + result +
                '}';
    }

    public static class OfficialAccountsSubmitResult implements Serializable {
        private static final long serialVersionUID = 6574871707746196662L;
        private Long jobId;
        private String taskId;
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

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        @Override
        public String toString() {
            return "OfficialAccountsSubmitResult{" +
                    "jobId=" + jobId +
                    ", taskId='" + taskId + '\'' +
                    ", dataId='" + dataId + '\'' +
                    '}';
        }
    }
}
