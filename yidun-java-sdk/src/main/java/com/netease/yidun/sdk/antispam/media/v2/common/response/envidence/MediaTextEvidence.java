package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;

import java.util.List;

/**
 * 融媒体机审-文本证据信息
 */
public class MediaTextEvidence {
    private String dataId;
    private String field;
    /**
     * 检测结果，0：通过，1：嫌疑，2：不通过
     */
    private Integer suggestion;
    /**
     * 专项信息
     */
    private String publicOpinionInfo;

    /**
     * 建议风险等级
     */
    private Integer suggestionRiskLevel;

    private Integer resultType;
    private Integer censorType;
    private List<StrategyVersion> strategyVersions;
    private List<TextLabelInfo> labels;
    private Boolean isRelatedHit;

    /**
     * 过滤后文本内容
     */
    private String filteredContent;

    public Integer getSuggestionRiskLevel() {
        return suggestionRiskLevel;
    }

    public void setSuggestionRiskLevel(Integer suggestionRiskLevel) {
        this.suggestionRiskLevel = suggestionRiskLevel;
    }


    public String getPublicOpinionInfo() {
        return publicOpinionInfo;
    }

    public void setPublicOpinionInfo(String publicOpinionInfo) {
        this.publicOpinionInfo = publicOpinionInfo;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Integer suggestion) {
        this.suggestion = suggestion;
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public Integer getCensorType() {
        return censorType;
    }

    public void setCensorType(Integer censorType) {
        this.censorType = censorType;
    }

    public List<StrategyVersion> getStrategyVersions() {
        return strategyVersions;
    }

    public String getFilteredContent() {
        return filteredContent;
    }

    public void setFilteredContent(String filteredContent) {
        this.filteredContent = filteredContent;
    }

    public void setStrategyVersions(List<StrategyVersion> strategyVersions) {
        this.strategyVersions = strategyVersions;
    }

    public List<TextLabelInfo> getLabels() {
        return labels;
    }

    public void setLabels(List<TextLabelInfo> labels) {
        this.labels = labels;
    }

    public Boolean getRelatedHit() {
        return isRelatedHit;
    }

    public void setRelatedHit(Boolean relatedHit) {
        isRelatedHit = relatedHit;
    }

    public static class TextLabelInfo {
        private Integer label;
        private List<TextSubLabel> subLabels;
        private Integer level;
        private Double rate;

        public Integer getLabel() {
            return label;
        }

        public void setLabel(Integer label) {
            this.label = label;
        }

        public List<TextSubLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<TextSubLabel> subLabels) {
            this.subLabels = subLabels;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public Double getRate() {
            return rate;
        }

        public void setRate(Double rate) {
            this.rate = rate;
        }
    }

    public static class TextSubLabel {
        private String subLabel;
        private TextCheckResult.AntispamSubLabelDetail details;
        private Integer subLabelDepth;
        private String secondLabel;
        private String thirdLabel;

        /**
         * 建议风险等级
         */
        private Integer suggestionRiskLevel;

        public Integer getSuggestionRiskLevel() {
            return suggestionRiskLevel;
        }

        public void setSuggestionRiskLevel(Integer suggestionRiskLevel) {
            this.suggestionRiskLevel = suggestionRiskLevel;
        }

        public String getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(String subLabel) {
            this.subLabel = subLabel;
        }

        public TextCheckResult.AntispamSubLabelDetail getDetails() {
            return details;
        }

        public void setDetails(TextCheckResult.AntispamSubLabelDetail details) {
            this.details = details;
        }

        public Integer getSubLabelDepth() {
            return subLabelDepth;
        }

        public void setSubLabelDepth(Integer subLabelDepth) {
            this.subLabelDepth = subLabelDepth;
        }

        public String getSecondLabel() {
            return secondLabel;
        }

        public void setSecondLabel(String secondLabel) {
            this.secondLabel = secondLabel;
        }

        public String getThirdLabel() {
            return thirdLabel;
        }

        public void setThirdLabel(String thirdLabel) {
            this.thirdLabel = thirdLabel;
        }

        @Override
        public String toString() {
            return "TextSubLabel{" +
                    "subLabel='" + subLabel + '\'' +
                    ", details=" + details +
                    ", subLabelDepth=" + subLabelDepth +
                    ", secondLabel='" + secondLabel + '\'' +
                    ", thirdLabel='" + thirdLabel + '\'' +
                    '}';
        }
    }

    public static class StrategyVersion {
        private Integer label;
        private String version;

        public Integer getLabel() {
            return label;
        }

        public void setLabel(Integer label) {
            this.label = label;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }


    }
}
