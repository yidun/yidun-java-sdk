package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

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
    private Integer resultType;
    private Integer censorType;
    private List<StrategyVersion> strategyVersions;
    private List<TextLabelInfo> labels;
    private Boolean isRelatedHit;

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
    }

    public static class TextSubLabel {
        private String subLabel;
        private TextSubLabelDetail details;
        private Integer subLabelDepth;
        private String secondLabel;
        private String thirdLabel;

        public String getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(String subLabel) {
            this.subLabel = subLabel;
        }

        public TextSubLabelDetail getDetails() {
            return details;
        }

        public void setDetails(TextSubLabelDetail details) {
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
