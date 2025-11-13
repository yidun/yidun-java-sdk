package com.netease.yidun.sdk.antispam.media.v2.common.response;

import com.netease.yidun.sdk.antispam.media.v2.common.response.envidence.MediaAntispamEvidence;
import com.netease.yidun.sdk.antispam.media.v2.common.response.envidence.SolutionEnrichEvidence;

/**
 * 机审结果
 */

public class MediaAntispamResponse {
    private String dataId;
    private String taskId;
    /**
     * 0:无结果（检测失败）1:正常 2:异常 3：疑似
     */
    private Integer suggestion;

    /**
     * 垃圾类别
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

    /**
     * 嫌疑级别，针对部分定制策略支持命中嫌疑时返回，1：低嫌疑，2：高嫌疑
     */
    private Integer suggestionLevel;

    /**
     * 风险描述，拼接 label｜secondlabel｜thirdlabel 的中文实时示意，注意分隔使用「｜」
     */
    private String riskDescription;
    /**
     * 审核类型，1:机器检测，2:审核
     */
    private Integer resultType;

    private String callback;
    /**
     * 检测状态, 1:检测中 2:检测成功 3:检测失败
     */
    private Integer checkStatus;
    /**
     * 底层业务返回结果
     */
    private MediaAntispamEvidence evidences;

    /**
     * 解决方案维度-失败集合
     */
    private SolutionEnrichEvidence solutionEnrichEvidence;


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

    public Integer getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Integer suggestion) {
        this.suggestion = suggestion;
    }

    public Integer getResultType() {
        return resultType;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }



    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public MediaAntispamEvidence getEvidences() {
        return evidences;
    }

    public void setEvidences(MediaAntispamEvidence evidences) {
        this.evidences = evidences;
    }

    public SolutionEnrichEvidence getSolutionEnrichEvidence() {
        return solutionEnrichEvidence;
    }

    public void setSolutionEnrichEvidence(SolutionEnrichEvidence solutionEnrichEvidence) {
        this.solutionEnrichEvidence = solutionEnrichEvidence;
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

    public Integer getSuggestionLevel() {
        return suggestionLevel;
    }

    public void setSuggestionLevel(Integer suggestionLevel) {
        this.suggestionLevel = suggestionLevel;
    }

    public String getRiskDescription() {
        return riskDescription;
    }

    public void setRiskDescription(String riskDescription) {
        this.riskDescription = riskDescription;
    }

    @Override
    public String toString() {
        return "MediaAntispamResponse{" +
                "dataId='" + dataId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", suggestion=" + suggestion +
                ", label=" + label +
                ", secondLabel='" + secondLabel + '\'' +
                ", thirdLabel='" + thirdLabel + '\'' +
                ", suggestionLevel=" + suggestionLevel +
                ", riskDescription='" + riskDescription + '\'' +
                ", resultType=" + resultType +
                ", callback='" + callback + '\'' +
                ", checkStatus=" + checkStatus +
                ", evidences=" + evidences +
                ", solutionEnrichEvidence=" + solutionEnrichEvidence +
                '}';
    }
}
