package com.netease.yidun.sdk.antispam.crawler.v1.query.request;

import com.netease.yidun.sdk.antispam.crawler.v1.query.response.OfficialAccountsBatchQueryV1Response;
import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.List;

/**
 * 公众号检测批量查询接口v1.0
 */
public class OfficialAccountsBatchQueryV1Request extends CustomSignParamRequest<OfficialAccountsBatchQueryV1Response> {

    /**
     * 需要查询的任务id列表
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
    public Class<OfficialAccountsBatchQueryV1Response> getResponseClass() {
        return OfficialAccountsBatchQueryV1Response.class;
    }

    public OfficialAccountsBatchQueryV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/official-accounts/job/batchQuery";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "OfficialAccountsBatchQueryV1Request{" +
                "jobIds=" + jobIds +
                '}';
    }
}
