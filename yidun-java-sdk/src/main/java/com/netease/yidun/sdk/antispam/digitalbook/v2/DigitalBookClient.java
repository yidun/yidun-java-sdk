package com.netease.yidun.sdk.antispam.digitalbook.v2;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.DigitalBookCallback;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.request.DigitalBookCallbackRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response.DigitalBookCallbackResponseV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.query.request.DigitalBookQueryRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.submit.request.DigitalBookSubmitRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.submit.response.DigitalBookCheckResponseV2;
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 数字阅读client
 */
public class DigitalBookClient {

    private AntispamRequester antispamRequester;

    public DigitalBookClient(AntispamRequester antispamRequester) {
        AssertUtils.notNull(antispamRequester, "antispamRequester can not be null");
        this.antispamRequester = antispamRequester;
    }

    public DigitalBookClient(AntispamRequester antispamRequester, DigitalBookCallback digitalBookCallback) {
        AssertUtils.notNull(antispamRequester, "antispamRequester can not be null");

        this.antispamRequester = antispamRequester;
        if (digitalBookCallback != null) {
            if (digitalBookCallback.getAntispamRequester() == null) {
                digitalBookCallback.setAntispamRequester(antispamRequester);
            }
            digitalBookCallback.start();
        }
    }

    public DigitalBookCheckResponseV2 submit(DigitalBookSubmitRequestV2 request) {
        return antispamRequester.getDigitalBookCheckClient().submit(request);
    }

    public DigitalBookCallbackResponseV2 callback(DigitalBookCallbackRequestV2 request) {
        return antispamRequester.getDigitalBookQueryClient().callback(request);
    }

    public DigitalBookCallbackResponseV2 query(DigitalBookQueryRequestV2 request) {
        return antispamRequester.getDigitalBookQueryClient().query(request);
    }
}
