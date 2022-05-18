package com.netease.yidun.sdk.antispam.digitalbook.v2;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.request.DigitalBookCallbackRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response.DigitalBookCallbackResponseV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.query.request.DigitalBookQueryRequestV2;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 数字阅读client
 */
public class DigitalBookQueryClient extends AntispamClient {

    public DigitalBookQueryClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public DigitalBookCallbackResponseV2 callback(DigitalBookCallbackRequestV2 request) {
        return client.execute(request);
    }

    public DigitalBookCallbackResponseV2 query(DigitalBookQueryRequestV2 request) {
        return client.execute(request);
    }
}
