
package com.netease.yidun.sdk.antispam.audio.callback.v4;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.audio.AudioClient;
import com.netease.yidun.sdk.antispam.audio.callback.v4.request.AudioCallbackV4Request;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioCallbackV4Result;

public class AudioCallbackDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        AudioClient audioClient = AudioClient.getInstance(antispamRequester);
        // 实例化请求对象
        AudioCallbackV4Request callbackRequest = new AudioCallbackV4Request();
        // 设置易盾内容安全分配的businessId
        callbackRequest.setBusinessId("BusinessId");

        AudioCallbackV4Response checkResponse = null;
        try {
            // 发起获取回调的请求
            checkResponse = audioClient.callback(callbackRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (checkResponse != null && checkResponse.getCode() == 200) {
            for (AudioCallbackV4Result audioV4Result : checkResponse.getResult()) {
                // 根据需要获取每段音频的检测结果，具体返回字段的说明，请参考官方接口文档中字段说明
            }
        }
    }
}
