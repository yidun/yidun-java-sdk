package com.netease.yidun.sdk.antispam.crawler.v3.callback.request;

import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.core.request.PostFormRequest;

/**
 * 网站资源检测v3回调请求
 */
public class CrawlerResourceCallbackV3Request extends PostFormRequest<CrawlerResourceCallbackV3Response> {

    public CrawlerResourceCallbackV3Request() {
        productCode = "crawler";
        uriPattern = "/v3/crawler/callback/results";
        version = "v3.0";
    }

    @Override
    public Class<CrawlerResourceCallbackV3Response> getResponseClass() {
        return CrawlerResourceCallbackV3Response.class;
    }

}
