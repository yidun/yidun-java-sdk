

package com.netease.yidun.sdk.antispam.livevideosolution.callback.v3;

import java.util.List;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.request.LiveWallSolutionCallbackV3Req;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response.LiveVideoSolutionCallbackV3Result;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response.LiveWallSolutionCallbackV3Resp;


public abstract class LiveVideoSolutionCallback extends AbstractCallbackHandler<LiveVideoSolutionCallbackV3Result> {
    public LiveVideoSolutionCallback(AntispamRequester antispamRequester) {
        super(antispamRequester);
    }

    @Override
    protected List<LiveVideoSolutionCallbackV3Result> requestCallback(String businessId) {
        LiveWallSolutionCallbackV3Req request = new LiveWallSolutionCallbackV3Req();
        LiveWallSolutionCallbackV3Resp callbackResponse = antispamRequester.getLiveVideoSolutionCommonClient()
                .callback(request);
        if (callbackResponse == null) {
            return null;
        }
        return callbackResponse.getResult();
    }
}
