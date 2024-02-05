package com.netease.yidun.sdk.antispam.crawler.v1.delete.request;

import com.netease.yidun.sdk.antispam.crawler.v1.delete.response.WeiboDeleteV1Response;
import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.List;

/**
 * 微博检测删除接口v1.0
 */
public class WeiboDeleteV1Request extends CustomSignParamRequest<WeiboDeleteV1Response> {

    /**
     * 需要删除的任务id列表
     */
    @NotEmpty
    @Size(max = 100)
    private List<Long> jobIds;

    public List<Long> getJobIds() {
        return jobIds;
    }

    public void setJobIds(List<Long> jobIds) {
        this.jobIds = jobIds;
    }

    @Override
    public Class<WeiboDeleteV1Response> getResponseClass() {
        return WeiboDeleteV1Response.class;
    }

    public WeiboDeleteV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/crawler/weibo-job/delete";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "WeiboDeleteV1Request{" +
                "jobIds=" + jobIds +
                '}';
    }
}
