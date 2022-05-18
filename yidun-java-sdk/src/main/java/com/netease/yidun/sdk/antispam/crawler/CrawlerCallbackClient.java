package com.netease.yidun.sdk.antispam.crawler;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.request.CrawlerResourceCallbackV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
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
}
