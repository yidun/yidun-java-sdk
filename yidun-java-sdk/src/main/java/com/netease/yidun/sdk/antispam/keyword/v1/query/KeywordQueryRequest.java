package com.netease.yidun.sdk.antispam.keyword.v1.query;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.utils.StringUtils;

/**
 * 自定义关键词查询请求
 */
public class KeywordQueryRequest extends BizPostFormRequest<KeywordQueryResponse> {

    /**
     * 关键词唯一标识id
     */
    private Long id;
    /**
     * 关键词内容
     */
    @Size(max = 128, message = "keyword最长128个字符")
    private String keyword;
    /**
     * 关键词分类
     */
    private Integer category;
    /**
     * 排序类型
     */
    private Integer orderType;
    /**
     * 分页标号
     */
    @NotNull(message = "pageNum不能为空")
    private Integer pageNum = 1;
    /**
     * 分页大小
     */
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize = 20;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long id() {
        return id;
    }

    public KeywordQueryRequest id(Long id) {
        this.id = id;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String keyword() {
        return keyword;
    }

    public KeywordQueryRequest keyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer category() {
        return category;
    }

    public KeywordQueryRequest category(Integer category) {
        this.category = category;
        return this;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer orderType() {
        return orderType;
    }

    public KeywordQueryRequest orderType(Integer orderType) {
        this.orderType = orderType;
        return this;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer pageNum() {
        return pageNum;
    }

    public KeywordQueryRequest pageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer pageSize() {
        return pageSize;
    }

    public KeywordQueryRequest pageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public KeywordQueryRequest() {
        productCode = "keyword";
        version = "v1";
        uriPattern = "/v1/keyword/query";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("id", id != null ? String.valueOf(id) : null);
        params.put("keyword", keyword);
        params.put("category", category != null ? String.valueOf(category) : null);
        params.put("orderType", orderType != null ? String.valueOf(orderType) : null);
        params.put("pageNum", pageNum != null ? String.valueOf(pageNum) : null);
        params.put("pageSize", pageSize != null ? String.valueOf(pageSize) : null);
        return params;
    }

    @Override
    public Class<KeywordQueryResponse> getResponseClass() {
        return KeywordQueryResponse.class;
    }

    @Override
    public String toString() {
        return "KeywordQueryRequest("
                + "super=" + super.toString()
                + ", id=" + id
                + ", keyword=" + keyword
                + ", category=" + category
                + ", orderType=" + orderType
                + ", pageNum=" + pageNum
                + ", pageSize=" + pageSize
                + ")";
    }
}
