package com.netease.yidun.sdk.antispam.file.v2.submit.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

public class FileSubmitV2Response extends CommonResponse {

    private FileSubmitV2Resp result;

    public FileSubmitV2Resp getResult() {
        return result;
    }

    public void setResult(FileSubmitV2Resp result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "FileSubmitV2Response{" +
                "result=" + result +
                '}';
    }

    public static class FileSubmitV2Resp {
        /**
         * 本次请求数据标识，可以根据该标识查询数据最新结果
         */
        private String taskId;
        /**
         * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
         */
        private String dataId;

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

        @Override
        public String toString() {
            return "FileSubmitV2Resp{" +
                    "taskId='" + taskId + '\'' +
                    ", dataId='" + dataId + '\'' +
                    '}';
        }
    }

}
