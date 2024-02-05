package com.netease.yidun.sdk.antispam.crawler.v1.delete.request;

import com.netease.yidun.sdk.antispam.crawler.v1.delete.response.CrawlerJobDeleteV1Response;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 网站任务检测删除接口v1.0
 */
public class CrawlerJobDeleteV1Request extends PostFormRequest<CrawlerJobDeleteV1Response> {

    /**
     * 需要删除的任务id列表
     */
    @NotEmpty
    @Size(max = 100, message = "jobIds最大长度100")
    private List<Long> jobIds;

    public List<Long> getJobIds() {
        return jobIds;
    }

    public void setJobIds(List<Long> jobIds) {
        this.jobIds = jobIds;
    }

    @Override
    public Class<CrawlerJobDeleteV1Response> getResponseClass() {
        return CrawlerJobDeleteV1Response.class;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("jobIds", Optional.ofNullable(jobIds)
                .map(o -> o.stream().map(String::valueOf).collect(Collectors.joining(",")))
                .orElse(null));
        return params;
    }

    public CrawlerJobDeleteV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/crawler/job/delete";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "CrawlerJobDeleteV1Request{" +
                "jobIds=" + jobIds +
                '}';
    }
}
