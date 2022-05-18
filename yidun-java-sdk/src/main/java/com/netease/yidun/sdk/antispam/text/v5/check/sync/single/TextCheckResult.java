package com.netease.yidun.sdk.antispam.text.v5.check.sync.single;

import java.io.Serializable;
import java.util.List;

/**
 * 文本检测结果
 */
public class TextCheckResult implements Serializable {

    /**
     * 文本内容安全检测结果
     */
    private Antispam antispam;
    /**
     * 文本情感分析检测结果
     */
    private EmotionAnalysis emotionAnalysis;
    /**
     * 文本反作弊检测结果
     */
    private Anticheat anticheat;
    /**
     * 文本用户画像检测结果
     */
    private UserRisk userRisk;
    /**
     * 文本语种检测结果
     */
    private Language language;

    public Antispam getAntispam() {
        return antispam;
    }

    public void setAntispam(Antispam antispam) {
        this.antispam = antispam;
    }

    public EmotionAnalysis getEmotionAnalysis() {
        return emotionAnalysis;
    }

    public void setEmotionAnalysis(EmotionAnalysis emotionAnalysis) {
        this.emotionAnalysis = emotionAnalysis;
    }

    public Anticheat getAnticheat() {
        return anticheat;
    }

    public void setAnticheat(Anticheat anticheat) {
        this.anticheat = anticheat;
    }

    public UserRisk getUserRisk() {
        return userRisk;
    }

    public void setUserRisk(UserRisk userRisk) {
        this.userRisk = userRisk;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "TextCheckResult("
                + "antispam=" + antispam
                + ", emotionAnalysis=" + emotionAnalysis
                + ", anticheat=" + anticheat
                + ", userRisk=" + userRisk
                + ", language=" + language
                + ")";
    }

    public static class Antispam {

        private String taskId;
        private String dataId;
        private Integer suggestion;
        private Integer resultType;
        private Integer censorType;
        private String callback;
        private List<CensorLabel> censorLabels;
        private List<StrategyVersion> strategyVersions;
        private Integer censorSource;
        private Integer censorRound;
        private Long censorTime;
        private Boolean isRelatedHit;
        private List<AntispamLabel> labels;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
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

        public String getCallback() {
            return callback;
        }

        public void setCallback(String callback) {
            this.callback = callback;
        }

        public List<CensorLabel> getCensorLabels() {
            return censorLabels;
        }

        public void setCensorLabels(List<CensorLabel> censorLabels) {
            this.censorLabels = censorLabels;
        }

        public List<StrategyVersion> getStrategyVersions() {
            return strategyVersions;
        }

        public void setStrategyVersions(List<StrategyVersion> strategyVersions) {
            this.strategyVersions = strategyVersions;
        }

        public Integer getCensorSource() {
            return censorSource;
        }

        public void setCensorSource(Integer censorSource) {
            this.censorSource = censorSource;
        }

        public Integer getCensorRound() {
            return censorRound;
        }

        public void setCensorRound(Integer censorRound) {
            this.censorRound = censorRound;
        }

        public Long getCensorTime() {
            return censorTime;
        }

        public void setCensorTime(Long censorTime) {
            this.censorTime = censorTime;
        }

        public Boolean getRelatedHit() {
            return isRelatedHit;
        }

        public void setRelatedHit(Boolean relatedHit) {
            isRelatedHit = relatedHit;
        }

        public List<AntispamLabel> getLabels() {
            return labels;
        }

        public void setLabels(List<AntispamLabel> labels) {
            this.labels = labels;
        }

        @Override
        public String toString() {
            return "Antispam("
                    + "taskId=" + taskId
                    + ", dataId=" + dataId
                    + ", suggestion=" + suggestion
                    + ", resultType=" + resultType
                    + ", censorType=" + censorType
                    + ", callback=" + callback
                    + ", censorLabels=" + censorLabels
                    + ", strategyVersions=" + strategyVersions
                    + ", censorSource=" + censorSource
                    + ", censorRound=" + censorRound
                    + ", censorTime=" + censorTime
                    + ", isRelatedHit=" + isRelatedHit
                    + ", labels=" + labels
                    + ")";
        }
    }

    public static class CensorLabel {

        private String code;
        private String desc;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "CensorLabel("
                    + "code=" + code
                    + ", desc=" + desc
                    + ")";
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

