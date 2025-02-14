package com.netease.yidun.sdk.antispam.text;


import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.text.query.TextTaskIdsQueryRequest;
import com.netease.yidun.sdk.antispam.text.query.TextTaskIdsQueryResponse;
import com.netease.yidun.sdk.antispam.text.v1.similar.SimilarTextSubmitRequest;
import com.netease.yidun.sdk.antispam.text.v1.similar.SimilarTextSubmitResponse;
import com.netease.yidun.sdk.antispam.text.v2.feedback.TextFeedbackRequest;
import com.netease.yidun.sdk.antispam.text.v2.feedback.TextFeedbackResponse;
import com.netease.yidun.sdk.antispam.text.v5.callback.request.TextCallBackRequest;
import com.netease.yidun.sdk.antispam.text.v5.callback.response.TextCallBackResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class TextCommonClient extends AntispamClient {

    public TextCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public TextCallBackResponse callback(TextCallBackRequest request) {
        return client.execute(request);
    }

    public TextFeedbackResponse feedback(TextFeedbackRequest request) {
        return client.execute(request);
    }

    public TextTaskIdsQueryResponse queryTaskIds(TextTaskIdsQueryRequest request) {
        return client.execute(request);
    }

    /**
     * 提交相似文本
     *
     * @param request 相似文本提交请求
     * @return 相似文本提交响应
     */
    public SimilarTextSubmitResponse submitSimilarText(SimilarTextSubmitRequest request) {
        return client.execute(request);
    }
}
