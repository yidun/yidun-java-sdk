package com.netease.yidun.sdk.antispam.keyword.v2.update;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import java.util.List;
import java.util.Map;

/**
 * 自定义关键词修改请求
 */
public class KeywordUpdateRequest extends BizPostFormRequest<KeywordUpdateResponse> {

    /**
     * 关键词返回的垃圾分类
     */
    private Integer category;
    /**
     * 细分类
     */
    private String subLabel;
    /**
     * 关键词唯一标识id列表，逗号分隔
     */
    private String ids;

    private List<String> keywords;
    /**
     * 关键词状态，0: 未启用，1: 已启用
     */
    private Integer status;

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer category() {
        return category;
    }

    public KeywordUpdateRequest category(Integer category) {
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

    public KeywordUpdateRequest subLabel(String subLabel) {
        this.subLabel = subLabel;
        return this;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String ids() {
        return ids;
    }

    public KeywordUpdateRequest ids(String ids) {
        this.ids = ids;
        return this;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> keywords() {
        return keywords;
    }

    public KeywordUpdateRequest keywords(List<String> keywords) {
        this.keywords = keywords;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer status() {
        return status;
    }

    public KeywordUpdateRequest status(Integer status) {
        this.status = status;
        return this;
    }

    public KeywordUpdateRequest() {
        productCode = "keyword";
        version = "v2";
        uriPattern = "/v2/keyword/update";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("category", category != null ? String.valueOf(category) : null);
        params.put("subLabel", subLabel);
        params.put("ids", ids);
        if (keywords != null && keywords.size() > 0) {
            params.put("keywords", new Gson().toJson(keywords));
        }
        params.put("status", status != null ? String.valueOf(status) : null);
        return params;
    }

    @Override
    public Class<KeywordUpdateResponse> getResponseClass() {
        return KeywordUpdateResponse.class;
    }

    @Override
    public String toString() {
        return "KeywordUpdateRequest("
                + "super=" + super.toString()
                + ", category=" + category
                + ", subLabel=" + subLabel
                + ", ids=" + ids
                + ", keywords=" + keywords
                + ", status=" + status
                + ")";
    }
}
