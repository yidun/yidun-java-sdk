
package com.netease.yidun.sdk.antispam.audio;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.audio.callback.v4.request.AudioCallbackV4Request;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.feedback.v1.request.AudioFeedbackRequest;
import com.netease.yidun.sdk.antispam.audio.feedback.v1.response.AudioFeedbackResponse;
import com.netease.yidun.sdk.antispam.audio.query.v3.request.AudioQueryV3Request;
import com.netease.yidun.sdk.antispam.audio.query.v3.response.AudioQueryV3Response;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class AudioCommonClient extends AntispamClient {
    public AudioCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    /**
     * 点播音频反馈接口
     *
     * @param request 反馈请求
     * @return 反馈响应
     */
    public AudioFeedbackResponse feedback(AudioFeedbackRequest request) {
        return client.execute(request);
    }

    /**
     * 获取回调结果
     *
     * @param audioCallbackV4Request 回调请求
     * @return 回调响应
     */
    public AudioCallbackV4Response callback(AudioCallbackV4Request audioCallbackV4Request) {
        return client.execute(audioCallbackV4Request);
    }

    public AudioQueryV3Response query(AudioQueryV3Request request) {
        return client.execute(request);
    }
}
