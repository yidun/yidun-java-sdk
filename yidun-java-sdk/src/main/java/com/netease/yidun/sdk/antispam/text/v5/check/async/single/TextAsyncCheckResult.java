package com.netease.yidun.sdk.antispam.text.v5.check.async.single;

import java.io.Serializable;
import java.util.List;

/**
 * 文字异步检测结果
 */
public class TextAsyncCheckResult implements Serializable {

    private Integer dealingCount;
    private List<CheckText> checkTexts;

    public Integer getDealingCount() {
        return dealingCount;
    }

    public void setDealingCount(Integer dealingCount) {
        this.dealingCount = dealingCount;
    }

    public List<CheckText> getCheckTexts() {
        return checkTexts;
    }

    public void setCheckTexts(List<CheckText> checkTexts) {
        this.checkTexts = checkTexts;
    }

    @Override
    public String toString() {
        return "TextAsyncCheckResult("
                + "dealingCount=" + dealingCount
                + ", checkTexts=" + checkTexts
                + ")";
    }

    public static class CheckText {

        private String taskId;
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
            return "CheckText("
                    + "taskId=" + taskId
                    + ", dataId=" + dataId
                    + ")";
        }
    }
}
