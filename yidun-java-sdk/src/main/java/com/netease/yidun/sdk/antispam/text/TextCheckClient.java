package com.netease.yidun.sdk.antispam.text;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.text.v5.check.async.batch.TextAsyncBatchCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.async.batch.TextAsyncBatchCheckResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.async.single.TextAsyncCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.async.single.TextAsyncCheckResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.batch.TextBatchCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.batch.TextBatchCheckResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class TextCheckClient extends AntispamClient {

    public TextCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public TextCheckResponse syncCheckText(TextCheckRequest request) {
        return client.execute(request);
    }

    public TextBatchCheckResponse syncBatchCheckText(TextBatchCheckRequest request) {
        return client.execute(request);
    }

    public TextAsyncCheckResponse asyncCheckText(TextAsyncCheckRequest request) {
        return client.execute(request);
    }

    public TextAsyncBatchCheckResponse asyncBatchCheckText(TextAsyncBatchCheckRequest request) {
        return client.execute(request);
    }
}
