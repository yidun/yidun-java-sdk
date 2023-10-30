
package com.netease.yidun.sdk.antispam.audio;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.CallbackRegistry;
import com.netease.yidun.sdk.antispam.ClientRegistry;
import com.netease.yidun.sdk.antispam.audio.callback.v4.AudioCallback;
import com.netease.yidun.sdk.antispam.audio.callback.v4.request.AudioCallbackV4Request;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.check.async.v4.request.AudioAsyncCheckRequest;
import com.netease.yidun.sdk.antispam.audio.check.async.v4.response.AudioAsyncCheckResponse;
import com.netease.yidun.sdk.antispam.audio.check.sync.v2.request.AudioSyncCheckRequest;
import com.netease.yidun.sdk.antispam.audio.check.sync.v2.response.AudioSyncCheckResponse;
import com.netease.yidun.sdk.antispam.audio.feedback.v1.request.AudioFeedbackRequest;
import com.netease.yidun.sdk.antispam.audio.feedback.v1.response.AudioFeedbackResponse;
import com.netease.yidun.sdk.antispam.audio.query.v3.request.AudioQueryV3Request;
import com.netease.yidun.sdk.antispam.audio.query.v3.response.AudioQueryV3Response;

public class AudioClient extends BaseClient {

    /**
     * 获取secretId对应的唯一实例
     *
     * @param requester
     * @return
     */
    public static AudioClient getInstance(AntispamRequester requester) {
        return ClientRegistry.register(requester, AudioClient.class);
    }

    /**
     * 获取secretId对应的唯一实例
     *
     * @param requester
     * @param audioCallback
     * @return
     */
    public static AudioClient getInstance(AntispamRequester requester, AudioCallback... audioCallback) {
        CallbackRegistry.register(requester, audioCallback);
        return ClientRegistry.register(requester, AudioClient.class);
    }

    public AudioClient(AntispamRequester requester) {
        super(requester);
    }

    public AudioClient(AntispamRequester requester, AudioCallback audioCallback) {
        super(requester, audioCallback);
    }

    public AudioClient(AntispamRequester requester, AudioCallback... audioCallback) {
        super(requester, audioCallback);
    }

    public AudioSyncCheckResponse syncCheckAudio(AudioSyncCheckRequest request) {
        return requester.getAudioCheckClient().syncCheckAudio(request);
    }

    public AudioAsyncCheckResponse asyncCheckAudio(AudioAsyncCheckRequest request) {
        return requester.getAudioCheckClient().asyncCheckAudio(request);
    }

    /**
     * 点播音频反馈接口
     *
     * @param request 反馈请求
     * @return 反馈响应
     */
    public AudioFeedbackResponse feedback(AudioFeedbackRequest request) {
        return requester.getAudioCommonClient().feedback(request);
    }

    /**
     * 获取回调结果
     *
     * @param request 回调请求
     * @return 回调响应
     */
    public AudioCallbackV4Response callback(AudioCallbackV4Request request) {
        return requester.getAudioCommonClient().callback(request);
    }

    /**
     * 查询接口
     * 
     * @param request 查询请求
     * @return 查询响应
     */
    public AudioQueryV3Response query(AudioQueryV3Request request) {
        return requester.getAudioCommonClient().query(request);
    }
}
