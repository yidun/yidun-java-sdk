package com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.request;

import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response.LiveWallSolutionCallbackV3Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;

import lombok.Data;

@Data
public class LiveWallSolutionCallbackV3Req extends PostFormRequest<LiveWallSolutionCallbackV3Resp> {

    public LiveWallSolutionCallbackV3Req() {
        productCode = "liveVideoSolutionCommon";
        uriPattern = "/v3/livewallsolution/callback/results";
        version = "v3";
    }

    @Override
    public Class<LiveWallSolutionCallbackV3Resp> getResponseClass() {
        return LiveWallSolutionCallbackV3Resp.class;
    }
}
