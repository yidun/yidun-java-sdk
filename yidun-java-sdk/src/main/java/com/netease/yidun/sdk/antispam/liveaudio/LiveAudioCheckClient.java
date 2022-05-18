package com.netease.yidun.sdk.antispam.liveaudio;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.liveaudio.submit.v4.request.LiveAudioSubmitV4Req;
import com.netease.yidun.sdk.antispam.liveaudio.submit.v4.response.LiveAudioSubmitV4Resp;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class LiveAudioCheckClient extends AntispamClient {
    public LiveAudioCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    /**
     * 提交直播语音URL，进行语音内容检测
     *
     * @param request
     * @return
     */
    public LiveAudioSubmitV4Resp check(LiveAudioSubmitV4Req request) {
        return client.execute(request);
    }


}
