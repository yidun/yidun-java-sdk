

package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;

import java.util.Set;

/**
 * 网站任务检测提交接口v1.0
 *
 * @author huangwu
 * @version 2021-11-02
 */
public abstract class CrawlerJobBaseSubmitV1Request<T extends BaseResponse> extends CustomSignParamRequest<T> {

    /**
     * 循环爬虫时间区间--开始时间
     */
    private Long sliceStartTime;
    /**
     * 循环爬虫时间区间--结束时间
     */
    private Long sliceEndTime;
    /**
     * 爬虫深度/网站层级
     */
    private Integer level;
    /**
     * 检测频率/多久爬取一次，单位毫秒
     */
    private Long frequency;
    /**
     * 单次任务周期内爬取页面的最大数量
     */
    private Integer maxResourceAmount;
    /**
     * 任务类型；0：循环任务；1：单次任务
     */
    private Integer type;
    /**
     * 主动回调地址
     */
    private String callbackUrl;
    /**
     * 检测策略；当循环任务时，此配置生效。1：全量页面；2：首次全量，后续增量
     */
    private Integer checkStrategy;
    /**
     * 网站爬取配置
     */
    private String config;
    /**
     * user agent 匹配规则
     *
     * @see com.netease.yidun.sdk.antispam.enums.UserAgentMatchType
     */
    private Integer userAgentMatchType;
    /**
     * 浏览器user agent
     */
    private String userAgent;
    /**
     * 检测标记  检测内容, 默认为1和2。1-检测文本，2-检测图片，4-检测点播音频，5-检测文档附件，6-检测点播音视频
     */
    private Set<Integer> checkFlags;

    public Long getSliceStartTime() {
        return sliceStartTime;
    }

    public void setSliceStartTime(Long sliceStartTime) {
        this.sliceStartTime = sliceStartTime;
    }

    public Long getSliceEndTime() {
        return sliceEndTime;
    }

    public void setSliceEndTime(Long sliceEndTime) {
        this.sliceEndTime = sliceEndTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getFrequency() {
        return frequency;
    }

    public Integer getCheckStrategy() {
        return checkStrategy;
    }

    public void setCheckStrategy(Integer checkStrategy) {
        this.checkStrategy = checkStrategy;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public Integer getMaxResourceAmount() {
        return maxResourceAmount;
    }

    public void setMaxResourceAmount(Integer maxResourceAmount) {
        this.maxResourceAmount = maxResourceAmount;
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

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Integer getUserAgentMatchType() {
        return userAgentMatchType;
    }

    public void setUserAgentMatchType(Integer userAgentMatchType) {
        this.userAgentMatchType = userAgentMatchType;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Set<Integer> getCheckFlags() {
        return checkFlags;
    }

    public void setCheckFlags(Set<Integer> checkFlags) {
        this.checkFlags = checkFlags;
    }

    @Override
    public String toString() {
        return "CrawlerJobBaseSubmitV1Request{" +
                ", sliceStartTime=" + sliceStartTime +
                ", sliceEndTime=" + sliceEndTime +
                ", level=" + level +
                ", frequency=" + frequency +
                ", maxResourceAmount=" + maxResourceAmount +
                ", type=" + type +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", checkStrategy=" + checkStrategy +
                ", config='" + config + '\'' +
                ", userAgentMatchType=" + userAgentMatchType +
                ", userAgent='" + userAgent + '\'' +
                ", checkFlags=" + checkFlags +
                '}';
    }
}
