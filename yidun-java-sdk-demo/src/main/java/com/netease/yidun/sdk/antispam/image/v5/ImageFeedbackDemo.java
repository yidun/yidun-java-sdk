package com.netease.yidun.sdk.antispam.image.v5;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.image.v5.feedback.request.ImageV5FeedBackRequest;
import com.netease.yidun.sdk.antispam.image.v5.feedback.response.ImageV5FeedBackResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片反馈demo
 */
public class ImageFeedbackDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        ImageClient imageClient = new ImageClient(antispamRequester);
        // 实例化请求对象
        ImageV5FeedBackRequest feedBackRequest = new ImageV5FeedBackRequest();
        // 设置易盾内容安全分配的businessId
        feedBackRequest.setBusinessId("BusinessId");

        // 实例化参数对象
        ImageV5FeedBackRequest.ImageFeedbackBeanRequest feedbackBeanRequest = new ImageV5FeedBackRequest.ImageFeedbackBeanRequest();
        feedbackBeanRequest.setTaskId("图片检测接口返回的数据唯一标识");
        // 设置图片数据级别，0：正常（通过），2：确定（不通过）
        feedbackBeanRequest.setLevel(2);
        // 设置图片的垃圾类别，当level为通过时，label字段可不传。分类信息，100：色情，110：性感，200：广告，210：二维码，260：广告法，300：暴恐，400：违禁 500：涉政，1100：涉价值观
        feedbackBeanRequest.setLabel(100);

        // 设置需要feedback的图片列表，一次调用最多反馈1000张图片结果
        List<ImageV5FeedBackRequest.ImageFeedbackBeanRequest> feedbacks = new ArrayList<>();
        feedbacks.add(feedbackBeanRequest);
        feedBackRequest.setFeedbacks(feedbacks);


        ImageV5FeedBackResponse feedBackResponse = null;
        try {
            // 发起feedback的请求
            feedBackResponse = imageClient.feedback(feedBackRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (feedBackResponse != null && feedBackResponse.getCode() == 200) {
            for (ImageV5FeedBackResponse.ImageV5FeedBackResult feedBackResult : feedBackResponse.getResult()) {
                // 根据需要获取每张图片的feedback结果，具体返回字段的说明，请参考官方接口文档中字段说明
            }
        }

    }
}
