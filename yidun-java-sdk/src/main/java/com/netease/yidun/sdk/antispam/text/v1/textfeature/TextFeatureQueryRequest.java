package com.netease.yidun.sdk.antispam.text.v1.textfeature;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 文本特征查询请求
 */
public class TextFeatureQueryRequest extends BizPostFormRequest<TextFeatureQueryResponse> {
    private String version = "v1";
    private Long startTime;
    private Long endTime;
    private Integer featureType;
    private Integer level;
    private Integer matchType;
    private Integer spamType;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
    private Integer scope;

    public TextFeatureQueryRequest() {
        productCode = "text-api";
        uriPattern = "/v1/text-feature/query";
    }

    @Override
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getFeatureType() {
        return featureType;
    }

    public void setFeatureType(Integer featureType) {
        this.featureType = featureType;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMatchType() {
        return matchType;
    }

    public void setMatchType(Integer matchType) {
        this.matchType = matchType;
    }

    public Integer getSpamType() {
        return spamType;
    }

    public void setSpamType(Integer spamType) {
        this.spamType = spamType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    @Override
    public Class<TextFeatureQueryResponse> getResponseClass() {
        return TextFeatureQueryResponse.class;
    }

    @Override
    protected java.util.Map<String, String> getCustomSignParams() {
        java.util.Map<String, String> params = super.getCustomSignParams();
        params.put("version", version);
        if (startTime != null) params.put("startTime", String.valueOf(startTime));
        if (endTime != null) params.put("endTime", String.valueOf(endTime));
        if (featureType != null) params.put("featureType", String.valueOf(featureType));
        if (level != null) params.put("level", String.valueOf(level));
        if (matchType != null) params.put("matchType", String.valueOf(matchType));
        if (spamType != null) params.put("spamType", String.valueOf(spamType));
        if (status != null) params.put("status", String.valueOf(status));
        if (pageNum != null) params.put("pageNum", String.valueOf(pageNum));
        if (pageSize != null) params.put("pageSize", String.valueOf(pageSize));
        if (scope != null) params.put("scope", String.valueOf(scope));
        return params;
    }

    @Override
    public String toString() {
        return "TextFeatureQueryRequest(" +
                "version=" + version +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", featureType=" + featureType +
                ", level=" + level +
                ", matchType=" + matchType +
                ", spamType=" + spamType +
                ", status=" + status +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", scope=" + scope +
                ")";
    }
}
