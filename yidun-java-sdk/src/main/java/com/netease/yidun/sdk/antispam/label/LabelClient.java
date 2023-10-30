/*
 * @(#) LabelClient.java 2023-03-14
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.label;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.ClientRegistry;
import com.netease.yidun.sdk.antispam.label.query.request.LabelQueryRequest;
import com.netease.yidun.sdk.antispam.label.query.response.LabelQueryResponse;

/**
 * @author zhuliyang02
 * @version 2023-03-14
 */
public class LabelClient extends BaseClient {

    /**
     * 获取secretId对应的唯一实例
     *
     * @param requester
     * @return
     */
    public static LabelClient getInstance(AntispamRequester requester) {
        return ClientRegistry.register(requester, LabelClient.class);
    }

    public LabelClient(AntispamRequester requester) {
        super(requester);
    }

    public LabelQueryResponse queryLabel(LabelQueryRequest labelQueryRequest) {
        return requester.getOpenApiClient().queryLabel(labelQueryRequest);
    }
}
