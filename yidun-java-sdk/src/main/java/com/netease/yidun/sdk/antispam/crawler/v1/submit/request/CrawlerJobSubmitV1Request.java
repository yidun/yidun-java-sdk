

package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import java.util.Map;

import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.CrawlerJobSubmitV1Response;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 网站任务检测提交接口v1.0
 *
 * @author huangwu
 * @version 2021-11-02
 */
public class CrawlerJobSubmitV1Request extends PostFormRequest<CrawlerJobSubmitV1Response> {

    /**
     * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
     */
    private String dataId;
    /**
     * 循环爬虫时间区间--开始时间
     */
    private Long sliceStartTime;
    /**
     * 循环爬虫时间区间--结束时间
     */
    private Long sliceEndTime;
    /**
     * 主站URL
     */
    private String siteUrl;
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
     *
     */
    private Integer type;
    /**
     * 主动回调地址
     */
    private String callbackUrl;

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("dataId", getDataId());
        params.put("sliceStartTime", getSliceStartTime());
        params.put("sliceEndTime", getSliceEndTime());
        params.put("siteUrl", getSiteUrl());
        params.put("level", getLevel());
        params.put("frequency", getFrequency());
        params.put("maxResourceAmount", getMaxResourceAmount());
        params.put("type", getType());
        params.put("callbackUrl", getCallbackUrl());
        return params;
    }

    @Override
    public Class<CrawlerJobSubmitV1Response> getResponseClass() {
        return CrawlerJobSubmitV1Response.class;
    }

    public CrawlerJobSubmitV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/crawler/job/submit";
        version = "v1.0";
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

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

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
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

    @Override
    public String toString() {
        return "CrawlerJobSubmitV1Request{" +
                "dataId='" + dataId + '\'' +
                ", sliceStartTime=" + sliceStartTime +
                ", sliceEndTime=" + sliceEndTime +
                ", siteUrl='" + siteUrl + '\'' +
                ", level=" + level +
                ", frequency=" + frequency +
                ", maxResourceAmount=" + maxResourceAmount +
                ", type=" + type +
                ", callbackUrl='" + callbackUrl + '\'' +
                "} " + super.toString();
    }
}
