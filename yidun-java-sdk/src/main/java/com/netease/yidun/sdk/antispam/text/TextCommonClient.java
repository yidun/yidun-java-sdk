package com.netease.yidun.sdk.antispam.text;


import com.netease.yidun.sdk.antispam.AntispamClient;
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
}
