package com.netease.yidun.sdk.antispam.audio;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.audio.check.async.v4.request.AudioAsyncCheckRequest;
import com.netease.yidun.sdk.antispam.audio.check.async.v4.response.AudioAsyncCheckResponse;
import com.netease.yidun.sdk.antispam.audio.check.sync.v2.request.AudioSyncCheckRequest;
import com.netease.yidun.sdk.antispam.audio.check.sync.v2.response.AudioSyncCheckResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class AudioCheckClient extends AntispamClient {
    public AudioCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public AudioSyncCheckResponse syncCheckAudio(AudioSyncCheckRequest request) {
        return client.execute(request);
    }

    public AudioAsyncCheckResponse asyncCheckAudio(AudioAsyncCheckRequest request) {
        return client.execute(request);
    }

    @Override
    protected String clientName() {
        return "AudioCheck";
    }

}
