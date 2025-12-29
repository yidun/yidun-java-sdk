
package com.netease.yidun.sdk.antispam.videosolution.callback.v2;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioAsrCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioLanguageCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioVoiceCallbackV4Response;
import com.netease.yidun.sdk.antispam.videosolution.VideoSolutionClient;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.request.VideoSolutionCallbackV2Req;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionAntispamCallbackV2Response;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionCallbackV2Resp;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionCallbackV2Result;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

public class VideoSolutionCallbackDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        VideoSolutionClient client = VideoSolutionClient.getInstance(antispamRequester);
        // 设置回调请求对象
        VideoSolutionCallbackV2Req request = new VideoSolutionCallbackV2Req();
        request.setProtocol(ProtocolEnum.HTTP);
        // 适用于指定taskId回调，此功能默认关闭，需联系策略经理在产品维度开启后方可生效，每次请求可传入一个taskId
        // request.setTaskId("taskId");
        // 发起回调请求
        VideoSolutionCallbackV2Resp response = null;
        try {
            response = client.callback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            for (VideoSolutionCallbackV2Result result : response.getResult()) {
                // 处理回调响应结果，详细字段注释信息可参考官网文档 帮助中心 -> 音视频解决方案 -> 结果获取 -> 轮询模式响应结果
                VideoSolutionAntispamCallbackV2Response antispam = result.getAntispam();
                AudioAsrCallbackV4Response asr = result.getAsr();
                AudioLanguageCallbackV4Response language = result.getLanguage();
                AudioVoiceCallbackV4Response voice = result.getVoice();
            }
        }
    }
}
