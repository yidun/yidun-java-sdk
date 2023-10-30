
package com.netease.yidun.sdk.antispam.videosolution.feedback.v1;

import java.util.ArrayList;
import java.util.List;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.enums.LabelEnum;
import com.netease.yidun.sdk.antispam.enums.LevelEnum;
import com.netease.yidun.sdk.antispam.videosolution.VideoSolutionClient;
import com.netease.yidun.sdk.antispam.videosolution.feedback.v1.request.VideoSolutionFeedback;
import com.netease.yidun.sdk.antispam.videosolution.feedback.v1.request.VideoSolutionFeedbackV1Req;
import com.netease.yidun.sdk.antispam.videosolution.feedback.v1.response.VideoSolutionFeedbackV1Resp;

public class VideoSolutionFeedbackDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        VideoSolutionClient client = VideoSolutionClient.getInstance(antispamRequester);
        // 构建反馈请求
        VideoSolutionFeedbackV1Req request = new VideoSolutionFeedbackV1Req();
        // 新建反馈列表
        List<VideoSolutionFeedback> feedbacks = new ArrayList<>();
        VideoSolutionFeedback feedback = new VideoSolutionFeedback();
        // 设置点播音视频任务 id
        feedback.setTaskId("任务 id");
        // 设置反馈标签
        List<String> tags = new ArrayList<>();
        tags.add("标签");
        // 设置反馈标签
        feedback.setTags(tags);
        // 设置反馈的分类类型
        feedback.setLabel(LabelEnum.POLITICS.getCode());
        // 设置反馈的分类级别
        feedback.setLevel(LevelEnum.SUSPECT.getCode());
        feedbacks.add(feedback);
        request.setFeedbacks(feedbacks);
        VideoSolutionFeedbackV1Resp response = null;
        try {
            response = client.feedback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            for (VideoSolutionFeedbackV1Resp.VideoSolutionFeedbackV1Result result : response.getResult()) {
                // 处理反馈的结果
                String taskId = result.getTaskId();
                Integer status = result.getResult();

            }
        }
    }
}
