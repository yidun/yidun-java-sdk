package com.netease.yidun.sdk.antispam.crawler.v1.delete.request;

import com.netease.yidun.sdk.antispam.crawler.v1.delete.response.OfficialAccountsDeleteV1Response;
import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.List;

/**
 * 公众号检测删除接口v1.0
 */
public class OfficialAccountsDeleteV1Request extends CustomSignParamRequest<OfficialAccountsDeleteV1Response> {

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
    public Class<OfficialAccountsDeleteV1Response> getResponseClass() {
        return OfficialAccountsDeleteV1Response.class;
    }

    public OfficialAccountsDeleteV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/official-accounts/job/delete";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "OfficialAccountsDeleteV1Request{" +
                "jobIds=" + jobIds +
                '}';
    }
}
