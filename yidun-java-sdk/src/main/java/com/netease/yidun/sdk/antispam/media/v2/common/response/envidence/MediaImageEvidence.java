package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import java.util.List;

/**
 * 融媒体机审-图片证据信息
 */
public class MediaImageEvidence {
    /** 检测结果，0 未开始、1检测中、2检测成功、3检测失败 */
    private Integer status;
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
    private Integer frameSize;
    private Integer censorType;
    /**
     * 失败原因
     */
    private Integer failureReason;
    private String dataId;
    private String taskId;
    private String field;
    private String name;
    private List<ImageLabelInfo> labels;

    /**
     * @see com.netease.is.antispam.common.constant.StrategySourceEnum
     *
     *      命中策略来源
     */
    private Integer hitSource;

    /**
     * @see com.netease.is.antispam.common.constant.CensorStatusLevel
     *
     * 嫌疑级别
     */
    private Integer suggestionLevel;
    /**
     * 命中一级标签
     */
    private Integer label;
    /**
     * 命中二级标签细分类
     */
    private String secondLabel;
    /**
     * 命中二级标签细分类
     */
    private String thirdLabel;

    /**
     * 命中策略类型
     *
     * @see com.netease.is.antispam.common.constant.HitType
     */
    private Integer hitType;
    /**
     * 策略类型 1 公有策略 2 私有策略
     */
    private Integer strategyType;
    /**
     * 命中结果
     */
    private String hitResult;
    private String riskDescription;

    /**
     * 图片 MD5 值（32位小写格式）
     */
    private String imgMd5;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(Integer frameSize) {
        this.frameSize = frameSize;
    }

    public Integer getCensorType() {
        return censorType;
    }

    public void setCensorType(Integer censorType) {
        this.censorType = censorType;
    }

    public Integer getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(Integer failureReason) {
        this.failureReason = failureReason;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ImageLabelInfo> getLabels() {
        return labels;
    }

    public void setLabels(List<ImageLabelInfo> labels) {
        this.labels = labels;
    }

    public String getImgMd5() {
        return imgMd5;
    }

    public void setImgMd5(String imgMd5) {
        this.imgMd5 = imgMd5;
    }

    public Integer getHitSource() {
        return hitSource;
    }

    public void setHitSource(Integer hitSource) {
        this.hitSource = hitSource;
    }

    public Integer getSuggestionLevel() {
        return suggestionLevel;
    }

    public void setSuggestionLevel(Integer suggestionLevel) {
        this.suggestionLevel = suggestionLevel;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
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

    public Integer getHitType() {
        return hitType;
    }

    public void setHitType(Integer hitType) {
        this.hitType = hitType;
    }

    public Integer getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(Integer strategyType) {
        this.strategyType = strategyType;
    }

    public String getHitResult() {
        return hitResult;
    }

    public void setHitResult(String hitResult) {
        this.hitResult = hitResult;
    }

    public String getRiskDescription() {
        return riskDescription;
    }

    public void setRiskDescription(String riskDescription) {
        this.riskDescription = riskDescription;
    }

    public static class ImageLabelInfo {
        private int label;
        private List<ImageSubLabel> subLabels;
        private int level;
        private float rate;

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public List<ImageSubLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<ImageSubLabel> subLabels) {
            this.subLabels = subLabels;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public float getRate() {
            return rate;
        }

        public void setRate(float rate) {
            this.rate = rate;
        }
    }

    public static class ImageSubLabel {
        private String subLabel;
        private Double rate;
        private ImageSubLabelDetail details;
        private Integer subLabelDepth;
        private String secondLabel;
        private String thirdLabel;

        /**
         * 建议风险等级
         */
        private Integer suggestionRiskLevel;
        /**
         * LLM 解释说明
         */
        private String explain;
        /**
         * 是否为LLM检测命中，true=大小模型融合检测; false=小模型标签证据补充
         */
        private Boolean isLlmCheck;
        private String riskDescription;

        public Integer getSuggestionRiskLevel() {
            return suggestionRiskLevel;
        }

        public void setSuggestionRiskLevel(Integer suggestionRiskLevel) {
            this.suggestionRiskLevel = suggestionRiskLevel;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        public Boolean getIsLlmCheck() {
            return isLlmCheck;
        }

        public void setIsLlmCheck(Boolean isLlmCheck) {
            this.isLlmCheck = isLlmCheck;
        }

        public String getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(String subLabel) {
            this.subLabel = subLabel;
        }

        public Double getRate() {
            return rate;
        }

        public void setRate(Double rate) {
            this.rate = rate;
        }

        public ImageSubLabelDetail getDetails() {
            return details;
        }

        public void setDetails(ImageSubLabelDetail details) {
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

        public String getRiskDescription() {
            return riskDescription;
        }

        public void setRiskDescription(String riskDescription) {
            this.riskDescription = riskDescription;
        }

        @Override
        public String toString() {
            return "ImageSubLabel{" +
                    "subLabel='" + subLabel + '\'' +
                    ", rate=" + rate +
                    ", details=" + details +
                    ", subLabelDepth=" + subLabelDepth +
                    ", secondLabel='" + secondLabel + '\'' +
                    ", thirdLabel='" + thirdLabel + '\'' +
                    ", explain='" + explain + '\'' +
                    ", isLlmCheck=" + isLlmCheck +
                    ", riskDescription='" + riskDescription + '\'' +
                    '}';
        }
    }
}
