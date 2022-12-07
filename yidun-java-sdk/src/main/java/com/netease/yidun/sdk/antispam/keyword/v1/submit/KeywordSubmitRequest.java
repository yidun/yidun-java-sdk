package com.netease.yidun.sdk.antispam.keyword.v1.submit;

import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 自定义关键词添加请求
 */
public class KeywordSubmitRequest extends BizPostFormRequest<KeywordSubmitResponse> {

    /**
     * 关键词返回的垃圾分类
     */
    @NotNull(message = "category不能为空")
    private Integer category;
    /**
     * 细分类
     */
    @NotBlank(message = "subLabel不能为空")
    private String subLabel;
    /**
     * 关键词检测列表
     */
    private Set<String> keywords;
    /**
     * 关键词等级，1: 嫌疑，2: 不通过
     */
    @NotNull(message = "level不能为空")
    private Integer level;
    /**
     * 关键词类型，1: 普通词，2: 组合词，3: 拼音词
     */
    @NotNull(message = "type不能为空")
    private Integer type;

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer category() {
        return category;
    }

    public KeywordSubmitRequest category(Integer category) {
        this.category = category;
        return this;
    }

    public String getSubLabel() {
        return subLabel;
    }

    public void setSubLabel(String subLabel) {
        this.subLabel = subLabel;
    }

    public String subLabel() {
        return subLabel;
    }

    public KeywordSubmitRequest subLabel(String subLabel) {
        this.subLabel = subLabel;
        return this;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public Set<String> keywords() {
        return keywords;
    }

    public KeywordSubmitRequest keywords(Set<String> keywords) {
        this.keywords = keywords;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer level() {
        return level;
    }

    public KeywordSubmitRequest level(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer type() {
        return type;
    }

    public KeywordSubmitRequest type(Integer type) {
        this.type = type;
        return this;
    }

    public KeywordSubmitRequest() {
        productCode = "keyword";
        version = "v1.1";
        uriPattern = "/v1/keyword/submit";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("category", category != null ? String.valueOf(category) : null);
        params.put("subLabel", subLabel);
        params.put("keywords", String.join(",", keywords));
        params.put("level", level != null ? String.valueOf(level) : null);
        params.put("type", type != null ? String.valueOf(type) : null);
        return params;
    }

    @Override
    public Class<KeywordSubmitResponse> getResponseClass() {
        return KeywordSubmitResponse.class;
    }

    @Override
    public String toString() {
        return "KeywordSubmitRequest("
                + "super=" + super.toString()
                + ", category=" + category
                + ", subLabel=" + subLabel
                + ", keywords=" + keywords
                + ", level=" + level
                + ", type=" + type
                + ")";
    }
}
