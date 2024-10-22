

package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.CrawlerJobSubmitV1Response;
import com.netease.yidun.sdk.core.utils.CollectionUtils;
import com.netease.yidun.sdk.core.utils.GsonUtils;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 网站任务检测提交接口v1.0
 *
 * @author huangwu
 * @version 2021-11-02
 */
public class CrawlerJobSubmitV1Request extends CrawlerJobBaseSubmitV1Request<CrawlerJobSubmitV1Response> {

    /**
     * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
     */
    private String dataId;
    /**
     * 主站URL
     */
    private String siteUrl;
    /**
     * 网站名称
     */
    private String siteName;
    /**
     * 重点关注资源
     */
    private Set<String> focusList;
    /**
     * URL过滤条件集
     */
    private Set<CrawlerUrlFilter> urlFilters;
    /**
     * 业务指定过检策略组id
     */
    private Set<Long> checkStrategyGroupIds;
    
    /**
     * 用户账号
     */
    private String account;

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("dataId", getDataId());
        params.put("sliceStartTime", getSliceStartTime());
        params.put("sliceEndTime", getSliceEndTime());
        params.put("siteUrl", getSiteUrl());
        params.put("siteName", getSiteName());
        params.put("level", getLevel());
        params.put("frequency", getFrequency());
        params.put("maxResourceAmount", getMaxResourceAmount());
        params.put("type", getType());
        params.put("callbackUrl", getCallbackUrl());
        params.put("checkStrategy", getCheckStrategy());
        params.put("config", getConfig());
        params.put("userAgentMatchType", getUserAgentMatchType());
        params.put("userAgent", getUserAgent());
        params.put("focusList", CollectionUtils.isEmpty(getFocusList()) ? null : String.join(",", getFocusList()));
        params.put("urlFilters", GsonUtils.toJson(getUrlFilters()));
        if (!CollectionUtils.isEmpty(getCheckFlags())) {
            String checkFlagStr = getCheckFlags().stream()
                                                 .map(String::valueOf)
                                                 .collect(Collectors.joining(","));
            params.put("checkFlags", checkFlagStr);
        }
        if (!CollectionUtils.isEmpty(checkStrategyGroupIds)) {
            params.put("checkStrategyGroupIds", checkStrategyGroupIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
        params.put("account", getAccount());
        return params;
    }

    @Override
    public Class<CrawlerJobSubmitV1Response> getResponseClass() {
        return CrawlerJobSubmitV1Response.class;
    }

    public CrawlerJobSubmitV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/crawler/job/submit";
        version = "v1.0";
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
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

    public Set<String> getFocusList() {
        return focusList;
    }

    public void setFocusList(Set<String> focusList) {
        this.focusList = focusList;
    }

    public Set<CrawlerUrlFilter> getUrlFilters() {
        return urlFilters;
    }

    public void setUrlFilters(Set<CrawlerUrlFilter> urlFilters) {
        this.urlFilters = urlFilters;
    }

    public Set<Long> getCheckStrategyGroupIds() {
        return checkStrategyGroupIds;
    }

    public void setCheckStrategyGroupIds(Set<Long> checkStrategyGroupIds) {
        this.checkStrategyGroupIds = checkStrategyGroupIds;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "CrawlerJobSubmitV1Request{" +
                "dataId='" + dataId + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                ", siteName='" + siteName + '\'' +
                ", focusList=" + focusList +
                ", urlFilters=" + urlFilters +
                ", checkStrategyGroupIds=" + checkStrategyGroupIds +
                ", account='" + account + '\'' +
                '}' + " " + super.toString();
    }
}
