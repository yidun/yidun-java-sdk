package com.netease.yidun.sdk.antispam.crawler.v3.submit.request;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.netease.yidun.sdk.antispam.crawler.v3.submit.response.CrawlerResourceSubmitV3Response;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

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

    @Override
    public String toString() {
        return "CrawlerSubmitV3Request{" +
                "url='" + url + '\'' +
                ", dataId='" + dataId + '\'' +
                ", callback='" + callback + '\'' +
                ", checkFlags=" + checkFlags +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }
}
