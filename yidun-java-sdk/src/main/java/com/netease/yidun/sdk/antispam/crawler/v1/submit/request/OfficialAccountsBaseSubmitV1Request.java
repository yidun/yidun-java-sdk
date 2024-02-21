package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.validation.limitation.Length;

import java.util.Set;

/**
 * 公众号检测提交接口v1.0
 */
public abstract class OfficialAccountsBaseSubmitV1Request<T extends BaseResponse> extends CustomSignParamRequest<T> {

    /**
     * 循环爬虫时间区间--开始时间
     */
    private Long startTime;
    /**
     * 循环爬虫时间区间--结束时间
     */
    private Long endTime;
    /**
     * 最大检测数量
     */
    private Integer maxCheckCount;
    /**
     * 任务类型
     */
    private Integer type;
    /**
     * 主动回调地址
     */
    @Length(max = 1024, message = "最大长度1024")
    private String callbackUrl;
    /**
     * 爬取策略
     */
    private Integer strategy;
    /**
     * 检测标记  检测内容
     */
    private Set<Integer> checkFlags;

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

    @Override
    public String toString() {
        return "OfficialAccountsBaseSubmitV1Request{" +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", maxCheckCount=" + maxCheckCount +
                ", type=" + type +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", strategy=" + strategy +
                ", checkFlags=" + checkFlags +
                '}';
    }
}
