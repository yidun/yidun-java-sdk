

package com.netease.yidun.sdk.antispam.livevideo.callback.v4;

import java.util.List;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.request.LiveVideoCallbackReq;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveCallbackUnitV4;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveVideoCallbackResp;
import com.netease.yidun.sdk.core.utils.AssertUtils;

public abstract class LiveVideoCallback extends AbstractCallbackHandler<LiveCallbackUnitV4> {
    public LiveVideoCallback(CallbackProfile profile) {
        super(null, profile);
    }

    public LiveVideoCallback(String businessId) {
        super(null, businessId);
    }

    public LiveVideoCallback(AntispamRequester requester, String businessId) {
        super(requester, businessId);
    }

    public LiveVideoCallback(AntispamRequester requester, CallbackProfile profile) {
        super(requester, profile);
        AssertUtils.notBlank(profile.getBusinessId(), "businessId can not be null or empty");
    }

    @Override
    protected List<LiveCallbackUnitV4> requestCallback(String businessId) {
        LiveVideoCallbackReq request = new LiveVideoCallbackReq();
        request.setBusinessId(businessId);
        LiveVideoCallbackResp callbackResponse = antispamRequester.getLiveVideoCommonClient().callback(request);
        if (callbackResponse == null) {
            return null;
        }
        return callbackResponse.getResult();
    }
}
