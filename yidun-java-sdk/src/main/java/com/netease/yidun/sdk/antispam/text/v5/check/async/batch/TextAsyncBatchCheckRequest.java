package com.netease.yidun.sdk.antispam.text.v5.check.async.batch;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckSceneRequest;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.List;
import java.util.Map;

/**
 * 文本批量异步检测请求
 */
public class TextAsyncBatchCheckRequest extends BizPostFormRequest<TextAsyncBatchCheckResponse> {

    /**
     * 业务过检分类,如果没有勾选分类提交返回参数错误，多个垃圾类别以逗号分隔（"100,200"）
     */
    @Size(max = 512, message = "checkLabels最长512个字符")
    private String checkLabels;

    @Size(min = 1, max = 100, message = "1-100条文本数据")
    private List<TextCheckSceneRequest> texts;

    /**
     * 内容安全与反作弊融合版专属字段，来自易盾反作弊SDK返回的token，接入SDK必传,接入流程请参考防刷版说明文档
     */
    @Size(max = 256, message = "token最长256个字符")
    private String token;

    public String getCheckLabels() {
        return checkLabels;
    }

    public void setCheckLabels(String checkLabels) {
        this.checkLabels = checkLabels;
    }

    public String checkLabels() {
        return checkLabels;
    }

    public TextAsyncBatchCheckRequest checkLabels(String checkLabels) {
        this.checkLabels = checkLabels;
        return this;
    }

    public List<TextCheckSceneRequest> getTexts() {
        return texts;
    }

    public void setTexts(List<TextCheckSceneRequest> texts) {
        this.texts = texts;
    }

    public List<TextCheckSceneRequest> texts() {
        return texts;
    }

    public TextAsyncBatchCheckRequest texts(List<TextCheckSceneRequest> texts) {
        this.texts = texts;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String token() {
        return token;
    }

    public TextAsyncBatchCheckRequest token(String token) {
        this.token = token;
        return this;
    }

    public TextAsyncBatchCheckRequest() {
        productCode = "text-check";
        version = "v5.2";
        uriPattern = "/v5/text/async-batch-check";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("checkLabels", checkLabels);
        params.put("texts", new Gson().toJson(texts));
        params.put("token", token);
        return params;
    }

    @Override
    public Class<TextAsyncBatchCheckResponse> getResponseClass() {
        return TextAsyncBatchCheckResponse.class;
    }

    @Override
    public String toString() {
        return "TextAsyncBatchCheckRequest("
                + "super=" + super.toString()
                + ", checkLabels=" + checkLabels
                + ", texts=" + texts
                + ", token=" + token
                + ")";
    }
}
