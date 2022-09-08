package com.netease.yidun.sdk.antispam.crawler;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.CrawlerJobSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.CrawlerJobSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.CrawlerCallback;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.request.CrawlerResourceCallbackV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.antispam.crawler.v3.query.request.CrawlerQueryRequest;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.request.CrawlerResourceSubmitV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.response.CrawlerResourceSubmitV3Response;

import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 网站检测client
 */
public class CrawlerClient {

    private AntispamRequester antispamRequester;

    public CrawlerClient(AntispamRequester antispamRequester) {
        AssertUtils.notNull(antispamRequester, "antispamRequester can not be null");
        this.antispamRequester = antispamRequester;
    }

    public CrawlerClient(AntispamRequester antispamRequester, CrawlerCallback crawlerCallback) {
        AssertUtils.notNull(antispamRequester, "antispamRequester can not be null");
        this.antispamRequester = antispamRequester;
        if (crawlerCallback != null) {
            if (crawlerCallback.getAntispamRequester() == null) {
                crawlerCallback.setAntispamRequester(antispamRequester);
            }
            crawlerCallback.start();
        }
    }

    public CrawlerJobSubmitV1Response submitJob(CrawlerJobSubmitV1Request request) {
        return antispamRequester.getCrawlerSubmitClient().submitJob(request);
    }

    public CrawlerResourceSubmitV3Response submitResource(CrawlerResourceSubmitV3Request request) {
        return antispamRequester.getCrawlerSubmitClient().submitResource(request);
    }

    public CrawlerResourceCallbackV3Response callbackResource(CrawlerResourceCallbackV3Request request) {
        return antispamRequester.getCrawlerCallbackClient().callbackResource(request);
    }

    public CrawlerResourceCallbackV3Response query(CrawlerQueryRequest request) {
        return antispamRequester.getCrawlerQueryClient().query(request);
    }
}