        @Override
        public String toString() {
            return "StrategyVersion("
                    + "label=" + label
                    + ", version=" + version
                    + ")";
        }
    }

    public static class AntispamLabel {

        private Integer label;
        private Integer level;
        private List<AntispamSubLabel> subLabels;

        public Integer getLabel() {
            return label;
        }

        public void setLabel(Integer label) {
            this.label = label;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public List<AntispamSubLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<AntispamSubLabel> subLabels) {
            this.subLabels = subLabels;
        }

        @Override
        public String toString() {
            return "AntispamLabel("
                    + "label=" + label
                    + ", level=" + level
                    + ", subLabels=" + subLabels
                    + ")";
        }
    }

    public static class AntispamSubLabel {

        private String subLabel;
        private AntispamSubLabelDetail details;

        public String getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(String subLabel) {
            this.subLabel = subLabel;
        }

        public AntispamSubLabelDetail getDetails() {
            return details;
        }

        public void setDetails(AntispamSubLabelDetail details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "AntispamSubLabel("
                    + "subLabel=" + subLabel
                    + ", details=" + details
                    + ")";
        }
    }

    public static class AntispamSubLabelDetail {

        private List<AntispamSubLabelDetailKeyword> keywords;
        private List<AntispamSubLabelDetailLibInfo> libInfos;
        private AntispamSubLabelDetailAnticheat anticheat;
        private List<AntispamSubLabelDetailHitInfo> hitInfos;

        public List<AntispamSubLabelDetailKeyword> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<AntispamSubLabelDetailKeyword> keywords) {
            this.keywords = keywords;
        }

        public List<AntispamSubLabelDetailLibInfo> getLibInfos() {
            return libInfos;
        }

        public void setLibInfos(List<AntispamSubLabelDetailLibInfo> libInfos) {
            this.libInfos = libInfos;
        }

        public AntispamSubLabelDetailAnticheat getAnticheat() {
            return anticheat;
        }

        public void setAnticheat(AntispamSubLabelDetailAnticheat anticheat) {
            this.anticheat = anticheat;
        }

        public List<AntispamSubLabelDetailHitInfo> getHitInfos() {
            return hitInfos;
        }

        public void setHitInfos(List<AntispamSubLabelDetailHitInfo> hitInfos) {
            this.hitInfos = hitInfos;
        }

