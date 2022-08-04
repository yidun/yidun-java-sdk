package com.netease.yidun.sdk.antispam.crawler.v3.callback.request;

import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import java.util.Map;

/**
 * 网站资源检测v3回调请求
 */
public class CrawlerResourceCallbackV3Request extends PostFormRequest<CrawlerResourceCallbackV3Response> {

    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public CrawlerResourceCallbackV3Request() {
        productCode = "crawler";
        uriPattern = "/v3/crawler/callback/results";
        version = "v3.0";
    }

    /**
     * 获取具体业务中特有的需要参与签名计算的参数
     *
     * @return 返回需要参与签名的参数
     */
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("yidunRequestId", getYidunRequestId());
        return params;
    }

    @Override
    public Class<CrawlerResourceCallbackV3Response> getResponseClass() {
        return CrawlerResourceCallbackV3Response.class;
    }

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }
}
