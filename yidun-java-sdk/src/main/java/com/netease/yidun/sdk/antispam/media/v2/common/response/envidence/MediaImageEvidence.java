package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import java.util.List;

/**
 * 融媒体机审-图片证据信息
 */
public class MediaImageEvidence {
    /** 检测结果，0 未开始、1检测中、2检测成功、3检测失败 */
    private Integer status;
    private Integer suggestion;
    private Integer resultType;
    private Integer frameSize;
    private Integer censorType;
    /**
     * 失败原因
     */
    private Integer failureReason;
    private String dataId;
    private String field;
    private String name;
    private List<ImageLabelInfo> labels;

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

        @Override
        public String toString() {
            return "ImageSubLabel{" +
                    "subLabel='" + subLabel + '\'' +
                    ", rate=" + rate +
                    ", details=" + details +
                    ", subLabelDepth=" + subLabelDepth +
                    ", secondLabel='" + secondLabel + '\'' +
                    ", thirdLabel='" + thirdLabel + '\'' +
                    '}';
        }
    }
}
