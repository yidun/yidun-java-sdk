package com.netease.yidun.sdk.antispam.crawler.v1.update.request;

import com.netease.yidun.sdk.antispam.crawler.v1.update.response.CrawlerJobUpdateV1Response;
import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

/**
 * 网站任务检测更新接口v1.0
 */
public class CrawlerJobUpdateV1Request extends CustomSignParamRequest<CrawlerJobUpdateV1Response> {

    @NotNull
    private Long jobId;
    /**
     * 主站URL
     */
    private String siteUrl;
    /**
     * 网站名称
     */
    private String siteName;
    /**
     * 循环爬虫时间区间--开始时间
     */
    private Long sliceStartTime;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Long getSliceStartTime() {
        return sliceStartTime;
    }

    public void setSliceStartTime(Long sliceStartTime) {
        this.sliceStartTime = sliceStartTime;
    }

    @Override
    public Class<CrawlerJobUpdateV1Response> getResponseClass() {
        return CrawlerJobUpdateV1Response.class;
    }

    public CrawlerJobUpdateV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/crawler/job/update";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "CrawlerJobUpdateV1Request{" +
                "jobId=" + jobId +
                ", siteUrl='" + siteUrl + '\'' +
                ", siteName='" + siteName + '\'' +
                ", sliceStartTime=" + sliceStartTime +
                '}';
    }
}
