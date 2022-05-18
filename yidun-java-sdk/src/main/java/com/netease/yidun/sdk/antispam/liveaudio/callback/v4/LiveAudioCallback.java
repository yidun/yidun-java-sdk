

package com.netease.yidun.sdk.antispam.liveaudio.callback.v4;

import java.util.List;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.request.LiveAudioCallbackV4Req;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackV4Resp;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackV4Result;
import com.netease.yidun.sdk.core.utils.AssertUtils;

public abstract class LiveAudioCallback extends AbstractCallbackHandler<LiveAudioCallbackV4Result> {
    public LiveAudioCallback(CallbackProfile profile) {
        super(null, profile);
    }

    public LiveAudioCallback(String businessId) {
        super(null, businessId);
    }

    public LiveAudioCallback(AntispamRequester requester, String businessId) {
        super(requester, businessId);
    }

    public LiveAudioCallback(AntispamRequester requester, CallbackProfile profile) {
        super(requester, profile);
        AssertUtils.notBlank(profile.getBusinessId(), "businessId can not be null or empty");
    }

    @Override
    protected List<LiveAudioCallbackV4Result> requestCallback(String businessId) {
        LiveAudioCallbackV4Req request = new LiveAudioCallbackV4Req();
        request.setBusinessId(businessId);
        LiveAudioCallbackV4Resp callbackResponse = antispamRequester.getLiveAudioCommonClient().callback(request);
        if (callbackResponse == null) {
            return null;
        }
        return callbackResponse.getResult();
    }
}
