package com.netease.yidun.sdk.antispam.crawler.v1.update.request;

import com.netease.yidun.sdk.antispam.crawler.v1.update.response.OfficialAccountsUpdateV1Response;
import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

/**
 * 公众号检测更新接口v1.0
 */
public class OfficialAccountsUpdateV1Request extends CustomSignParamRequest<OfficialAccountsUpdateV1Response> {

    @NotNull
    private Long jobId;
    /**
     * 微信号
     */
    private String wechatAccount;
    /**
     * 公众号名称
     */
    private String officialAccountName;
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

    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    public String getOfficialAccountName() {
        return officialAccountName;
    }

    public void setOfficialAccountName(String officialAccountName) {
        this.officialAccountName = officialAccountName;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    @Override
    public Class<OfficialAccountsUpdateV1Response> getResponseClass() {
        return OfficialAccountsUpdateV1Response.class;
    }

    public OfficialAccountsUpdateV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/official-accounts/job/update";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "OfficialAccountsUpdateV1Request{" +
                "jobId=" + jobId +
                ", wechatAccount='" + wechatAccount + '\'' +
                ", officialAccountName='" + officialAccountName + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
