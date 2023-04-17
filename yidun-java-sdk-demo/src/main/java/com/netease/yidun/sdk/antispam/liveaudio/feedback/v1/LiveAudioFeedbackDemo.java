
package com.netease.yidun.sdk.antispam.liveaudio.feedback.v1;

import java.util.ArrayList;
import java.util.List;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.liveaudio.LiveAudioClient;
import com.netease.yidun.sdk.antispam.liveaudio.feedback.v1.request.LiveAudioFeedback;
import com.netease.yidun.sdk.antispam.liveaudio.feedback.v1.request.LiveAudioFeedbackV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.feedback.v1.response.LiveAudioFeedbackV1Resp;

public class LiveAudioFeedbackDemo extends AbstractDemo {
    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        LiveAudioClient liveAudioClient = new LiveAudioClient(antispamRequester);

        // 实例化反馈请求对象
        LiveAudioFeedbackV1Req feedbackRequest = new LiveAudioFeedbackV1Req();
        // 设置易盾内容安全分配的businessId
        feedbackRequest.setBusinessId("BusinessId");
        // 反馈列表
        List<LiveAudioFeedback> feedbacks = new ArrayList<>();
        // 直播音频反馈对象
        LiveAudioFeedback feedback = new LiveAudioFeedback();
        feedback.setBackgroundImage("背景图");
        feedback.setTaskId("直播任务 id");
        // 直播标签对象
        LiveAudioFeedback.LiveAudioTag liveAudioTag = new LiveAudioFeedback.LiveAudioTag();
        List<String> tag = new ArrayList<>();
        tag.add("标签");
        liveAudioTag.setTag(tag);
        // 标签更新时间，用于排序
        liveAudioTag.setUpdateTime(System.currentTimeMillis());
        feedback.setLiveTag(liveAudioTag);
        // 弹幕数量
        feedback.setBarrageCount(1);
        feedbacks.add(feedback);
        feedbackRequest.setFeedbacks(feedbacks);

        LiveAudioFeedbackV1Resp feedbackResponse = null;
        try {
            // 发起反馈请求
            feedbackResponse = liveAudioClient.feedback(feedbackRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (feedbackResponse != null && feedbackResponse.getCode() == 200) {
            // 反馈结果响应
            List<LiveAudioFeedbackV1Resp.LiveAudioFeedbackV1Result> feedbackUnitList = feedbackResponse.getResult();
            for (LiveAudioFeedbackV1Resp.LiveAudioFeedbackV1Result feedbackUnitResp : feedbackUnitList) {
                // 处理反馈结果

            }
        }

    }
}
