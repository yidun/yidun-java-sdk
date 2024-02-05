package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.OfficialAccountsSubmitV1Response;
import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import java.util.Set;

/**
 * 公众号检测提交接口v1.0
 */
public class OfficialAccountsSubmitV1Request extends CustomSignParamRequest<OfficialAccountsSubmitV1Response> {

    /**
     * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
     */
    @Length(max = 128, message = "最大长度128")
    private String dataId;
    /**
     * 循环爬虫时间区间--开始时间
     */
    private Long startTime;
    /**
     * 循环爬虫时间区间--结束时间
     */
    private Long endTime;
    /**
     * 微信号
     */
    @NotNull
    @Length(max = 64, message = "最大长度64")
    private String wechatAccount;
    /**
     * 公众号名称
     */
    @Length(max = 64, message = "最大长度64")
    private String officialAccountName;
    /**
     * 最大检测数量
     */
    private Integer maxCheckCount;
    /**
     * 任务类型
     */
    private Integer type;
    /**
     * 主动回调地址
     */
    @Length(max = 1024, message = "最大长度1024")
    private String callbackUrl;
    /**
     * 爬取策略
     */
    private Integer strategy;
    /**
     * 检测标记  检测内容
     */
    private Set<Integer> checkFlags;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
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

    public Integer getMaxCheckCount() {
        return maxCheckCount;
    }

    public void setMaxCheckCount(Integer maxCheckCount) {
        this.maxCheckCount = maxCheckCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public Integer getStrategy() {
        return strategy;
    }

    public void setStrategy(Integer strategy) {
        this.strategy = strategy;
    }

    public Set<Integer> getCheckFlags() {
        return checkFlags;
    }

    public void setCheckFlags(Set<Integer> checkFlags) {
        this.checkFlags = checkFlags;
    }

    @Override
    public Class<OfficialAccountsSubmitV1Response> getResponseClass() {
        return OfficialAccountsSubmitV1Response.class;
    }

    public OfficialAccountsSubmitV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/official-accounts/job/submit";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "OfficialAccountsSubmitV1Request{" +
                "dataId='" + dataId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", wechatAccount='" + wechatAccount + '\'' +
                ", officialAccountName='" + officialAccountName + '\'' +
                ", maxCheckCount=" + maxCheckCount +
                ", type=" + type +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", strategy=" + strategy +
                ", checkFlags=" + checkFlags +
                '}';
    }
}
