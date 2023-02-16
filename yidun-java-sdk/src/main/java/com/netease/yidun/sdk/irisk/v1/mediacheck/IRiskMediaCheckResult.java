package com.netease.yidun.sdk.irisk.v1.mediacheck;


public class IRiskMediaCheckResult {

    /**
     * 检测任务 ID，可自行决定是否存储。若存储可用于记录该次数据请求以及数据核查追踪。
     */
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "IRiskMediaCheckResult(" +
                "taskId=" + taskId +
                ")";
    }
}
