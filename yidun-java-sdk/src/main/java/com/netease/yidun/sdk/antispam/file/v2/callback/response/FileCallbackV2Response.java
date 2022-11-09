package com.netease.yidun.sdk.antispam.file.v2.callback.response;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.netease.yidun.sdk.antispam.media.v2.common.response.envidence.TextSubLabelDetail;
import com.netease.yidun.sdk.core.response.CommonResponse;

public class FileCallbackV2Response extends CommonResponse {

    private List<FileCallbackV2Resp> result;

    public List<FileCallbackV2Resp> getResult() {
        return result;
    }

    public void setResult(List<FileCallbackV2Resp> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "FileCallbackV2Response{" +
                "result=" + result +
                '}';
    }

    public static class FileCallbackV2Resp {
        /**
         * 内容安全检测结果
         */
        private AntispamCheckResult antispam;

        public AntispamCheckResult getAntispam() {
            return antispam;
        }

        public void setAntispam(AntispamCheckResult antispam) {
            this.antispam = antispam;
        }

        @Override
        public String toString() {
            return "FileCallbackV2Resp{" +
                    "antispam=" + antispam +
                    '}';
        }
    }

    public static class AntispamCheckResult {
        /**
         * 数据唯一标识
         */
        private String dataId;
        /**
         * 检测任务ID
         */
        private String taskId;
        /**
         * 产品调用文本在线检测传递的 callback 字段数据。
         */
        private String callback;
        /**
         * 文档解决方案维度分类信息
         * 垃圾类型：0-正常，100-色情，200-广告，300-暴恐，400-违禁，500-涉政, 900-其他，1100-涉价值观
         * 压缩包格式参考Detail里的Label
         */
        private Integer label;
        /**
         * 建议动作，0：通过，1：嫌疑，2：不通过
         */
        private Integer suggestion;
        /**
         * 描述
         */
        private String message;

        /**
         * 结果类型，1：机器结果，2：人审结果
         */
        private Integer resultType;

        /**
         * 机审证据
         */
        private EvidenceResult evidences;
        /**
         * 人审证据
         */
        private ReviewEvidenceResult reviewEvidences;
        /**
         * 失败原因
         */
        private Integer failureReason;
        /**
         * 压缩包内的文档内容
         */
        private List<Detail> details;

        /**
         * 审核标签
         */
        private Set<CensorLabel> censorLabels = new HashSet<>();

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

        public String getCallback() {
            return callback;
        }

        public void setCallback(String callback) {
            this.callback = callback;
        }

        public Integer getLabel() {
            return label;
        }

        public void setLabel(Integer label) {
            this.label = label;
        }

        public Integer getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Integer suggestion) {
            this.suggestion = suggestion;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Integer getResultType() {
            return resultType;
        }

        public void setResultType(Integer resultType) {
            this.resultType = resultType;
        }

        public EvidenceResult getEvidences() {
            return evidences;
        }

        public void setEvidences(EvidenceResult evidences) {
            this.evidences = evidences;
        }

        public ReviewEvidenceResult getReviewEvidences() {
            return reviewEvidences;
        }

        public void setReviewEvidences(ReviewEvidenceResult reviewEvidences) {
            this.reviewEvidences = reviewEvidences;
        }

        public Integer getFailureReason() {
            return failureReason;
        }

        public void setFailureReason(Integer failureReason) {
            this.failureReason = failureReason;
        }

        public List<Detail> getDetails() {
            return details;
        }

        public void setDetails(List<Detail> details) {
            this.details = details;
        }

        public Set<CensorLabel> getCensorLabels() {
            return censorLabels;
        }

        public void setCensorLabels(Set<CensorLabel> censorLabels) {
            this.censorLabels = censorLabels;
        }

        @Override
        public String toString() {
            return "AntispamCheckResult{" +
                    "dataId='" + dataId + '\'' +
                    ", taskId='" + taskId + '\'' +
                    ", callback='" + callback + '\'' +
                    ", label='" + label + '\'' +
                    ", suggestion=" + suggestion +
                    ", message='" + message + '\'' +
                    ", resultType=" + resultType +
                    ", evidences=" + evidences +
                    ", reviewEvidences=" + reviewEvidences +
                    ", failureReason=" + failureReason +
                    ", details=" + details +
                    ", censorLabels=" + censorLabels +
                    '}';
        }
    }

    public static class Detail {
        private String taskId;
        private String name;
        private Integer fileType;
        private Integer suggestion;
        private EvidenceResult evidences;
        private ReviewEvidenceResult reviewEvidences;
        private Integer failureReason;
        private String message;
        /**
         * 文档解决方案维度分类信息
         * 垃圾类型：0-正常，100-色情，200-广告，300-暴恐，400-违禁，500-涉政, 900-其他，1100-涉价值观
         */
        private Integer label;

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

        public EvidenceResult getEvidences() {
            return evidences;
        }

        public void setEvidences(EvidenceResult evidences) {
            this.evidences = evidences;
        }

        public ReviewEvidenceResult getReviewEvidences() {
            return reviewEvidences;
        }

        public void setReviewEvidences(ReviewEvidenceResult reviewEvidences) {
            this.reviewEvidences = reviewEvidences;
        }

        public Integer getFailureReason() {
            return failureReason;
        }

