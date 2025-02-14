package com.netease.yidun.sdk.antispam.text.v1.similar;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;

import java.util.Map;

/**
 * 相似文本添加请求
 */
public class SimilarTextSubmitRequest extends BizPostFormRequest<SimilarTextSubmitResponse> {

    /**
     * 相似文本数据，json格式对象数组，1-200条相似文本数据
     */
    @NotBlank(message = "similarText不能为空")
    private String similarText;

    public String getSimilarText() {
        return similarText;
    }

    public void setSimilarText(String similarText) {
        this.similarText = similarText;
    }

    public String similarText() {
        return similarText;
    }

    public SimilarTextSubmitRequest similarText(String similarText) {
        this.similarText = similarText;
        return this;
    }

    public SimilarTextSubmitRequest() {
        productCode = "text-api";
        version = "v1";
        uriPattern = "/v1/similar-text/submit";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("similarText", similarText);
        return params;
    }

    @Override
    public Class<SimilarTextSubmitResponse> getResponseClass() {
        return SimilarTextSubmitResponse.class;
    }

    @Override
    public String toString() {
        return "SimilarTextSubmitRequest("
                + "super=" + super.toString()
                + ", similarText=" + similarText
                + ")";
    }
}