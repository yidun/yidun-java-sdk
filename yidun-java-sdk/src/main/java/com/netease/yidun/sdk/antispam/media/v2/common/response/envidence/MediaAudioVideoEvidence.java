package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import com.netease.yidun.sdk.antispam.video.callback.v4.response.ImageV5SubLabelResp;

import java.util.List;

/**
 * 融媒体机审-音视频证据信息
 */
public class MediaAudioVideoEvidence {
    private String dataId;
    private String taskId;
    private String field;
    private Integer suggestion;

    private String publicOpinionInfo;
    private Integer status;
    private Integer resultType;

    /**
     * 建议风险等级
     */
    private Integer suggestionRiskLevel;
    /**
     * 失败原因
     */
    private Integer failureReason;
    private String riskDescription;
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
     * 命中三级标签细分类
     */
    private String thirdLabel;
    private Long checkTime;
    private Long duration;

    private Long durationMs;
    private MediaAudioVideoDetailEvidence evidences;

    /**
     * @see com.netease.is.antispam.common.constant.StrategySourceEnum
     *
     *      命中策略来源
     */
    private Integer strategySource;

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

    public Integer getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Integer suggestion) {
        this.suggestion = suggestion;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public Integer getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(Integer failureReason) {
        this.failureReason = failureReason;
    }

    public String getRiskDescription() {
        return riskDescription;
    }

    public void setRiskDescription(String riskDescription) {
        this.riskDescription = riskDescription;
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

    public Integer getStrategySource() {
        return strategySource;
    }

    public void setStrategySource(Integer strategySource) {
        this.strategySource = strategySource;
    }

    public Long getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Long checkTime) {
        this.checkTime = checkTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Long durationMs) {
        this.durationMs = durationMs;
    }

    public MediaAudioVideoDetailEvidence getEvidences() {
        return evidences;
    }

    public void setEvidences(MediaAudioVideoDetailEvidence evidences) {
        this.evidences = evidences;
    }

    public static class MediaAudioVideoDetailEvidence {
        private MediaAudioEvidenceCommon audio;
        private MediaVideoEvidence video;

        public MediaAudioEvidenceCommon getAudio() {
            return audio;
        }

        public void setAudio(MediaAudioEvidenceCommon audio) {
            this.audio = audio;
        }

        public MediaVideoEvidence getVideo() {
            return video;
        }

        public void setVideo(MediaVideoEvidence video) {
            this.video = video;
        }
    }

    public static class MediaVideoEvidence {
        private Integer suggestion;
        /**
         * @see com.netease.is.antispam.common.constant.CensorStatusLevel
         *
         * 嫌疑级别
         */
        private Integer suggestionLevel;
        private Integer status;
        private Integer failureReason;
        private Integer resultType;
        private Long checkTime;
        private Long duration;
        private List<PictureInfo> pictures;

        public Integer getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Integer suggestion) {
            this.suggestion = suggestion;
        }

        public Integer getSuggestionLevel() {
            return suggestionLevel;
        }

        public void setSuggestionLevel(Integer suggestionLevel) {
            this.suggestionLevel = suggestionLevel;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getFailureReason() {
            return failureReason;
        }

        public void setFailureReason(Integer failureReason) {
            this.failureReason = failureReason;
        }

        public Integer getResultType() {
            return resultType;
        }

        public void setResultType(Integer resultType) {
            this.resultType = resultType;
        }

        public Long getCheckTime() {
            return checkTime;
        }

        public void setCheckTime(Long checkTime) {
            this.checkTime = checkTime;
        }

        public Long getDuration() {
            return duration;
        }

        public void setDuration(Long duration) {
            this.duration = duration;
        }

        public List<PictureInfo> getPictures() {
            return pictures;
        }

        public void setPictures(List<PictureInfo> pictures) {
            this.pictures = pictures;
        }
    }

    public static class PictureInfo {
        private Long startTime;
        private Long endTime;
        // 专项信息
        private String publicOpinionInfo;
        private String content;
        private Integer type;
        private String url;
        private List<VideoLabelInfo> labels;
        // 建议风险等级
        private Integer suggestionRiskLevel;
        private List<RelatedPicInfoResponse> frontPics;
        private List<RelatedPicInfoResponse> backPics;
        /**
         * 大模型检测状态：1-成功，2-失败
         */
        private Integer llmStatus;
        /**
         * 大模型检测失败原因（errorCode原始值），成功时为null
         */
        private Integer llmFailureReason;

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

        public String getPublicOpinionInfo() {
            return publicOpinionInfo;
        }

        public void setPublicOpinionInfo(String publicOpinionInfo) {
            this.publicOpinionInfo = publicOpinionInfo;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<VideoLabelInfo> getLabels() {
            return labels;
        }

        public void setLabels(List<VideoLabelInfo> labels) {
            this.labels = labels;
        }

        public Integer getSuggestionRiskLevel() {
            return suggestionRiskLevel;
        }

        public void setSuggestionRiskLevel(Integer suggestionRiskLevel) {
            this.suggestionRiskLevel = suggestionRiskLevel;
        }

        public List<RelatedPicInfoResponse> getFrontPics() {
            return frontPics;
        }

        public void setFrontPics(List<RelatedPicInfoResponse> frontPics) {
            this.frontPics = frontPics;
        }

        public List<RelatedPicInfoResponse> getBackPics() {
            return backPics;
        }

        public void setBackPics(List<RelatedPicInfoResponse> backPics) {
            this.backPics = backPics;
        }

        public Integer getLlmStatus() {
            return llmStatus;
        }

        public void setLlmStatus(Integer llmStatus) {
            this.llmStatus = llmStatus;
        }

        public Integer getLlmFailureReason() {
            return llmFailureReason;
        }

        public void setLlmFailureReason(Integer llmFailureReason) {
            this.llmFailureReason = llmFailureReason;
        }
    }

    public static class VideoLabelInfo {
        private Integer label;
        private List<AudioSubLabel> subLabels;
        private Integer level;
        private Double rate;

        public Integer getLabel() {
            return label;
        }

        public void setLabel(Integer label) {
            this.label = label;
        }

        public List<AudioSubLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<AudioSubLabel> subLabels) {
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

    public static class AudioSubLabel {
        private String subLabel;
        private Double rate;
        private Integer subLabelDepth;
        private String secondLabel;
        private String thirdLabel;
        /**
         * 建议风险等级
         */
        private Integer suggestionRiskLevel;
        private ImageV5SubLabelResp.SubLabelDetails details;
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

        public String getRiskDescription() {
            return riskDescription;
        }

        public void setRiskDescription(String riskDescription) {
            this.riskDescription = riskDescription;
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

        public ImageV5SubLabelResp.SubLabelDetails getDetails() {
            return details;
        }

        public void setDetails(ImageV5SubLabelResp.SubLabelDetails details) {
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
    }

    /**
     * 相邻截图信息
     */
    public static class RelatedPicInfoResponse {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
