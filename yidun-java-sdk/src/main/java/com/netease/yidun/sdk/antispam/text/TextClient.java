package com.netease.yidun.sdk.antispam.text;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.CallbackRegistry;
import com.netease.yidun.sdk.antispam.ClientRegistry;
import com.netease.yidun.sdk.antispam.text.query.TextTaskIdsQueryRequest;
import com.netease.yidun.sdk.antispam.text.query.TextTaskIdsQueryResponse;
import com.netease.yidun.sdk.antispam.text.v1.similar.SimilarTextSubmitRequest;
import com.netease.yidun.sdk.antispam.text.v1.similar.SimilarTextSubmitResponse;
import com.netease.yidun.sdk.antispam.text.v2.feedback.TextFeedbackRequest;
import com.netease.yidun.sdk.antispam.text.v2.feedback.TextFeedbackResponse;
import com.netease.yidun.sdk.antispam.text.v5.callback.TextCallback;
import com.netease.yidun.sdk.antispam.text.v5.callback.request.TextCallBackRequest;
import com.netease.yidun.sdk.antispam.text.v5.callback.response.TextCallBackResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.async.batch.TextAsyncBatchCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.async.batch.TextAsyncBatchCheckResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.async.single.TextAsyncCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.async.single.TextAsyncCheckResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.batch.TextBatchCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.batch.TextBatchCheckResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResponse;
import com.netease.yidun.sdk.antispam.text.v1.textfeature.TextFeatureAddRequest;
import com.netease.yidun.sdk.antispam.text.v1.textfeature.TextFeatureAddResponse;
import com.netease.yidun.sdk.antispam.text.v1.textfeature.TextFeatureDeleteRequest;
import com.netease.yidun.sdk.antispam.text.v1.textfeature.TextFeatureDeleteResponse;
import com.netease.yidun .sdk.antispam.text.v1.textfeature.TextFeatureQueryRequest;
import com.netease.yidun.sdk.antispam.text.v1.textfeature.TextFeatureQueryResponse;
import com.netease.yidun.sdk.antispam.text.v1.textfeature.TextFeatureEditStatusRequest;
import com.netease.yidun.sdk.antispam.text.v1.textfeature.TextFeatureEditStatusResponse;

/**
 * 文本client
 */
public class TextClient extends BaseClient {

    /**
     * 获取secretId对应的唯一实例
     *
     * @param textRequester
     * @return
     */
    public static TextClient getInstance(AntispamRequester textRequester) {
        return ClientRegistry.register(textRequester, TextClient.class);
    }

    /**
     * 获取secretId对应的唯一实例
     *
     * @param textRequester
     * @param textCallback
     * @return
     */
    public static TextClient getInstance(AntispamRequester textRequester, TextCallback... textCallback) {
        CallbackRegistry.register(textRequester, textCallback);
        return ClientRegistry.register(textRequester, TextClient.class);
    }

    public TextClient(AntispamRequester textRequester) {
        super(textRequester);
    }

    public TextClient(AntispamRequester textRequester, TextCallback textCallback) {
        super(textRequester, textCallback);
    }

    public TextClient(AntispamRequester textRequester, TextCallback... textCallback) {
        super(textRequester, textCallback);
    }

    public TextCheckResponse syncCheckText(TextCheckRequest request) {
        return requester.getTextCheckClient().syncCheckText(request);
    }

    public TextBatchCheckResponse syncBatchCheckText(TextBatchCheckRequest request) {
        return requester.getTextCheckClient().syncBatchCheckText(request);
    }

    public TextAsyncCheckResponse asyncCheckText(TextAsyncCheckRequest request) {
        return requester.getTextCheckClient().asyncCheckText(request);
    }

    public TextAsyncBatchCheckResponse asyncBatchCheckText(TextAsyncBatchCheckRequest request) {
        return requester.getTextCheckClient().asyncBatchCheckText(request);
    }

    public TextCallBackResponse callback(TextCallBackRequest request) {
        return requester.getTextCommonClient().callback(request);
    }

    public TextFeedbackResponse feedback(TextFeedbackRequest request) {
        return requester.getTextCommonClient().feedback(request);
    }

    public TextTaskIdsQueryResponse queryTaskIds(TextTaskIdsQueryRequest request) {
        return requester.getTextCommonClient().queryTaskIds(request);
    }

    /**
     * 提交相似文本
     *
     * @param request 相似文本提交请求
     * @return 相似文本提交响应
     */
    public SimilarTextSubmitResponse submitSimilarText(SimilarTextSubmitRequest request) {
        return requester.getTextCommonClient().submitSimilarText(request);
    }

    /**
     * 添加文本特征
     */
    public TextFeatureAddResponse addTextFeature(TextFeatureAddRequest request) {
        return requester.getTextCommonClient().addTextFeature(request);
    }

    /**
     * 删除文本特征
     */
    public TextFeatureDeleteResponse deleteTextFeature(TextFeatureDeleteRequest request) {
        return requester.getTextCommonClient().deleteTextFeature(request);
    }

    /**
     * 查询文本特征
     */
    public TextFeatureQueryResponse queryTextFeature(TextFeatureQueryRequest request) {
        return requester.getTextCommonClient().queryTextFeature(request);
    }

    /**
     * 修改文本特征状态
     */
    public TextFeatureEditStatusResponse editTextFeatureStatus(TextFeatureEditStatusRequest request) {
        return requester.getTextCommonClient().editTextFeatureStatus(request);
    }
}
