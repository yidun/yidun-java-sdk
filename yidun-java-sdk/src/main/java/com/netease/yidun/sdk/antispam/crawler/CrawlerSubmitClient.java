package com.netease.yidun.sdk.antispam.crawler;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.CrawlerJobSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.CrawlerJobSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.request.CrawlerResourceSubmitV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.response.CrawlerResourceSubmitV3Response;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 网站检测client
 */
public class CrawlerSubmitClient extends AntispamClient {

    public CrawlerSubmitClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public CrawlerJobSubmitV1Response submitJob(CrawlerJobSubmitV1Request request) {
        return client.execute(request);
    }

    public CrawlerResourceSubmitV3Response submitResource(CrawlerResourceSubmitV3Request request) {
        return client.execute(request);
    }

    @Override
    protected String clientName() {
        return "CrawlerSubmit";
    }

}
