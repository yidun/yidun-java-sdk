package com.netease.yidun.sdk.antispam.text.v2.feedback;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 文本结果反馈响应
 */
public class TextFeedbackResponse extends CommonResponse {

    private List<TextFeedbackResult> result;

    public List<TextFeedbackResult> getResult() {
        return result;
    }

    public void setResult(List<TextFeedbackResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TextFeedbackResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }

    public static class TextFeedbackResult {

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

        @Override
        public String toString() {
            return "TextFeedbackResult("
                    + "taskId=" + taskId
                    + ", result=" + result
                    + ")";
        }
    }
}
