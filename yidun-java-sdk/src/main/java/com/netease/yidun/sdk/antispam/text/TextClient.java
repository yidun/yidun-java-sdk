package com.netease.yidun.sdk.antispam.text;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.CallbackRegistry;
import com.netease.yidun.sdk.antispam.ClientRegistry;
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
}
