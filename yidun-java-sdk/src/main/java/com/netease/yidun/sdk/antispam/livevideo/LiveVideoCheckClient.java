package com.netease.yidun.sdk.antispam.livevideo;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.livevideo.submit.v4.request.LiveVideoCheckReq;
import com.netease.yidun.sdk.antispam.livevideo.submit.v4.response.LiveVideoCheckResp;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class LiveVideoCheckClient extends AntispamClient {
    public LiveVideoCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }
    /**
     * 提交直播视频检测请求
     *
     * @param request
     * @return
     */
    public LiveVideoCheckResp check(LiveVideoCheckReq request) {
        return client.execute(request);
    }

    @Override
    protected String clientName() {
        return "LiveVideoCheck";
    }

}
