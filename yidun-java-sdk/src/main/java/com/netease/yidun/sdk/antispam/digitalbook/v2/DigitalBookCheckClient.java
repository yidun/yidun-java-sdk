package com.netease.yidun.sdk.antispam.digitalbook.v2;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.digitalbook.v2.submit.request.DigitalBookSubmitRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.submit.response.DigitalBookCheckResponseV2;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 数字阅读client
 */
public class DigitalBookCheckClient extends AntispamClient {

    public DigitalBookCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public DigitalBookCheckResponseV2 submit(DigitalBookSubmitRequestV2 request) {
        return client.execute(request);
    }

    @Override
    protected String clientName() {
        return "DigitalBookCheck";
    }
}
