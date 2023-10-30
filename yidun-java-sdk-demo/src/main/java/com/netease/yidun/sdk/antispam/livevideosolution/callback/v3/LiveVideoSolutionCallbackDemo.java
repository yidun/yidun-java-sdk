
package com.netease.yidun.sdk.antispam.livevideosolution.callback.v3;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.livevideosolution.LiveVideoSolutionClient;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.request.LiveWallSolutionCallbackV3Req;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response.LiveVideoSolutionCallbackV3Result;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response.LiveWallSolutionCallbackV3Resp;

public class LiveVideoSolutionCallbackDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        LiveVideoSolutionClient client = LiveVideoSolutionClient.getInstance(antispamRequester);
        // 构建回调请求对象
        LiveWallSolutionCallbackV3Req request = new LiveWallSolutionCallbackV3Req();
        LiveWallSolutionCallbackV3Resp response = null;
        try {
            response = client.callback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            for (LiveVideoSolutionCallbackV3Result result : response.getResult()) {
                // 处理回调结果
            }
        }

    }
}
