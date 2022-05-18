package com.netease.yidun.sdk.antispam.text.v2.feedback;

import java.util.Map;

import javax.validation.constraints.NotBlank;

import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 文本结果反馈请求
 */
public class TextFeedbackRequest extends BizPostFormRequest<TextFeedbackResponse> {

    /**
     * 文本反馈数据，json格式对象数组，1-100条文本反馈数据
     */
    @NotBlank(message = "feedbacks不能为空")
    private String feedbacks;

    public String getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(String feedbacks) {
        this.feedbacks = feedbacks;
    }

    public String feedbacks() {
        return feedbacks;
    }

    public TextFeedbackRequest feedbacks(String feedbacks) {
        this.feedbacks = feedbacks;
        return this;
    }

    public TextFeedbackRequest() {
        productCode = "text-api";
        version = "v2";
        uriPattern = "/v2/text/feedback";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("feedbacks", feedbacks);
        return params;
    }

    @Override
    public Class<TextFeedbackResponse> getResponseClass() {
        return TextFeedbackResponse.class;
    }

    @Override
    public String toString() {
        return "TextFeedbackRequest("
                + "super=" + super.toString()
                + ", feedbacks=" + feedbacks
                + ")";
    }
}
