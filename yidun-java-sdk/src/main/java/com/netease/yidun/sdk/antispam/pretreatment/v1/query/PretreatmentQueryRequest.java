package com.netease.yidun.sdk.antispam.pretreatment.v1.query;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.Map;

/**
 * 自定义忽略词查询请求
 */
public class PretreatmentQueryRequest extends BizPostFormRequest<PretreatmentQueryResponse> {

    /**
     * 忽略词id
     */
    private Long id;
    /**
     * 忽略词内容
     */
    @Size(max = 128, message = "entity最长128个字符")
    private String entity;
    /**
     * 开始时间
     */
    private Long startTime;
    /**
     * 结束时间
     */
    private Long endTime;
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

    public PretreatmentQueryRequest id(Long id) {
        this.id = id;
        return this;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String entity() {
        return entity;
    }

    public PretreatmentQueryRequest entity(String entity) {
        this.entity = entity;
        return this;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long startTime() {
        return startTime;
    }

    public PretreatmentQueryRequest startTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long endTime() {
        return endTime;
    }

    public PretreatmentQueryRequest endTime(Long endTime) {
        this.endTime = endTime;
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

    public PretreatmentQueryRequest pageNum(Integer pageNum) {
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

    public PretreatmentQueryRequest pageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public PretreatmentQueryRequest() {
        productCode = "pretreatment";
        version = "v1";
        uriPattern = "/v1/pretreatment/pageQuery";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("id", id != null ? String.valueOf(id) : null);
        params.put("entity", entity);
        params.put("startTime", startTime != null ? String.valueOf(startTime) : null);
        params.put("endTime", endTime != null ? String.valueOf(endTime) : null);
        params.put("pageNum", pageNum != null ? String.valueOf(pageNum) : null);
        params.put("pageSize", pageSize != null ? String.valueOf(pageSize) : null);
        return params;
    }

    @Override
    public Class<PretreatmentQueryResponse> getResponseClass() {
        return PretreatmentQueryResponse.class;
    }

    @Override
    public String toString() {
        return "PretreatmentQueryRequest("
                + "super=" + super.toString()
                + ", id=" + id
                + ", entity=" + entity
                + ", startTime=" + startTime
                + ", endTime=" + endTime
                + ", pageNum=" + pageNum
                + ", pageSize=" + pageSize
                + ")";
    }
}
