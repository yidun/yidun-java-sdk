package com.netease.yidun.sdk.antispam.livevideosolution;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.livevideosolution.submit.v3.request.LiveWallSolutionSubmitV3Req;
import com.netease.yidun.sdk.antispam.livevideosolution.submit.v3.response.LiveWallSolutionSubmitV3Resp;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class LiveVideoSolutionCheckClient extends AntispamClient {

    public LiveVideoSolutionCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public LiveWallSolutionSubmitV3Resp check(LiveWallSolutionSubmitV3Req request) {
        return client.execute(request);
    }

}
