package com.netease.yidun.sdk.antispam.text;

import com.netease.yidun.sdk.antispam.AntispamRequester;
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
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 文本client
 */
public class TextClient {

    private AntispamRequester textRequester;

    public TextClient(AntispamRequester textRequester) {
        AssertUtils.notNull(textRequester, "textRequester can not be null");
        this.textRequester = textRequester;
    }

    public TextClient(AntispamRequester textRequester, TextCallback textCallback) {
        AssertUtils.notNull(textRequester, "textRequester can not be null");

        this.textRequester = textRequester;
        if (textCallback != null) {
            if (textCallback.getAntispamRequester() == null) {
                textCallback.setAntispamRequester(textRequester);
            }
            textCallback.start();
        }
    }

    public TextCheckResponse syncCheckText(TextCheckRequest request) {
        return textRequester.getTextCheckClient().syncCheckText(request);
    }

    public TextBatchCheckResponse syncBatchCheckText(TextBatchCheckRequest request) {
        return textRequester.getTextCheckClient().syncBatchCheckText(request);
    }

    public TextAsyncCheckResponse asyncCheckText(TextAsyncCheckRequest request) {
        return textRequester.getTextCheckClient().asyncCheckText(request);
    }

    public TextAsyncBatchCheckResponse asyncBatchCheckText(TextAsyncBatchCheckRequest request) {
        return textRequester.getTextCheckClient().asyncBatchCheckText(request);
    }

    public TextCallBackResponse callback(TextCallBackRequest request) {
        return textRequester.getTextCommonClient().callback(request);
    }

    public TextFeedbackResponse feedback(TextFeedbackRequest request) {
        return textRequester.getTextCommonClient().feedback(request);
    }
}
