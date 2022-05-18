
package com.netease.yidun.sdk.antispam.livevideo.callback.v4;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.livevideo.LiveVideoClient;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.request.LiveVideoCallbackReq;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveCallbackUnitV4;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveVideoCallbackResp;

public class LiveVideoCallbackDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");
        // 实例化发起请求的client对象
        LiveVideoClient client = new LiveVideoClient(antispamRequester);
        // 直播音频异步检测结果建议通过轮询回调或者主动回调（2选1）的方式来获取最新的检测结果，并根据业务场景自行处理
        // 轮询回调初始化如下，如果需要启用轮询回调，请参考如下注释内容：
        // CallbackProfile callbackProfile = new CallbackProfile("BusinessId");
        // // 调整轮询回调的最大线程数，不设置则默认值为3
        // callbackProfile.setConcurrency(2);
        // LiveVideoCallback callback = new LiveVideoCallback(callbackProfile) {
        // @Override
        // public void handle(List<LiveCallbackUnitV4> callbackData) {
        //
        // }
        // };
        // LiveVideoClient client = new LiveVideoClient(antispamRequester, callback);
        LiveVideoCallbackReq request = new LiveVideoCallbackReq();
        request.setBusinessId("BusinessId");
        LiveVideoCallbackResp response = null;
        try {
            response = client.callback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            // 处理回调结果
            for (LiveCallbackUnitV4 liveCallbackUnitV4 : response.getResult()) {

            }
        }
    }
}
