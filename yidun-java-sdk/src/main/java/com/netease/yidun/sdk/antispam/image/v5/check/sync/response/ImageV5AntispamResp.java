package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import com.netease.yidun.sdk.antispam.image.v5.enums.CensorTypeEnum;

import java.io.Serializable;
import java.util.List;

public class ImageV5AntispamResp implements Serializable {
    private static final long serialVersionUID = 7854363534480715087L;
    /**
     * 即易盾生成的uuid，唯一标识一张图片
     */
    private String taskId;
    /**
     * 检测状态 0 未开始、1检测中、2检测成功、3检测失败，{@link com.netease.yidun.sdk.antispam.image.v5.enums.ImageCheckStatusEnum}
     */
    private Integer status;
    /**
     * 检测失败原因
     */
    private Integer failureReason;
    /**
     * 检测建议结果， {@link com.netease.yidun.sdk.antispam.enums.LevelEnum}
     */
    private Integer suggestion;
    /**
     * 图片人审状态{@link CensorTypeEnum}
     */
    private Integer censorType;
    /**
     * 策略版本字段
     */
    private List<ImageV5VersionDetail> strategyVersions;
    /**
     * 产品方传的图片标识，原样返回
     */
    private String name;
    /**
     * 客户图片唯一标识
     */
    private String dataId;
    /**
     * 各个类别检测结果
     */
    private List<ImageV5LabelDetail> labels;
    /**
     * 机器或人审结果 {@link com.netease.yidun.sdk.antispam.image.v5.enums.CheckResultTypeEnum}
     */
    private Integer resultType;
    /**
     * 审核时间，回调返回
     */
    private Long censorTime;
    /**
     * 审核来源，回调返回
     */
    private Integer censorSource;
    /**
     * 审核轮数，回调返回
     */
    private Integer censorRound;
    /**
     * 审核标签，回调返回
     */
    private List<CensorLabelInfo> censorLabels;
    /**
     * 云信融合业务转换结果
     */
    private Integer customAction;

    /**
     * 分帧数
     */
    private Integer frameSize;

    public Integer getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(Integer frameSize) {
        this.frameSize = frameSize;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
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

    public Integer getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Integer suggestion) {
        this.suggestion = suggestion;
    }

    public Integer getCensorType() {
        return censorType;
    }

    public void setCensorType(Integer censorType) {
        this.censorType = censorType;
    }

    public List<ImageV5VersionDetail> getStrategyVersions() {
        return strategyVersions;
    }

    public void setStrategyVersions(List<ImageV5VersionDetail> strategyVersions) {
        this.strategyVersions = strategyVersions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public List<ImageV5LabelDetail> getLabels() {
        return labels;
    }

    public void setLabels(List<ImageV5LabelDetail> labels) {
        this.labels = labels;
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public Long getCensorTime() {
        return censorTime;
    }

    public void setCensorTime(Long censorTime) {
        this.censorTime = censorTime;
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

    public List<CensorLabelInfo> getCensorLabels() {
        return censorLabels;
    }

    public void setCensorLabels(List<CensorLabelInfo> censorLabels) {
        this.censorLabels = censorLabels;
    }

    public Integer getCustomAction() {
        return customAction;
    }

    public void setCustomAction(Integer customAction) {
        this.customAction = customAction;
    }

    private static class CensorLabelInfo implements Serializable {
        private static final long serialVersionUID = -7913548400479437764L;
        private String code;
        private String desc;
        private String customCode;

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

        public String getCustomCode() {
            return customCode;
        }

        public void setCustomCode(String customCode) {
            this.customCode = customCode;
        }
    }
}
