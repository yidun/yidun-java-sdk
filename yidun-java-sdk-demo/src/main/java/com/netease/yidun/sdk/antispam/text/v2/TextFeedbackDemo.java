package com.netease.yidun.sdk.antispam.text.v2;

import com.google.gson.Gson;
import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.text.TextClient;
import com.netease.yidun.sdk.antispam.text.v2.feedback.TextFeedbackRequest;
import com.netease.yidun.sdk.antispam.text.v2.feedback.TextFeedbackResponse;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文本反馈demo
 */
public class TextFeedbackDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        TextClient textClient = TextClient.getInstance(antispamRequester);
        // 实例化请求对象
        TextFeedbackRequest feedBackRequest = new TextFeedbackRequest();
        feedBackRequest.setProtocol(ProtocolEnum.HTTP);
        // 设置易盾内容安全分配的businessId
        feedBackRequest.setBusinessId("BusinessId");
        feedBackRequest.setFeedbacks(createFeedbacks());

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        TextFeedbackResponse feedBackResponse = null;
        try {
            // 发起feedback的请求
            feedBackResponse = textClient.feedback(feedBackRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (feedBackResponse != null && feedBackResponse.getCode() == 200) {
            for (TextFeedbackResponse.TextFeedbackResult feedBackResult : feedBackResponse.getResult()) {
                // 根据需要获取每个文本的feedback结果，具体返回字段的说明，请参考官方接口文档中字段说明
            }
        }

    }

    /**
     * 创建文本反馈数据
     */
    private static String createFeedbacks() {
        List<Map<String, Object>> feedbackList = new ArrayList<>();
        Map<String, Object> feedbackMap = new HashMap<>();
        feedbackMap.put("taskId", "检测任务ID");
        // 设置数据级别
        feedbackMap.put("level", 0);
        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        feedbackList.add(feedbackMap);

        return new Gson().toJson(feedbackList);
    }
}