        public void setFailureReason(Integer failureReason) {
            this.failureReason = failureReason;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Integer getLabel() {
            return label;
        }

        public void setLabel(Integer label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Detail{" +
                    "taskId='" + taskId + '\'' +
                    ", name='" + name + '\'' +
                    ", fileType=" + fileType +
                    ", suggestion=" + suggestion +
                    ", evidences=" + evidences +
                    ", reviewEvidences=" + reviewEvidences +
                    ", failureReason=" + failureReason +
                    ", message='" + message + '\'' +
                    ", label='" + label + '\'' +
                    '}';
        }
    }

    public static class CensorLabel {
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

        @Override
        public String toString() {
            return "CensorLabel{" +
                    "code='" + code + '\'' +
                    ", desc='" + desc + '\'' +
                    ", customCode='" + customCode + '\'' +
                    '}';
        }
    }

    public static class ReviewEvidenceResult {
        private String reason;
        private String remark;
        private ReviewEvidences detail;

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public ReviewEvidences getDetail() {
            return detail;
        }

        public void setDetail(ReviewEvidences detail) {
            this.detail = detail;
        }

        @Override
        public String toString() {
            return "ReviewEvidenceResult{" +
                    "reason='" + reason + '\'' +
                    ", remark='" + remark + '\'' +
                    ", detail=" + detail +
                    '}';
        }
    }

    public static class ReviewEvidences {
        private List<TextDetail> text;
        private List<ImageDetail> image;

        public List<TextDetail> getText() {
            return text;
        }

        public void setText(List<TextDetail> text) {
            this.text = text;
        }

        public List<ImageDetail> getImage() {
            return image;
        }

        public void setImage(List<ImageDetail> image) {
            this.image = image;
        }

        @Override
        public String toString() {
            return "ReviewEvidences{" +
                    "text=" + text +
                    ", image=" + image +
                    '}';
        }
    }

    public static class TextDetail {
        private String text;
        private String reason;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        @Override
        public String toString() {
            return "TextDetail{" +
                    "text='" + text + '\'' +
                    ", reason='" + reason + '\'' +
                    '}';
        }
    }

    public static class ImageDetail {
        private String url;
        private String reason;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        @Override
        public String toString() {
            return "ImageDetail{" +
                    "url='" + url + '\'' +
                    ", reason='" + reason + '\'' +
                    '}';
        }
    }

    public static class EvidenceResult {
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

        @Override
        public String toString() {
            return "EvidenceResult{" +
                    "texts=" + texts +
                    ", images=" + images +
                    '}';
        }
    }

    public static class TextEvidence {
        private String taskId;
        private Integer sequence;
        private String startText;
        private String endText;
        private Integer suggestion;
        private List<TextEvidenceLabel> labels;
        private Integer page;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

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

        @Override
        public String toString() {
            return "TextEvidence{" +
                    "taskId='" + taskId + '\'' +
                    ", sequence=" + sequence +
                    ", startText='" + startText + '\'' +
                    ", endText='" + endText + '\'' +
                    ", suggestion=" + suggestion +
                    ", labels=" + labels +
                    ", page=" + page +
                    '}';
        }
    }

    public static class TextEvidenceLabel {
        private Integer label;
        private Integer level;
        private List<TextSubLabel> subLabels;

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

        public List<TextSubLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<TextSubLabel> subLabels) {
            this.subLabels = subLabels;
        }

        @Override
        public String toString() {
            return "TextEvidenceLabel{" +
                    "label=" + label +
                    ", level=" + level +
                    ", subLabels=" + subLabels +
                    '}';
        }
    }

    public static class TextSubLabel {
        /**
         * 值定义见SpamType
         */
        private String subLabel;
        /**
         * 文本垃圾详情
         */
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

        @Override
        public String toString() {
            return "TextSubLabel{" +
                    "subLabel='" + subLabel + '\'' +
                    ", details=" + details +
                    '}';
        }
    }

    public static class ImageEvidence {
        private String taskId;
        private Integer sequence;
        private String imageUrl;
        private Integer level;
        private List<ImageEvidenceLabel> labels;
        private Integer page;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

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

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public List<ImageEvidenceLabel> getLabels() {
            return labels;
        }

        public void setLabels(List<ImageEvidenceLabel> labels) {
            this.labels = labels;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        @Override
        public String toString() {
            return "ImageEvidence{" +
                    "taskId='" + taskId + '\'' +
                    ", sequence=" + sequence +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", level=" + level +
                    ", labels=" + labels +
                    ", page=" + page +
                    '}';
        }
    }

    public static class ImageEvidenceLabel {
        private Integer label;
        private Integer level;
        private Double rate;
        private List<ImageSubLabel> subLabels = new ArrayList<ImageSubLabel>();

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

        public List<ImageSubLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<ImageSubLabel> subLabels) {
            this.subLabels = subLabels;
        }

        @Override
        public String toString() {
            return "ImageEvidenceLabel{" +
                    "label=" + label +
                    ", level=" + level +
                    ", rate=" + rate +
                    ", subLabels=" + subLabels +
                    '}';
        }
    }

    public static class ImageSubLabel {
        private int subLabel;
        private Double rate;
        private ImageSubLabelDetail details;

        public int getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(int subLabel) {
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

        @Override
        public String toString() {
            return "ImageSubLabel{" +
                    "subLabel=" + subLabel +
                    ", rate=" + rate +
                    ", details=" + details +
                    '}';
        }
    }

}
