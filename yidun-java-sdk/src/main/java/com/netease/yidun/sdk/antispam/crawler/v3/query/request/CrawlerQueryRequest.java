/*
 * @(#) CrawlerQueryRequest.java 2022-08-30
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.crawler.v3.query.request;

import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhudengfeng01
 * @version 2022-08-30
 */
public class CrawlerQueryRequest extends PostFormRequest<CrawlerResourceCallbackV3Response> {
    @NotNull(message = "taskIdList不能为空")
    @Size(min = 1, message = "taskIdList不能为空")
    private List<String> taskIdList;

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("taskIdList", Optional.ofNullable(taskIdList)
                .map(o -> o.stream().collect(Collectors.joining(","))).orElse(null));
        return params;
    }

    public CrawlerQueryRequest() {
        productCode = "crawler";
        uriPattern = "/v3/crawler/callback/query";
        version = "v3.0";
        method = HttpMethodEnum.POST;
    }

    @Override
    public Class<CrawlerResourceCallbackV3Response> getResponseClass() {
        return CrawlerResourceCallbackV3Response.class;
    }

    public List<String> getTaskIds() {
        return taskIdList;
    }

    public void setTaskIdList(List<String> taskIds) {
        this.taskIdList = taskIds;
    }

    @Override
    public String toString() {
        return "CrawlerQueryRequest{" +
                "taskIds=" + taskIdList +
                '}';
    }

}
