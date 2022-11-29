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
}
