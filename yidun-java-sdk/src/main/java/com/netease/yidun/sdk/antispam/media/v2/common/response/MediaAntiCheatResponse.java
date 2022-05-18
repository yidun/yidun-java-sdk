package com.netease.yidun.sdk.antispam.media.v2.common.response;

/**
 * 反作弊结果
 */
public class MediaAntiCheatResponse {

    /**
     * 0:无结果（检测失败）1:正常 2:异常 3：疑似
     */
    private Integer action;
    private String taskId;
    private HitInfo hitInfo;

    private Integer code;

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public HitInfo getHitInfo() {
        return hitInfo;
    }

    public void setHitInfo(HitInfo hitInfo) {
        this.hitInfo = hitInfo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static class HitInfo {
        /** 见官网文档 */
        private Integer hitType;
        /** 见官网文档 */
        private String hitMsg;

        public Integer getHitType() {
            return hitType;
        }

        public void setHitType(Integer hitType) {
            this.hitType = hitType;
        }

        public String getHitMsg() {
            return hitMsg;
        }

        public void setHitMsg(String hitMsg) {
            this.hitMsg = hitMsg;
        }
    }
}
