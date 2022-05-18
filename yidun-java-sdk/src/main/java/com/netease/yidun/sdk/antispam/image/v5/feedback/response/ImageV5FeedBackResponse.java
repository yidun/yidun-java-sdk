package com.netease.yidun.sdk.antispam.image.v5.feedback.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;

public class ImageV5FeedBackResponse extends CommonResponse {

    private List<ImageV5FeedBackResult> result;

    public List<ImageV5FeedBackResult> getResult() {
        return result;
    }

    public void setResult(List<ImageV5FeedBackResult> result) {
        this.result = result;
    }

    public static class ImageV5FeedBackResult {
        /**
         * 成功
         */
        public static final int SUCCESS = 0;
        /**
         * 服务器异常
         */
        public static final int SERVER_ERROR = 1;
        /**
         * 数据不存在
         */
        public static final int NOT_EXISTS = 2;

        private String taskId;
        private Integer result;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public Integer getResult() {
            return result;
        }

        public void setResult(Integer result) {
            this.result = result;
        }
    }
}
