package com.netease.yidun.sdk.antispam.grammarfix.v1.submit;

import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 文本纠错检测请求
 */
public class GrammarfixSubmitRequest extends BizPostFormRequest<GrammarfixSubmitResponse> {

    /**
     * 数据唯一标识，能够根据该值定位到该条数据
     */
    @NotBlank(message = "dataId不能为空")
    @Size(max = 128, message = "dataId最长128个字符")
    private String dataId;
    /**
     * 文本纠错内容
     */
    @NotBlank(message = "content不能为空")
    @Size(max = 2000, message = "content最长2000个字符")
    private String content;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String dataId() {
        return dataId;
    }

    public GrammarfixSubmitRequest dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String content() {
        return content;
    }

    public GrammarfixSubmitRequest content(String content) {
        this.content = content;
        return this;
    }

    public GrammarfixSubmitRequest() {
        productCode = "text-check";
        version = "v1";
        uriPattern = "/v1/grammarfix/submit";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("dataId", dataId);
        params.put("content", content);
        return params;
    }

    @Override
    public Class<GrammarfixSubmitResponse> getResponseClass() {
        return GrammarfixSubmitResponse.class;
    }

    @Override
    public String toString() {
        return "GrammarfixSubmitRequest("
                + "super=" + super.toString()
                + ", dataId=" + dataId
                + ", content=" + content
                + ")";
    }
}
