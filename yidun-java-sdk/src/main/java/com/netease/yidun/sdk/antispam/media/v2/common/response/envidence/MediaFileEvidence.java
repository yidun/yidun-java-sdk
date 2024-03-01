package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;

import java.util.List;

/**
 * 融媒体机审-文档证据信息
 */
public class MediaFileEvidence {

    private String dataId;
    private String field;

    /**
     * 结果类型
     */
    private Integer resultType;
    private Integer status;

    /**
     * 压缩包中的内容
     */
    private List<Detail> details;

    private Integer suggestion;
    /**
     * 失败原因
     */
    private Integer failureReason;

    private FileEvidenceResult evidences;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public Integer getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Integer suggestion) {
        this.suggestion = suggestion;
    }

    public Integer getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(Integer failureReason) {
        this.failureReason = failureReason;
    }

    public FileEvidenceResult getEvidences() {
        return evidences;
    }

    public void setEvidences(FileEvidenceResult evidences) {
        this.evidences = evidences;
    }

    public static class Detail {
        private String taskId;
        private String name;
        private Integer fileType;
        private Integer suggestion;
        private FileEvidenceResult evidences;
        private String message;

        private Integer status;

        private Integer failureReason;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getFileType() {
            return fileType;
        }

        public void setFileType(Integer fileType) {
            this.fileType = fileType;
        }

        public Integer getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Integer suggestion) {
            this.suggestion = suggestion;
        }

        public FileEvidenceResult getEvidences() {
            return evidences;
        }

        public void setEvidences(FileEvidenceResult evidences) {
            this.evidences = evidences;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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
    }

    public static class FileEvidenceResult {
        private List<TextEvidence> texts;
        private List<ImageEvidence> images;

        public List<TextEvidence> getTexts() {
            return texts;
        }

        public void setTexts(List<TextEvidence> texts) {
            this.texts = texts;
        }

        public List<ImageEvidence> getImages() {
            return images;
        }

        public void setImages(List<ImageEvidence> images) {
            this.images = images;
        }
    }

    public static class TextEvidence {
        private Integer sequence;
        private String startText;
        private String endText;
        private Integer suggestion;
        private List<TextEvidenceLabel> labels;
        private Integer page;

        public Integer getSequence() {
            return sequence;
        }

        public void setSequence(Integer sequence) {
            this.sequence = sequence;
        }

        public String getStartText() {
            return startText;
        }

        public void setStartText(String startText) {
            this.startText = startText;
        }

        public String getEndText() {
            return endText;
        }

        public void setEndText(String endText) {
            this.endText = endText;
        }

        public Integer getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Integer suggestion) {
            this.suggestion = suggestion;
        }

        public List<TextEvidenceLabel> getLabels() {
            return labels;
        }

        public void setLabels(List<TextEvidenceLabel> labels) {
            this.labels = labels;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }
    }

    public static class TextEvidenceLabel {
        private Integer label;
        private Integer level;
        private List<FileCallbackV2Response.TextEvidenceLabel> subLabels;

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

        public List<FileCallbackV2Response.TextEvidenceLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<FileCallbackV2Response.TextEvidenceLabel> subLabels) {
            this.subLabels = subLabels;
        }
    }

    /**
     * 直接用文档回调结果里的TextEvidenceLabel结构
     */
    @Deprecated
    public static class TextEvidenceSubLabel {
        private String subLabel;
        /**
         * 二级分类深度
         */
        private Integer subLabelDepth;
        /**
         * 二级分类标签
         */
        private String secondLabel;
        /**
         * 三级分类标签
         */
        private String thirdLabel;
        private TextSubLabelDetail details;

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
    }

    public static class ImageEvidence {
        private Integer sequence;
        private String imageUrl;
        private Integer suggestion;
        private List<FileCallbackV2Response.ImageEvidenceLabel> labels;
        private Integer page;

        public Integer getSequence() {
            return sequence;
        }

        public void setSequence(Integer sequence) {
            this.sequence = sequence;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Integer getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Integer suggestion) {
            this.suggestion = suggestion;
        }

        public List<FileCallbackV2Response.ImageEvidenceLabel> getLabels() {
            return labels;
        }

        public void setLabels(List<FileCallbackV2Response.ImageEvidenceLabel> labels) {
            this.labels = labels;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }
    }

    /**
     * 直接用文档回调结果里的ImageEvidenceLabel结构
     */
    @Deprecated
    public static class ImageEvidenceLabel {
        private Integer label;
        private Integer level;
        private Double rate;
        private List<ImageEvidenceLabelSubLabel> subLabels;

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

        public List<ImageEvidenceLabelSubLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<ImageEvidenceLabelSubLabel> subLabels) {
            this.subLabels = subLabels;
        }
    }

    public static class ImageEvidenceLabelSubLabel {
        private String subLabel;
        /**
         * 二级分类深度
         */
        private Integer subLabelDepth;
        /**
         * 二级分类标签
         */
        private String secondLabel;
        /**
         * 三级分类标签
         */
        private String thirdLabel;
        private Double rate;
        private ImageSubLabelDetail details;

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
    }

}
