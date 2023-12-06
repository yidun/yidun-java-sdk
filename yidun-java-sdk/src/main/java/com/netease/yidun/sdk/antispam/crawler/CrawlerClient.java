package com.netease.yidun.sdk.antispam.crawler;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.CallbackRegistry;
import com.netease.yidun.sdk.antispam.ClientRegistry;
import com.netease.yidun.sdk.antispam.crawler.v1.query.request.JobCallbackQueryRequest;
import com.netease.yidun.sdk.antispam.crawler.v1.query.response.JobCallbackQueryResponse;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.CrawlerJobSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.CrawlerJobSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.CrawlerCallback;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.request.CrawlerResourceCallbackV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.antispam.crawler.v3.query.request.CrawlerQueryRequest;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.request.CrawlerResourceSubmitV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.response.CrawlerResourceSubmitV3Response;

/**
 * 网站检测client
 */
public class CrawlerClient extends BaseClient {

    /**
     * 获取secretId对应的唯一实例
     *
     * @param requester
     * @return
     */
    public static CrawlerClient getInstance(AntispamRequester requester) {
        return ClientRegistry.register(requester, CrawlerClient.class);
    }

    /**
     * 获取secretId对应的唯一实例
     *
     * @param requester
     * @param crawlerCallback
     * @return
     */
    public static CrawlerClient getInstance(AntispamRequester requester, CrawlerCallback... crawlerCallback) {
        CallbackRegistry.register(requester, crawlerCallback);
        return ClientRegistry.register(requester, CrawlerClient.class);
    }

    public CrawlerClient(AntispamRequester antispamRequester) {
        super(antispamRequester);
    }

    public CrawlerClient(AntispamRequester antispamRequester, CrawlerCallback crawlerCallback) {
        super(antispamRequester, crawlerCallback);
    }

    public CrawlerJobSubmitV1Response submitJob(CrawlerJobSubmitV1Request request) {
        return requester.getCrawlerSubmitClient().submitJob(request);
    }

    public CrawlerResourceSubmitV3Response submitResource(CrawlerResourceSubmitV3Request request) {
        return requester.getCrawlerSubmitClient().submitResource(request);
    }

    public CrawlerResourceCallbackV3Response callbackResource(CrawlerResourceCallbackV3Request request) {
        return requester.getCrawlerCallbackClient().callbackResource(request);
    }

    public CrawlerResourceCallbackV3Response callback(CrawlerQueryRequest request) {
        return requester.getCrawlerCallbackClient().callback(request);
    }

    public CrawlerResourceCallbackV3Response query(CrawlerQueryRequest request) {
        return requester.getCrawlerCallbackClient().query(request);
    }

    public JobCallbackQueryResponse jobResultQuery(JobCallbackQueryRequest request) {
        return requester.getCrawlerCallbackClient().jobResultQuery(request);
    }
}
