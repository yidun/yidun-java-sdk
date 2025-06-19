package com.netease.yidun.sdk.antispam.text.v1.textfeature;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 文本特征添加请求
 */
public class TextFeatureAddRequest extends BizPostFormRequest<TextFeatureAddResponse> {
    private String version = "v1";
    private Integer featureType;
    private Integer level;
    private Integer matchType;
    private Integer spamType;
    private String subLabel;
    private String description;
    private String entities;
    private Integer scope;

    public TextFeatureAddRequest() {
        productCode = "text-api";
        uriPattern = "/v1/text-feature/add";
    }

    @Override
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getSubLabel() {
        return subLabel;
    }

    public void setSubLabel(String subLabel) {
        this.subLabel = subLabel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntities() {
        return entities;
    }

    public void setEntities(String entities) {
        this.entities = entities;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    @Override
    public Class<TextFeatureAddResponse> getResponseClass() {
        return TextFeatureAddResponse.class;
    }

    @Override
    protected java.util.Map<String, String> getCustomSignParams() {
        java.util.Map<String, String> params = super.getCustomSignParams();
        params.put("version", version);
        if (featureType != null) params.put("featureType", String.valueOf(featureType));
        if (level != null) params.put("level", String.valueOf(level));
        if (matchType != null) params.put("matchType", String.valueOf(matchType));
        if (spamType != null) params.put("spamType", String.valueOf(spamType));
        if (subLabel != null) params.put("subLabel", subLabel);
        if (description != null) params.put("description", description);
        if (entities != null) params.put("entities", entities);
        if (scope != null) params.put("scope", String.valueOf(scope));
        return params;
    }

    @Override
    public String toString() {
        return "TextFeatureAddRequest(" +
                "version=" + version +
                ", featureType=" + featureType +
                ", level=" + level +
                ", matchType=" + matchType +
                ", spamType=" + spamType +
                ", subLabel=" + subLabel +
                ", description=" + description +
                ", entities=" + entities +
                ", scope=" + scope +
                ")";
    }
}
