package com.netease.yidun.sdk.antispam.media.v2.callback;

import java.util.Collections;
import java.util.List;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.media.v2.callback.request.MediaCallbackRequestV2;
import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

public abstract class MediaCallback extends AbstractCallbackHandler<MediaCallbackResponseV2.MediaCheckResult> {

    public MediaCallback() {
        super(null, new CallbackProfile(null, 1));
    }

    public MediaCallback(CallbackProfile profile) {
        super(null, profile);
    }

    public MediaCallback(AntispamRequester antispamRequester, CallbackProfile profile) {
        super(antispamRequester, profile);
    }

    @Override
    protected List<MediaCallbackResponseV2.MediaCheckResult> requestCallback(String businessId,String requestId) {
        MediaCallbackRequestV2 request = new MediaCallbackRequestV2();
        MediaCallbackResponseV2 callbackResponse = antispamRequester.getMediaQueryClient().callback(request);
        if (callbackResponse == null) {
            return Collections.emptyList();
        }
        return callbackResponse.getResult();
    }

}
