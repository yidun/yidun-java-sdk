package com.netease.yidun.sdk.antispam.crawler.v1.update.request;

import com.netease.yidun.sdk.antispam.crawler.v1.update.response.WeiboUpdateV1Response;
import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

/**
 * 微博检测更新接口v1.0
 */
public class WeiboUpdateV1Request extends CustomSignParamRequest<WeiboUpdateV1Response> {

    @NotNull
    private Long jobId;
    /**
     * 微博名
     */
    private String blogger;
    /**
     * 微博链接
     */
    private String url;
    /**
     * 循环爬虫时间区间--开始时间
     */
    private Long startTime;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getBlogger() {
        return blogger;
    }

    public void setBlogger(String blogger) {
        this.blogger = blogger;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    @Override
    public Class<WeiboUpdateV1Response> getResponseClass() {
        return WeiboUpdateV1Response.class;
    }

    public WeiboUpdateV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/crawler/weibo-job/update";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "WeiboUpdateV1Request{" +
                "jobId=" + jobId +
                ", blogger='" + blogger + '\'' +
                ", url='" + url + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
