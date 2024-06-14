package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.Max;

import java.util.Set;

/**
 * 微博检测提交接口v1.0
 */
public abstract class WeiboBaseSubmitV1Request<T extends BaseResponse> extends CustomSignParamRequest<T> {

    /**
     * 循环爬虫时间区间--开始时间
     */
    private Long startTime;
    /**
     * 循环爬虫时间区间--结束时间
     */
    private Long endTime;
    /**
     * 最大检测主贴数量
     */
    @Max(value = 2000)
    private Integer maxCheckCount;
    /**
     * 最大检测评论数量
     */
    @Max(value = 2000)
    private Integer maxComment;
    /**
     * 检测频率/多久爬取一次，单位毫秒
     */
    private Long frequency;
    /**
     * 任务类型
     */
    private Integer type;
    /**
     * 主动回调地址
     */
    @Length(max = 1024)
    private String callbackUrl;
    /**
     * 爬取策略
     */
    private Integer strategy;
    /**
     * 检测标记  检测内容
     */
    private Set<Integer> checkFlags;
    /**
     * 业务指定过检策略组id
     */
    private Set<Long> checkStrategyGroupIds;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getMaxCheckCount() {
        return maxCheckCount;
    }

    public void setMaxCheckCount(Integer maxCheckCount) {
        this.maxCheckCount = maxCheckCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public Integer getStrategy() {
        return strategy;
    }

    public void setStrategy(Integer strategy) {
        this.strategy = strategy;
    }

    public Set<Integer> getCheckFlags() {
        return checkFlags;
    }

    public void setCheckFlags(Set<Integer> checkFlags) {
        this.checkFlags = checkFlags;
    }

    public Integer getMaxComment() {
        return maxComment;
    }

    public void setMaxComment(Integer maxComment) {
        this.maxComment = maxComment;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public Set<Long> getCheckStrategyGroupIds() {
        return checkStrategyGroupIds;
    }

    public void setCheckStrategyGroupIds(Set<Long> checkStrategyGroupIds) {
        this.checkStrategyGroupIds = checkStrategyGroupIds;
    }

    @Override
    public String toString() {
        return "WeiboBaseSubmitV1Request{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", maxCheckCount=" + maxCheckCount +
                ", maxComment=" + maxComment +
                ", frequency=" + frequency +
                ", type=" + type +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", strategy=" + strategy +
                ", checkFlags=" + checkFlags +
                ", checkStrategyGroupIds=" + checkStrategyGroupIds +
                '}';
    }
}
