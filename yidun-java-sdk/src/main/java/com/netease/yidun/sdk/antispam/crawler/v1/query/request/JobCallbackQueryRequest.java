/*
 * @(#) JobCallbackQueryRequest.java 2023-12-05
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.crawler.v1.query.request;

import com.netease.yidun.sdk.antispam.crawler.v1.query.response.JobCallbackQueryResponse;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import java.util.Map;

/**
 * @author xietieli
 * @version 2023-12-05
 */
public class JobCallbackQueryRequest extends PostFormRequest<JobCallbackQueryResponse> {
    /**
     * 任务id
     */
    private Long jobId;
    /**
     * size
     */
    private Integer pageSize;
    /**
     * page
     */
    private Integer pageNum;

    @Override
    public Class<JobCallbackQueryResponse> getResponseClass() {
        return JobCallbackQueryResponse.class;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("jobId", getJobId());
        params.put("pageSize", getPageSize());
        params.put("pageNum", getPageNum());
        return params;
    }

    public JobCallbackQueryRequest() {
        productCode = "crawler";
        uriPattern = "/v1/crawler/callback-result/query";
        version = "v1.0";
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "JobCallbackQueryRequest{" +
                "jobId=" + jobId +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                '}';
    }
}
