package com.netease.yidun.sdk.antispam.keyword.v1.delete;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import java.util.List;
import java.util.Map;

/**
 * 自定义关键词删除请求
 */
public class KeywordDeleteRequest extends BizPostFormRequest<KeywordDeleteResponse> {

    /**
     * 关键词唯一标识id列表，逗号分隔
     */
    private String ids;

    private List<String> keywords;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String ids() {
        return ids;
    }

    public KeywordDeleteRequest ids(String ids) {
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

    public KeywordDeleteRequest keywords(List<String> keywords) {
        this.keywords = keywords;
        return this;
    }

    public KeywordDeleteRequest() {
        productCode = "keyword";
        version = "v1";
        uriPattern = "/v1/keyword/delete";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("ids", ids);
        if (keywords != null && keywords.size() > 0) {
            params.put("keywords", new Gson().toJson(keywords));
        }
        return params;
    }

    @Override
    public Class<KeywordDeleteResponse> getResponseClass() {
        return KeywordDeleteResponse.class;
    }

    @Override
    public String toString() {
        return "KeywordDeleteRequest("
                + "super=" + super.toString()
                + ", ids=" + ids
                + ", keywords=" + keywords
                + ")";
    }
}
