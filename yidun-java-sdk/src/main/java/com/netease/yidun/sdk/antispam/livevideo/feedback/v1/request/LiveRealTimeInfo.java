package com.netease.yidun.sdk.antispam.livevideo.feedback.v1.request;

import java.util.List;

/**
 * 直播实时数据
 */
public class LiveRealTimeInfo {

    /**
     * 直播UUID
     */
    private String taskId;

    /**
     * 直播标签数组,null代表不更新
     */
    private List<String> labels;

    /**
     * 观看人数,-1或者null代表不更新
     */
    private Integer viewCount;

    /**
     * 礼物数，-1或者null代表不更新
     */
    private Integer giftCount;

    /**
     * 弹幕数,-1或者null代表不更新
     */
    private Integer barrageCount;

    /**
     * 直播状态 100：直播结束 @see LiveVideoFeedBackStatusEnum
     */
    private Integer status;

    /**
     * 新增分数
     */
    private Integer addScore;

    /**
     * 直播标签, 优化乱序
     */
    private LiveTag liveTag;

    public static class LiveTag {
        /**
         * 直播标签数组
         */
        private List<String> labels;
        /**
         * 直播标签更新时间
         */
        private long updateTime;

        public List<String> getLabels() {
            return labels;
        }

        public void setLabels(List<String> labels) {
            this.labels = labels;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(Integer giftCount) {
        this.giftCount = giftCount;
    }

    public Integer getBarrageCount() {
        return barrageCount;
    }

    public void setBarrageCount(Integer barrageCount) {
        this.barrageCount = barrageCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAddScore() {
        return addScore;
    }

    public void setAddScore(Integer addScore) {
        this.addScore = addScore;
    }

    public LiveTag getLiveTag() {
        return liveTag;
    }

    public void setLiveTag(LiveTag liveTag) {
        this.liveTag = liveTag;
    }
}
