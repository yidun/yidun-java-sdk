package com.netease.yidun.sdk.antispam.text.v5.check.async.single;

import java.util.Map;

import javax.validation.constraints.Size;

import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckSceneRequest;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 文本单次异步检测请求
 */
public class TextAsyncCheckRequest extends TextCheckSceneRequest<TextAsyncCheckResponse> {

    /**
     * 业务过检分类,如果没有勾选分类提交返回参数错误，多个垃圾类别以逗号分隔（"100,200"）
     */
    @Size(max = 512, message = "checkLabels最长512个字符")
    private String checkLabels;

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

    public TextAsyncCheckRequest checkLabels(String checkLabels) {
        this.checkLabels = checkLabels;
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

    public TextAsyncCheckRequest token(String token) {
        this.token = token;
        return this;
    }

    public TextAsyncCheckRequest() {
        productCode = "text-check";
        version = "v5.2";
        uriPattern = "/v5/text/async-check";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("checkLabels", checkLabels);
        params.put("token", token);
        return params;
    }

    @Override
    public Class<TextAsyncCheckResponse> getResponseClass() {
        return TextAsyncCheckResponse.class;
    }

    @Override
    public String toString() {
        return "TextAsyncCheckRequest("
                + "super=" + super.toString()
                + ", checkLabels=" + checkLabels
                + ", token=" + token
                + ")";
    }
}
