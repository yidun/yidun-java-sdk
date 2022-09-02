package com.netease.yidun.sdk.antispam.digitalbook.v2;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.DigitalBookCallback;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.request.DigitalBookCallbackRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response.DigitalBookCallbackResponseV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.query.request.DigitalBookQueryRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.submit.request.DigitalBookSubmitRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.submit.response.DigitalBookCheckResponseV2;

/**
 * 数字阅读client
 */
public class DigitalBookClient extends BaseClient {

    public DigitalBookClient(AntispamRequester antispamRequester) {
        super(antispamRequester);
    }

    public DigitalBookClient(AntispamRequester antispamRequester, DigitalBookCallback digitalBookCallback) {
        super(antispamRequester, digitalBookCallback);
    }

    public DigitalBookCheckResponseV2 submit(DigitalBookSubmitRequestV2 request) {
        return requester.getDigitalBookCheckClient().submit(request);
    }

    public DigitalBookCallbackResponseV2 callback(DigitalBookCallbackRequestV2 request) {
        return requester.getDigitalBookQueryClient().callback(request);
    }

    public DigitalBookCallbackResponseV2 query(DigitalBookQueryRequestV2 request) {
        return requester.getDigitalBookQueryClient().query(request);
    }
}
