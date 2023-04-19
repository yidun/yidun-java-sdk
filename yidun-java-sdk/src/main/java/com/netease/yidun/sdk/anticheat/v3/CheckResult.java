package com.netease.yidun.sdk.anticheat.v3;

import java.util.List;

/**
 * 反作弊检测结果
 */
public class CheckResult {

    /**
     * 检测结果：0 正常(放行)，10 正常（观察），20 致命（拦截）
     */
    private int action;
    /**
     * 任务id，与检测请求一一对应，建议保存此值方便以后数据查询
     */
    private String taskId;
    /**
     * 命中信息
     */
    private List<HitInfo> hitInfos;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<HitInfo> getHitInfos() {
        return hitInfos;
    }

    public void setHitInfos(List<HitInfo> hitInfos) {
        this.hitInfos = hitInfos;
    }

    @Override
    public String toString() {
        return "CheckResult("
                + "action=" + action
                + ", taskId=" + taskId
                + ", hitInfos=" + hitInfos
                + ")";
    }
}
