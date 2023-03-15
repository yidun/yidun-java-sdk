/*
 * @(#) LabelClient.java 2023-03-14
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.openapi;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.label.query.request.LabelQueryRequest;
import com.netease.yidun.sdk.antispam.label.query.response.LabelQueryResponse;
import com.netease.yidun.sdk.core.auth.OpenApiSignerImpl;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * @author zhuliyang02
 * @version 2023-03-14
 */
public class OpenApiClient extends AntispamClient {
    public OpenApiClient(ClientProfile clientProfile) {
        clientProfile.setSigner(OpenApiSignerImpl.INSTANCE);
        client = createClient(clientProfile);
    }

    public LabelQueryResponse queryLabel(LabelQueryRequest labelQueryRequest) {
        return client.execute(labelQueryRequest);
    }
}
