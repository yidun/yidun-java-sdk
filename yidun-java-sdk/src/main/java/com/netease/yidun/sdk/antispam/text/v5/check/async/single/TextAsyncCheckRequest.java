package com.netease.yidun.sdk.antispam.text.v5.check.async.single;

import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckSceneRequest;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.Map;

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
     * 业务指定过检策略组id,多个策略组id以逗号分隔（"xxx,xxx"），最多支持传20个
     */
    @Size(max = 512, message = "checkStrategyGroupIds最长512个字符")
    private String checkStrategyGroupIds;

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

    public String getCheckStrategyGroupIds() {
        return checkStrategyGroupIds;
    }

    public void setCheckStrategyGroupIds(String checkStrategyGroupIds) {
        this.checkStrategyGroupIds = checkStrategyGroupIds;
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
        version = "v5.3";
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
