
package com.netease.yidun.sdk.antispam.audio.feedback.v1;

import java.util.ArrayList;
import java.util.List;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.audio.AudioClient;
import com.netease.yidun.sdk.antispam.audio.feedback.v1.request.AudioFeedback;
import com.netease.yidun.sdk.antispam.audio.feedback.v1.request.AudioFeedbackRequest;
import com.netease.yidun.sdk.antispam.audio.feedback.v1.response.AudioFeedbackResponse;
import com.netease.yidun.sdk.antispam.audio.feedback.v1.response.AudioFeedbackUnitResp;
import com.netease.yidun.sdk.antispam.enums.LabelEnum;
import com.netease.yidun.sdk.antispam.enums.LevelEnum;

public class AudioFeedbackDemo extends AbstractDemo {
    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        AudioClient audioClient = AudioClient.getInstance(antispamRequester);

        // 实例化反馈请求对象
        AudioFeedbackRequest feedbackRequest = new AudioFeedbackRequest();
        // 设置易盾内容安全分配的businessId
        feedbackRequest.setBusinessId("BusinessId");
        List<AudioFeedback> feedbacks = new ArrayList<>();
        feedbacks.add(new AudioFeedback("第一条音频任务 id", LevelEnum.NORMAL.getCode(), null));
        feedbacks.add(new AudioFeedback("第二条音频任务 id", LevelEnum.CONFIRM.getCode(), LabelEnum.AD.getCode()));
        feedbackRequest.setFeedbacks(feedbacks);
        // 填写字段详细信息可参考官网文档 帮助中心 -> 音频检测 -> 点播音频接口

        AudioFeedbackResponse feedbackResponse = null;
        try {
            // 发起反馈请求
            feedbackResponse = audioClient.feedback(feedbackRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (feedbackResponse != null && feedbackResponse.getCode() == 200) {
            // 反馈结果响应
            List<AudioFeedbackUnitResp> feedbackUnitList = feedbackResponse.getResult();
            for (AudioFeedbackUnitResp feedbackUnitResp : feedbackUnitList) {
                // 处理反馈结果
                String taskId = feedbackUnitResp.getTaskId();
                Integer result = feedbackUnitResp.getResult();
            }
        }

    }
}
