package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioAntispamCallbackV4Response;

import java.util.List;

/**
 * 融媒体机审-音频证据信息
 */
public class MediaAudioEvidenceCommon {
    private Integer suggestion;
    private Integer status;
    /**
     * 失败原因
     */
    private Integer failureReason;

    /**
     * 专项信息
     */
    private String publicOpinionInfo;


    private Integer resultType;
    private Long checkTime;
    private Long duration;

    private Long durationMs;
    private List<SegmentsInfo> segments;

    public String getPublicOpinionInfo() {
        return publicOpinionInfo;
    }

    public void setPublicOpinionInfo(String publicOpinionInfo) {
        this.publicOpinionInfo = publicOpinionInfo;
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

    public List<SegmentsInfo> getSegments() {
        return segments;
    }

    public void setSegments(List<SegmentsInfo> segments) {
        this.segments = segments;
    }

    public Long getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Long durationMs) {
        this.durationMs = durationMs;
    }

    public static class SegmentsInfo {
        private Integer startTime;
        private Integer endTime;
        private String content;
        private Integer type;
        private List<AudioLabelInfo> labels;

        public Integer getStartTime() {
            return startTime;
        }

        public void setStartTime(Integer startTime) {
            this.startTime = startTime;
        }

        public Integer getEndTime() {
            return endTime;
        }

        public void setEndTime(Integer endTime) {
            this.endTime = endTime;
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

        public List<AudioLabelInfo> getLabels() {
            return labels;
        }

        public void setLabels(List<AudioLabelInfo> labels) {
            this.labels = labels;
        }
    }

    public static class AudioLabelInfo {
        private int label;
        private List<AudioSubLabel> subLabels;
        private int level;

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public List<AudioSubLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<AudioSubLabel> subLabels) {
            this.subLabels = subLabels;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }

    public static class AudioSubLabel {
        private String subLabel;
        private AudioAntispamCallbackV4Response.HintInfo details;
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

        public AudioAntispamCallbackV4Response.HintInfo getDetails() {
            return details;
        }

        public void setDetails(AudioAntispamCallbackV4Response.HintInfo details) {
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
     * 直接使用AudioAntispamCallbackV4Response.HintInfo，不需要融媒体业务自己维护
     * @deprecated
     */
    @Deprecated
    public static class AudioSubLabelDetail {
        /**
         * 命中内容
         */
        private List<HintDetail> hitInfos;
        /**
         * 自定义敏感词线索分类信息
         */
        private List<Keywords> keywords;
        /**
         * 自定义名单线索分类信息
         */
        private List<LibResult> libInfos;

        public List<HintDetail> getHitInfos() {
            return hitInfos;
        }

        public void setHitInfos(List<HintDetail> hitInfos) {
            this.hitInfos = hitInfos;
        }

        public List<Keywords> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<Keywords> keywords) {
            this.keywords = keywords;
        }

        public List<LibResult> getLibInfos() {
            return libInfos;
        }

        public void setLibInfos(List<LibResult> libInfos) {
            this.libInfos = libInfos;
        }
    }

    public static class LibResult {
        /**
         * 名单类型
         */
        private Integer listType;
        /**
         * 名单内容
         */
        private String entity;

        public Integer getListType() {
            return listType;
        }

        public void setListType(Integer listType) {
            this.listType = listType;
        }

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }
    }

    public static class Keywords {
        /**
         * 自定义添加敏感词
         */
        private String word;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }
    }

    public static class HintDetail {
        /**
         * 命中的敏感词或者声纹检测的分值
         */
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
