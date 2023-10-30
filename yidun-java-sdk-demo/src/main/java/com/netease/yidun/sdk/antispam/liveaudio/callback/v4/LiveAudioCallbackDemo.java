
package com.netease.yidun.sdk.antispam.liveaudio.callback.v4;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.liveaudio.LiveAudioClient;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.request.LiveAudioCallbackV4Req;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackV4Resp;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackV4Result;

public class LiveAudioCallbackDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        LiveAudioClient liveAudioClient = LiveAudioClient.getInstance(antispamRequester);
        // 实例化请求对象
        LiveAudioCallbackV4Req callbackRequest = new LiveAudioCallbackV4Req();
        // 设置易盾内容安全分配的businessId
        callbackRequest.setBusinessId("BusinessId");

        LiveAudioCallbackV4Resp checkResponse = null;
        try {
            // 发起获取回调的请求
            checkResponse = liveAudioClient.callback(callbackRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (checkResponse != null && checkResponse.getCode() == 200) {
            for (LiveAudioCallbackV4Result liveAudioResult : checkResponse.getResult()) {
                // 根据需要获取直播音频的检测结果，具体返回字段的说明，请参考官方接口文档中字段说明
            }
        }
    }
}
