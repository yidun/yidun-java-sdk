package com.netease.yidun.sdk.antispam.crawler;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.crawler.v1.query.request.JobCallbackQueryRequest;
import com.netease.yidun.sdk.antispam.crawler.v1.query.response.JobCallbackQueryResponse;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.request.CrawlerResourceCallbackV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.antispam.crawler.v3.query.request.CrawlerQueryRequest;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 网站检测client
 */
public class CrawlerCallbackClient extends AntispamClient {

    public CrawlerCallbackClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public CrawlerResourceCallbackV3Response callbackResource(CrawlerResourceCallbackV3Request request) {
        return client.execute(request);
    }

    public CrawlerResourceCallbackV3Response callback(CrawlerQueryRequest request) {
        return client.execute(request);
    }

    public  CrawlerResourceCallbackV3Response query(CrawlerQueryRequest request) {
        return client.execute(request);
    }

    public JobCallbackQueryResponse jobResultQuery(JobCallbackQueryRequest request) {
        return client.execute(request);
    }
}
