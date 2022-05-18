
package com.netease.yidun.sdk.antispam.audio.callback.v4;

import java.util.List;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.audio.callback.v4.request.AudioCallbackV4Request;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioCallbackV4Result;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.core.utils.AssertUtils;

public abstract class AudioCallback extends AbstractCallbackHandler<AudioCallbackV4Result> {

    public AudioCallback(CallbackProfile profile) {
        super(null, profile);
    }

    public AudioCallback(String businessId) {
        super(null, businessId);
    }

    public AudioCallback(AntispamRequester audioRequester, String businessId) {
        super(audioRequester, businessId);
    }

    public AudioCallback(AntispamRequester audioRequester, CallbackProfile profile) {
        super(audioRequester, profile);
        AssertUtils.notBlank(profile.getBusinessId(), "businessId can not be null or empty");
    }

    @Override
    protected List<AudioCallbackV4Result> requestCallback(String businessId) {
        AudioCallbackV4Request request = new AudioCallbackV4Request();
        request.setBusinessId(businessId);
        AudioCallbackV4Response callbackResponse = antispamRequester.getAudioCommonClient().callback(request);
        if (callbackResponse == null) {
            return null;
        }
        return callbackResponse.getResult();
    }

}
