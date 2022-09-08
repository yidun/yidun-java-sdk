/*
 * @(#) CrawlerQueryClient.java 2022-08-30
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.crawler;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.request.CrawlerResourceCallbackV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.antispam.crawler.v3.query.request.CrawlerQueryRequest;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * @author zhudengfeng01
 * @version 2022-08-30
 */
public class CrawlerQueryClient extends AntispamClient {
    public CrawlerQueryClient(ClientProfile profile) {
        super(profile);
    }

    public CrawlerResourceCallbackV3Response callback(CrawlerResourceCallbackV3Request request) {
        return client.execute(request);
    }

    public  CrawlerResourceCallbackV3Response query(CrawlerQueryRequest request) {
        return client.execute(request);
    }

}
