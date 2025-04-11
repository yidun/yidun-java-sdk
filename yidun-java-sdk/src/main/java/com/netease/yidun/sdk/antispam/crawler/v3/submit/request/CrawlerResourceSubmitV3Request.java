package com.netease.yidun.sdk.antispam.crawler.v3.submit.request;

import com.netease.yidun.sdk.antispam.crawler.v3.submit.response.CrawlerResourceSubmitV3Response;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.CollectionUtils;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 网站资源检测提交接口v3.0
 */
public class CrawlerResourceSubmitV3Request extends PostFormRequest<CrawlerResourceSubmitV3Response> {
    /**
     * 资源URL
     */
    @Length(max = 1024, message = "url最长1024个字符")
    @NotNull
    private String url;
    /**
     * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
     */
    @Length(max = 128, message = "dataId最长128个字符")
    @NotNull
    private String dataId;

    /**
     * 用户传过来的
     */
    @Length(max = 512, message = "callback最长512个字符")
    private String callback;
    /**
     * 爬虫检测控制，控制需要爬取页面的哪些内容；1：检测文本；2：检测图片；4：检测点播音频；5：检测文档附件；6：检测点播音视频；
     */
    @NotEmpty(message = "checkFlags不能为空")
    private List<Integer> checkFlags;
    /**
     * 回调接口地址
     */
    @Length(max = 1024, message = "callbackUrl最长1024个字符")
    private String callbackUrl;
    /**
     * 网站名称
     */
    @Length(max = 64, message = "siteName最长64个字符")
    private String siteName;
    /**
     * HTML内容
     */
    private String content;

    /**
     * 类型检测数据配置
     */
    private String config;

    /**
     * 业务指定过检策略组id
     */
    private Set<Long> checkStrategyGroupIds;

    /**
     * extension
     */
    private String extension;

    public CrawlerResourceSubmitV3Request() {
        productCode = "crawler";
        uriPattern = "/v3/crawler/submit";
        method = HttpMethodEnum.POST;
        version = "v3.0";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("url", getUrl());
        params.put("dataId", getDataId());
        params.put("callback", getCallback());
        params.put("checkFlags", Optional.ofNullable(getCheckFlags())
                .map(o -> o.stream().map(String::valueOf).collect(Collectors.joining(","))).orElse(null));
        params.put("callbackUrl", getCallbackUrl());
        params.put("siteName", getSiteName());
        params.put("content", getContent());
        params.put("config", getConfig());
        if (!CollectionUtils.isEmpty(checkStrategyGroupIds)) {
            params.put("checkStrategyGroupIds", checkStrategyGroupIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
        params.put("extension", getExtension());
        return params;
    }

    public static void main(String[] args) {
        CrawlerResourceSubmitV3Request request = new CrawlerResourceSubmitV3Request();
        request.setCheckFlags(Arrays.asList(1, 2, 3));
        String orElse = Optional.ofNullable(request.getCheckFlags())
                .map(o -> o.stream().map(String::valueOf).collect(Collectors.joining(","))).orElse(null);
        String join = String.join(",", Arrays.asList());
        System.out.println(orElse);
    }

    @Override
    public Class<CrawlerResourceSubmitV3Response> getResponseClass() {
        return CrawlerResourceSubmitV3Response.class;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public List<Integer> getCheckFlags() {
        return checkFlags;
    }

    public void setCheckFlags(List<Integer> checkFlags) {
        this.checkFlags = checkFlags;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Set<Long> getCheckStrategyGroupIds() {
        return checkStrategyGroupIds;
    }

    public void setCheckStrategyGroupIds(Set<Long> checkStrategyGroupIds) {
        this.checkStrategyGroupIds = checkStrategyGroupIds;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "CrawlerResourceSubmitV3Request{" +
                "url='" + url + '\'' +
                ", dataId='" + dataId + '\'' +
                ", callback='" + callback + '\'' +
                ", checkFlags=" + checkFlags +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", siteName='" + siteName + '\'' +
                ", content='" + content + '\'' +
                ", config='" + config + '\'' +
                ", checkStrategyGroupIds=" + checkStrategyGroupIds +
                ", extension='" + extension + '\'' +
                '}';
    }
}