        @Override
        public String toString() {
            return "AntispamSubLabelDetail("
                    + "keywords=" + keywords
                    + ", libInfos=" + libInfos
                    + ", anticheat=" + anticheat
                    + ", hitInfos=" + hitInfos
                    + ")";
        }
    }

    public static class AntispamSubLabelDetailKeyword {

        private String word;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        @Override
        public String toString() {
            return "AntispamSubLabelDetailKeyword("
                    + "word=" + word
                    + ")";
        }
    }

    public static class AntispamSubLabelDetailLibInfo {

        private Integer type;
        private String entity;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }

        @Override
        public String toString() {
            return "AntispamSubLabelDetailLibInfo("
                    + "type=" + type
                    + ", entity=" + entity
                    + ")";
        }
    }

    public static class AntispamSubLabelDetailAnticheat {

        private Integer hitType;

        public Integer getHitType() {
            return hitType;
        }

        public void setHitType(Integer hitType) {
            this.hitType = hitType;
        }

        @Override
        public String toString() {
            return "AntispamSubLabelDetailAnticheat("
                    + "hitType=" + hitType
                    + ")";
        }
    }

    public static class AntispamSubLabelDetailHitInfo {

        private String value;
        private List<AntispamSubLabelDetailHitInfoPosition> positions;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<AntispamSubLabelDetailHitInfoPosition> getPositions() {
            return positions;
        }

        public void setPositions(List<AntispamSubLabelDetailHitInfoPosition> positions) {
            this.positions = positions;
        }

        @Override
        public String toString() {
            return "AntispamSubLabelDetailHitInfo("
                    + "value=" + value
                    + ", positions=" + positions
                    + ")";
        }
    }

    public static class AntispamSubLabelDetailHitInfoPosition {

        private String fieldName;
        private Integer startPos;
        private Integer endPos;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public Integer getStartPos() {
            return startPos;
        }

        public void setStartPos(Integer startPos) {
            this.startPos = startPos;
        }

        public Integer getEndPos() {
            return endPos;
        }

        public void setEndPos(Integer endPos) {
            this.endPos = endPos;
        }

        @Override
        public String toString() {
            return "AntispamSubLabelDetailHitInfoPosition("
                    + "fieldName=" + fieldName
                    + ", startPos=" + startPos
                    + ", endPos=" + endPos
                    + ")";
        }
    }

    public static class EmotionAnalysis {

        private String taskId;
        private String dataId;
        private List<EmotionAnalysisDetail> details;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public List<EmotionAnalysisDetail> getDetails() {
            return details;
        }

        public void setDetails(List<EmotionAnalysisDetail> details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "EmotionAnalysis("
                    + "taskId=" + taskId
                    + ", dataId=" + dataId
                    + ", details=" + details
                    + ")";
        }
    }

    public static class EmotionAnalysisDetail {

        private Double positiveProb;
        private Double negativeProb;
        private String sentiment;

        public Double getPositiveProb() {
            return positiveProb;
        }

        public void setPositiveProb(Double positiveProb) {
            this.positiveProb = positiveProb;
        }

        public Double getNegativeProb() {
            return negativeProb;
        }

        public void setNegativeProb(Double negativeProb) {
            this.negativeProb = negativeProb;
        }

        public String getSentiment() {
            return sentiment;
        }

        public void setSentiment(String sentiment) {
            this.sentiment = sentiment;
        }

        @Override
        public String toString() {
            return "EmotionAnalysisDetail("
                    + "positiveProb=" + positiveProb
                    + ", negativeProb=" + negativeProb
                    + ", sentiment=" + sentiment
                    + ")";
        }
    }

    public static class Anticheat {

        private String taskId;
        private String dataId;
        private List<AnticheatDetail> details;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public List<AnticheatDetail> getDetails() {
            return details;
        }

        public void setDetails(List<AnticheatDetail> details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "Anticheat("
                    + "taskId=" + taskId
                    + ", dataId=" + dataId
                    + ", details=" + details
                    + ")";
        }
    }

    public static class AnticheatDetail {

        private Integer suggestion;
        private List<AnticheatDetailHitInfo> hitInfos;

        public Integer getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Integer suggestion) {
            this.suggestion = suggestion;
        }

        public List<AnticheatDetailHitInfo> getHitInfos() {
            return hitInfos;
        }

        public void setHitInfos(List<AnticheatDetailHitInfo> hitInfos) {
            this.hitInfos = hitInfos;
        }

        @Override
        public String toString() {
            return "AnticheatDetail("
                    + "suggestion=" + suggestion
                    + ", hitInfos=" + hitInfos
                    + ")";
        }
    }

    public static class AnticheatDetailHitInfo {

        private Integer hitType;
        private String hitMsg;

        public Integer getHitType() {
            return hitType;
        }

        public void setHitType(Integer hitType) {
            this.hitType = hitType;
        }

        public String getHitMsg() {
            return hitMsg;
        }

        public void setHitMsg(String hitMsg) {
            this.hitMsg = hitMsg;
        }

        @Override
        public String toString() {
            return "AnticheatDetailHitInfo("
                    + "hitType=" + hitType
                    + ", hitMsg=" + hitMsg
                    + ")";
        }
    }

    public static class UserRisk {

        private String taskId;
        private String dataId;
        private List<UserRiskDetail> details;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public List<UserRiskDetail> getDetails() {
            return details;
        }

        public void setDetails(List<UserRiskDetail> details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "UserRisk("
                    + "taskId=" + taskId
                    + ", dataId=" + dataId
                    + ", details=" + details
                    + ")";
        }
    }

    public static class UserRiskDetail {

        private String account;
        private Integer accountLevel;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public Integer getAccountLevel() {
            return accountLevel;
        }

        public void setAccountLevel(Integer accountLevel) {
            this.accountLevel = accountLevel;
        }

        @Override
        public String toString() {
            return "UserRiskDetail("
                    + "account=" + account
                    + ", accountLevel=" + accountLevel
                    + ")";
        }
    }

    private static class Language {

        private String taskId;
        private String dataId;
        private List<LanguageDetail> details;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public List<LanguageDetail> getDetails() {
            return details;
        }

        public void setDetails(List<LanguageDetail> details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "Language("
                    + "taskId=" + taskId
                    + ", dataId=" + dataId
                    + ", details=" + details
                    + ")";
        }
    }

    public static class LanguageDetail {

        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "LanguageDetail("
                    + "type=" + type
                    + ")";
        }
    }
}
