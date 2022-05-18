package com.netease.yidun.sdk.antispam.digitalbook.v2.callback;

import java.util.Collections;
import java.util.List;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.request.DigitalBookCallbackRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response.DigitalBookCallbackResponseV2;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

public abstract class DigitalBookCallback
        extends AbstractCallbackHandler<DigitalBookCallbackResponseV2.DigitalBookCheckResult> {

    public DigitalBookCallback() {
        super(null, new CallbackProfile(null, 1));
    }

    public DigitalBookCallback(CallbackProfile profile) {
        super(null, profile);
    }

    public DigitalBookCallback(AntispamRequester antispamRequester, CallbackProfile profile) {
        super(antispamRequester, profile);
    }

    @Override
    protected List<DigitalBookCallbackResponseV2.DigitalBookCheckResult> requestCallback(String businessId) {
        DigitalBookCallbackRequestV2 request = new DigitalBookCallbackRequestV2();
        DigitalBookCallbackResponseV2 callbackResponse = antispamRequester.getDigitalBookQueryClient()
                .callback(request);
        if (callbackResponse == null) {
            return Collections.emptyList();
        }
        return callbackResponse.getResult();
    }

}
