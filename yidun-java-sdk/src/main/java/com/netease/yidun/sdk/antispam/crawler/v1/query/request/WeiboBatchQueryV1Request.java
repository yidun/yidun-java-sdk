package com.netease.yidun.sdk.antispam.crawler.v1.query.request;

import com.netease.yidun.sdk.antispam.crawler.v1.query.response.WeiboBatchQueryV1Response;
import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.List;

/**
 * 微博检测批量查询接口v1.0
 */
public class WeiboBatchQueryV1Request extends CustomSignParamRequest<WeiboBatchQueryV1Response> {

    /**
     * 需要查询的任务id列表
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
    public Class<WeiboBatchQueryV1Response> getResponseClass() {
        return WeiboBatchQueryV1Response.class;
    }

    public WeiboBatchQueryV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/weibo-job/job/batchQuery";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "WeiboBatchQueryV1Request{" +
                "jobIds=" + jobIds +
                '}';
    }
}
