package com.netease.yidun.sdk.antispam.crawler.v3.callback.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;

/**
 * 爬虫主动回调实体
 */
public class CrawlerResourceActiveCallbackRequestV3 extends ActiveCallbackRequest {

    private static final long serialVersionUID = -2354090338754448434L;

    public CrawlerResourceCallbackV3Response.CrawlerResourceResult parseCrawlerResourceCallbackData() {
        return parseCallbackData(CrawlerResourceCallbackV3Response.CrawlerResourceResult.class);
    }

}
