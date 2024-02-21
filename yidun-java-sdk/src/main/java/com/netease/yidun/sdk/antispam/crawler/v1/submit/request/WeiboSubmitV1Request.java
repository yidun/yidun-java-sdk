package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.WeiboSubmitV1Response;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

/**
 * 微博检测提交接口v1.0
 */
public class WeiboSubmitV1Request extends WeiboBaseSubmitV1Request<WeiboSubmitV1Response> {

    /**
     * 微博主页链接
     */
    @NotNull
    @Length(max = 1024)
    private String url;
    /**
     * 微博名
     */
    @Length(max = 64)
    private String blogger;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBlogger() {
        return blogger;
    }

    public void setBlogger(String blogger) {
        this.blogger = blogger;
    }

    @Override
    public Class<WeiboSubmitV1Response> getResponseClass() {
        return WeiboSubmitV1Response.class;
    }

    public WeiboSubmitV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/crawler/weibo-job/submit";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "WeiboSubmitV1Request{" +
                ", url='" + url + '\'' +
                ", blogger='" + blogger + '\'' +
                '}' + " " + super.toString();
    }
}
