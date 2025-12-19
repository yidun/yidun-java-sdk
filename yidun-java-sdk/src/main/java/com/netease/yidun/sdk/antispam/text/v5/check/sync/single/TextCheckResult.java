package com.netease.yidun.sdk.antispam.text.v5.check.sync.single;

import com.netease.yidun.sdk.irisk.v1.check.HitInfo;

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

    private RiskControl riskControl;
    
    private AigcPrompt aigcPrompt;

    /**
     * 文本大模型检测结果
     */
    private LlmCheckInfo llmCheckInfo;

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

    public RiskControl getRiskControl() {
        return riskControl;
    }
    public void setRiskControl(RiskControl riskControl) {
        this.riskControl = riskControl;
    }
    
    public AigcPrompt getAigcPrompt() {
        return aigcPrompt;
    }
    
    public void setAigcPrompt(AigcPrompt aigcPrompt) {
        this.aigcPrompt = aigcPrompt;
    }

    public LlmCheckInfo getLlmCheckInfo() {
        return llmCheckInfo;
    }

    public void setLlmCheckInfo(LlmCheckInfo llmCheckInfo) {
        this.llmCheckInfo = llmCheckInfo;
    }

    @Override
    public String toString() {
        return "TextCheckResult("
                + "antispam=" + antispam
                + ", emotionAnalysis=" + emotionAnalysis
                + ", anticheat=" + anticheat
                + ", userRisk=" + userRisk
                + ", language=" + language
                + ", riskControl=" + riskControl
                + ", aigcPrompt=" + aigcPrompt
                + ", llmCheckInfo=" + llmCheckInfo
                + ")";
    }

    public static class Antispam {

        private String taskId;
        private String dataId;
        private Integer label;
        private String secondLabel;
        private String thirdLabel;
        /**
         * 风险描述
         */
        private String riskDescription;
        private Integer suggestion;
        private Integer suggestionLevel;
        /**
         * 建议风险等级
         */
        private Integer suggestionRiskLevel;

        /**
         * 专项信息
         */
        private String publicOpinionInfo;
        /**
         * 客户自定义动作
         */
        private Integer customAction;
        private Integer resultType;
        private Integer censorType;
        private String callback;
        private List<CensorLabel> censorLabels;
        private List<StrategyVersion> strategyVersions;
        private Integer censorSource;
        private Integer censorRound;
        private Long censorTime;
        private Boolean isRelatedHit;

        private Integer relatedHitType;
        
        private List<AntispamLabel> labels;
        private String remark;
        private String filteredContent;
        private List<String> mergeHints;
        private Integer status;
        private List<CustomLabel> customLabels;

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
        
        public String getRiskDescription() {
            return riskDescription;
        }
        
        public void setRiskDescription(String riskDescription) {
            this.riskDescription = riskDescription;
        }

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

        public Integer getCustomAction() {
            return customAction;
        }

        public void setCustomAction(Integer customAction) {
            this.customAction = customAction;
        }

        public String getPublicOpinionInfo() {
            return publicOpinionInfo;
        }

        public void setPublicOpinionInfo(String publicOpinionInfo) {
            this.publicOpinionInfo = publicOpinionInfo;
        }

        public Integer getSuggestionRiskLevel() {
            return suggestionRiskLevel;
        }

        public void setSuggestionRiskLevel(Integer suggestionRiskLevel) {
            this.suggestionRiskLevel = suggestionRiskLevel;
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

        public Boolean getIsRelatedHit() {
            return isRelatedHit;
        }

        public void setIsRelatedHit(Boolean relatedHit) {
            isRelatedHit = relatedHit;
        }

        public Integer getRelatedHitType() {
            return relatedHitType;
        }

        public void setRelatedHitType(Integer relatedHitType) {
            this.relatedHitType = relatedHitType;
        }

        public List<AntispamLabel> getLabels() {
            return labels;
        }

        public void setLabels(List<AntispamLabel> labels) {
            this.labels = labels;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getFilteredContent() {
            return filteredContent;
        }

        public void setFilteredContent(String filteredContent) {
            this.filteredContent = filteredContent;
        }

        public List<String> getMergeHints() {
            return mergeHints;
        }

        public void setMergeHints(List<String> mergeHints) {
            this.mergeHints = mergeHints;
        }

        public List<CustomLabel> getCustomLabels() {
            return customLabels;
        }

        public void setCustomLabels(List<CustomLabel> customLabels) {
            this.customLabels = customLabels;
        }

        @Override
        public String toString() {
            return "Antispam{" +
                    "taskId='" + taskId + '\'' +
                    ", dataId='" + dataId + '\'' +
                    ", label=" + label +
                    ", secondLabel='" + secondLabel + '\'' +
                    ", thirdLabel='" + thirdLabel + '\'' +
                    ", riskDescription='" + riskDescription + '\'' +
                    ", suggestion=" + suggestion +
                    ", suggestionLevel=" + suggestionLevel +
                    ", suggestionRiskLevel=" + suggestionRiskLevel +
                    ", publicOpinionInfo='" + publicOpinionInfo + '\'' +
                    ", customAction=" + customAction +
                    ", resultType=" + resultType +
                    ", censorType=" + censorType +
                    ", callback='" + callback + '\'' +
                    ", censorLabels=" + censorLabels +
                    ", strategyVersions=" + strategyVersions +
                    ", censorSource=" + censorSource +
                    ", censorRound=" + censorRound +
                    ", censorTime=" + censorTime +
                    ", isRelatedHit=" + isRelatedHit +
                    ", relatedHitType=" + relatedHitType +
                    ", labels=" + labels +
                    ", remark='" + remark + '\'' +
                    ", filteredContent='" + filteredContent + '\'' +
                    ", mergeHints=" + mergeHints +
                    ", status=" + status +
                    ", customLabels=" + customLabels +
                    '}';
        }
    }

    public static class CensorLabel {

        private String code;
        private String desc;
        private String name;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "CensorLabel("
                    + "code=" + code
                    + ", desc=" + desc
                    + ", name=" + name
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

    /**
     * 客户自定义标签
     */
    public static class CustomLabel {
        /**
         * 名称,一级标签/二级标签/三级标签
         */
        private String name;
        /**
         * 编码 客户自定义标签编码
         */
        private String code;
        /**
         * 深度 1-一级标签 2-二级标签 3-三级标签
         */
        private Integer depth;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Integer getDepth() {
            return depth;
        }

        public void setDepth(Integer depth) {
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "CustomLabel{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    ", depth=" + depth +
                    '}';
        }
    }

    public static class AntispamLabel {

        private Integer label;
        private Integer level;
        private Double rate;
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

        public Double getRate() {
            return rate;
        }

        public void setRate(Double rate) {
            this.rate = rate;
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
                    + ", rate=" + rate
                    + ", subLabels=" + subLabels
                    + ")";
        }
    }

    public static class AntispamSubLabel {

        private String subLabel;

        private Integer subLabelDepth;

        private String secondLabel;

        private String thirdLabel;
        /**
         * 风险描述
         */
        private String riskDescription;

        /**
         * 建议风险等级
         */
        private Integer suggestionRiskLevel;

        /**
         * 涉政标签正负向属性检测结果，如有需要请联系您的专属商务，未开通状态下不返回
         * 枚举值：正向-0、负向-1、中性-2
         */
        private Integer politicalSentiment;

        /**
         * 是否是关联命中返回的标签 默认不返回
         */
        private Boolean isRelatedLabel;

        private AntispamSubLabelDetail details;
        
        private Double rate;

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

        public Boolean getIsRelatedLabel() {
            return isRelatedLabel;
        }

        public void setIsRelatedLabel(Boolean relatedLabel) {
            isRelatedLabel = relatedLabel;
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
        
        public Integer getSuggestionRiskLevel() {
            return suggestionRiskLevel;
        }

        public void setSuggestionRiskLevel(Integer suggestionRiskLevel) {
            this.suggestionRiskLevel = suggestionRiskLevel;
        }

        public Integer getPoliticalSentiment() {
            return politicalSentiment;
        }
        
        public void setPoliticalSentiment(Integer politicalSentiment) {
            this.politicalSentiment = politicalSentiment;
        }

        public Double getRate() {
            return rate;
        }

        public void setRate(Double rate) {
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "AntispamSubLabel("
                    + "subLabel=" + subLabel
                    + ", subLabelDepth=" + subLabelDepth
                    + ", secondLabel=" + secondLabel
                    + ", thirdLabel=" + thirdLabel
                    + ", riskDescription=" + riskDescription
                    + ", suggestionRiskLevel=" + suggestionRiskLevel
                    + ", politicalSentiment=" + politicalSentiment
                    + ", isRelatedLabel=" + isRelatedLabel
                    + ", rate=" + rate
                    + ", details=" + details
                    + ")";
        }
    }

    public static class AntispamSubLabelDetail {

        private List<AntispamSubLabelDetailKeyword> keywords;
        private List<AntispamSubLabelDetailRule> rules;
        private List<AntispamSubLabelDetailLibInfo> libInfos;
        private AntispamSubLabelDetailAnticheat anticheat;
        private List<AntispamSubLabelDetailHitInfo> hitInfos;

        public List<AntispamSubLabelDetailKeyword> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<AntispamSubLabelDetailKeyword> keywords) {
            this.keywords = keywords;
        }

        public List<AntispamSubLabelDetailRule> getRules() {
            return rules;
        }

        public void setRules(List<AntispamSubLabelDetailRule> rules) {
            this.rules = rules;
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
                    + ", rules=" + rules
                    + ", libInfos=" + libInfos
                    + ", anticheat=" + anticheat
                    + ", hitInfos=" + hitInfos
                    + ")";
        }
    }

    public static class AntispamSubLabelDetailRule implements Serializable {
        private static final long serialVersionUID = -9114963157829445482L;
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "AntispamSubLabelDetailRule("
                    + "name=" + name
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
        private Long releaseTime;

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

        public Long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(Long releaseTime) {
            this.releaseTime = releaseTime;
        }

        @Override
        public String toString() {
            return "AntispamSubLabelDetailLibInfo{" +
                    "type=" + type +
                    ", entity='" + entity + '\'' +
                    ", releaseTime='" + releaseTime + '\'' +
                    '}';
        }
    }

    public static class AntispamSubLabelDetailAnticheat {

        private Integer type;

        public Integer getType() {
            return type;
        }
        
        public void setType(Integer type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "AntispamSubLabelDetailAnticheat{" +
                    "type=" + type +
                    '}';
        }
    }

    public static class AntispamSubLabelDetailHitInfo {

        private String value;

        /**
         * type:1，“通用反垃圾线索信息”，type:2，“增强版线索信息”
         */
        private Integer type;
        private List<AntispamSubLabelDetailHitInfoPosition> positions;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
        public Integer getType() {
            return type;
        }
        
        public void setType(Integer type) {
            this.type = type;
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
                    + ", type=" + type
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

        /**
         * 账号风险等级
         */
        private Integer accountLevel;
        private List<UserRiskAcDetail> acDetails;

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

        public List<UserRiskAcDetail> getAcDetails() {
            return acDetails;
        }

        public void setAcDetails(List<UserRiskAcDetail> acDetails) {
            this.acDetails = acDetails;
        }

        @Override
        public String toString() {
            return "UserRiskDetail("
                    + "account=" + account
                    + ", accountLevel=" + accountLevel
                    + ", acDetails=" + acDetails
                    + ")";
        }
    }

    public static class UserRiskAcDetail {

        private String riskType;
        private Integer riskLevel;
        private Double riskScore;

        public String getRiskType() {
            return riskType;
        }

        public void setRiskType(String riskType) {
            this.riskType = riskType;
        }

        public Integer getRiskLevel() {
            return riskLevel;
        }

        public void setRiskLevel(Integer riskLevel) {
            this.riskLevel = riskLevel;
        }

        public Double getRiskScore() {
            return riskScore;
        }

        public void setRiskScore(Double riskScore) {
            this.riskScore = riskScore;
        }

        @Override
        public String toString() {
            return "UserRiskAcDetail("
                    + "riskType=" + riskType
                    + ", riskLevel=" + riskLevel
                    + ", riskScore=" + riskScore
                    + ")";
        }
    }

    public static class Language {

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

    public static class RiskControl {
        /**
         * 检测任务ID
         */
        private String taskId;

        /**
         * 数据id
         */
        private String dataId;

        /**
         * 智能风控命中详情
         */
        private List<RiskControlDetail> details;

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

        public List<RiskControlDetail> getDetails() {
            return details;
        }

        public void setDetails(List<RiskControlDetail> details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "RiskControl{" +
                    "taskId='" + taskId +
                    ", dataId='" + dataId +
                    ", details=" + details +
                    '}';
        }
    }

    public static class RiskControlDetail {
        /**
         * 风险等级
         */
        private Integer riskLevel;

        /**
         * 命中的风险标签信息
         */
        private List<HitInfo> hitInfos;

        public Integer getRiskLevel() {
            return riskLevel;
        }

        public void setRiskLevel(Integer riskLevel) {
            this.riskLevel = riskLevel;
        }

        public List<HitInfo> getHitInfos() {
            return hitInfos;
        }

        public void setHitInfos(List<HitInfo> hitInfos) {
            this.hitInfos = hitInfos;
        }

        @Override
        public String toString() {
            return "RiskControlDetail{" +
                    "riskLevel=" + riskLevel +
                    ", hitInfos=" + hitInfos +
                    '}';
        }
    }

    public static class AigcPrompt {
        
        /**
         * 任务id
         */
        private String taskId;

        /**
         * 数据id
         */
        private String dataId;
        
        /**
         * 详情
         */
        private List<AigcPromptDetail> details;

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

        public List<AigcPromptDetail> getDetails() {
            return details;
        }

        public void setDetails(List<AigcPromptDetail> details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "AigcPrompt{" +
                    "taskId='" + taskId + '\'' +
                    ", dataId='" + dataId + '\'' +
                    ", details=" + details +
                    '}';
        }
    }

    public static class AigcPromptDetail {
        /**
         * prompt分类的枚举值
         */
        private Integer type;

        /**
         * 需要回答且能找到回答时返回
         */
        private String answer;

        /**
         * 标记对外输出内容由知识库结果还是大模型生成的结果（0代表知识库,1代表大模型,2代表自定义大模型）
         */
        private Integer source;

        /**
         * 知识库ID
         */
        private String libId;

        /**
         * 知识库-答案 ID
         */
        private String answerId;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public Integer getSource() {
            return source;
        }

        public void setSource(Integer source) {
            this.source = source;
        }

        public String getLibId() {
            return libId;
        }

        public void setLibId(String libId) {
            this.libId = libId;
        }

        public String getAnswerId() {
            return answerId;
        }

        public void setAnswerId(String answerId) {
            this.answerId = answerId;
        }

        @Override
        public String toString() {
            return "AigcPromptDetail{" +
                    "type=" + type +
                    ", answer='" + answer + '\'' +
                    ", source='" + source + '\'' +
                    ", libId='" + libId + '\'' +
                    ", answerId='" + answerId + '\'' +
                    '}';
        }
    }

    public static class LlmCheckInfo {

        /**
         * 任务id
         */
        private String taskId;

        /**
         * 数据id
         */
        private String dataId;

        /**
         * 详情
         */
        private List<LlmCheckInfoDetail> details;

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

        public List<LlmCheckInfoDetail> getDetails() {
            return details;
        }

        public void setDetails(List<LlmCheckInfoDetail> details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "LlmCheckInfo{" +
                    "taskId='" + taskId + '\'' +
                    ", dataId='" + dataId + '\'' +
                    ", details=" + details +
                    '}';
        }
    }

    public static class LlmCheckInfoDetail {

        /**
         * 模型标识
         */
        private String modelIdentifier;

        /**
         * 大模型识别标签
         */
        private String label;

        /**
         * llm 对于标签的解释
         */
        private String explain;

        public String getModelIdentifier() {
            return modelIdentifier;
        }

        public void setModelIdentifier(String modelIdentifier) {
            this.modelIdentifier = modelIdentifier;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        @Override
        public String toString() {
            return "LlmCheckInfoDetail{" +
                    "modelIdentifier='" + modelIdentifier + '\'' +
                    ", label='" + label + '\'' +
                    ", explain='" + explain + '\'' +
                    '}';
        }
    }
}
