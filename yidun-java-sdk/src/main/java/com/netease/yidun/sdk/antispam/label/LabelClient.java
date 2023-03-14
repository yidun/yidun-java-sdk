/*
 * @(#) LabelClient.java 2023-03-14
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.label;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.label.query.request.LabelQueryRequest;
import com.netease.yidun.sdk.antispam.label.query.response.LabelQueryResponse;

/**
 * @author zhuliyang02
 * @version 2023-03-14
 */
public class LabelClient extends BaseClient {
    public LabelClient(AntispamRequester requester) {
        super(requester);
    }

    public LabelQueryResponse queryLabel(LabelQueryRequest labelQueryRequest) {
        return requester.getLabelQueryClient().queryLabel(labelQueryRequest);
    }
}
