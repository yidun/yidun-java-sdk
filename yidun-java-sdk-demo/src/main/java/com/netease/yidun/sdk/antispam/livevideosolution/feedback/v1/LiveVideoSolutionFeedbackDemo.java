
package com.netease.yidun.sdk.antispam.livevideosolution.feedback.v1;

import java.util.ArrayList;
import java.util.List;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.enums.LiveVideoFeedBackStatusEnum;
import com.netease.yidun.sdk.antispam.livevideosolution.LiveVideoSolutionClient;
import com.netease.yidun.sdk.antispam.livevideosolution.feedback.v1.request.LiveWallSolutionFeedback;
import com.netease.yidun.sdk.antispam.livevideosolution.feedback.v1.request.LiveWallSolutionFeedbackV1Req;
import com.netease.yidun.sdk.antispam.livevideosolution.feedback.v1.response.LiveWallSolutionFeedbackV1Resp;

public class LiveVideoSolutionFeedbackDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        LiveVideoSolutionClient client = LiveVideoSolutionClient.getInstance(antispamRequester);
        LiveWallSolutionFeedbackV1Req request = new LiveWallSolutionFeedbackV1Req();
        List<LiveWallSolutionFeedback> realTimeInfoList = new ArrayList<>();
        // 设置直播反馈对象
        LiveWallSolutionFeedback feedback = new LiveWallSolutionFeedback();
        feedback.setTaskId("任务 id");
        feedback.setStatus(LiveVideoFeedBackStatusEnum.STOP.getValue());
        realTimeInfoList.add(feedback);
        request.setRealTimeInfoList(realTimeInfoList);
        LiveWallSolutionFeedbackV1Resp response = null;
        try {
            response = client.feedback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            for (LiveWallSolutionFeedbackV1Resp.LiveVideoSolutionFeedbackV1Result feedbackV1Result : response
                    .getResult()) {
                // 处理反馈结果响应对象
            }
        }
    }
}
