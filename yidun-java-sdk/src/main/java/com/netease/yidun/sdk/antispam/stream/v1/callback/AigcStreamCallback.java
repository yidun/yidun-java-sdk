/*
 * @(#) AigcStreamCallback.java 2024-06-03
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.stream.v1.callback;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.stream.v1.AigcStreamCheckResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ruicha
 * @version 2024-06-03
 */
public abstract class AigcStreamCallback extends AbstractCallbackHandler<AigcStreamCheckResult> {
    public AigcStreamCallback() {
        super(null, new CallbackProfile(null, 1));
    }

    public AigcStreamCallback(CallbackProfile profile) {
        super(null, profile);
    }

    public AigcStreamCallback(AntispamRequester antispamRequester, CallbackProfile profile) {
        super(antispamRequester, profile);
    }

    @Override
    protected List<AigcStreamCheckResult> requestCallback(String businessId, String requestId) {
        AigcStreamCallbackRequestV1 request = new AigcStreamCallbackRequestV1();
        AigcStreamCallbackResponseV1 callbackResponse = antispamRequester.getAigcStreamCommonClient().callback(request);
        if (callbackResponse == null) {
            return new ArrayList<>();
        }
        return callbackResponse.getResult();
    }
}
