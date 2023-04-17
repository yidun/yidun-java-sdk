
package com.netease.yidun.sdk.antispam.video.callback.v4;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.video.VideoClient;
import com.netease.yidun.sdk.antispam.video.callback.v4.request.VideoCallbackV4Req;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackUnitV4Response;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackV4Resp;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackV4Result;

public class VideoCallbackDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");
        // 实例化发起请求的client对象
        VideoClient client = new VideoClient(antispamRequester);
        // 构建回调请求
        VideoCallbackV4Req request = new VideoCallbackV4Req();
        request.setBusinessId("BusinessId");
        VideoCallbackV4Resp response = null;
        try {
            response = client.callback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            for (VideoCallbackV4Result result : response.getResult()) {
                // 处理回调结果
                VideoCallbackUnitV4Response antispam = result.getAntispam();
            }
        }
    }
}
