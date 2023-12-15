package com.netease.yidun.sdk.antispam.file.v2.callback.response;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioAntispamCallbackV4Response;
import com.netease.yidun.sdk.antispam.media.v2.common.response.envidence.TextSubLabelDetail;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.ImageV5SubLabelResp;
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
        /**
         * 内容安全增值服务信息
         */
        private ValueAddService valueAddService;

        public AntispamCheckResult getAntispam() {
            return antispam;
        }

        public void setAntispam(AntispamCheckResult antispam) {
            this.antispam = antispam;
        }

        public ValueAddService getValueAddService() {
            return valueAddService;
        }

        public void setValueAddService(ValueAddService valueAddService) {
            this.valueAddService = valueAddService;
        }

        @Override
        public String toString() {
            return "FileCallbackV2Resp{" +
                    "antispam=" + antispam +
                    ", valueAddService=" + valueAddService +
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
        /**
         * 审核完成时间，结果类型是机器结果，代表机器审核完成时间；审核结果是人审结果，代表人审完成时间
         */
        private Long censorTime;

        /**
         * 检测状态
         */
        private Integer status;

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

        public Long getCensorTime() {
            return censorTime;
        }

        public void setCensorTime(Long censorTime) {
            this.censorTime = censorTime;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "AntispamCheckResult{" +
                    "dataId='" + dataId + '\'' +
                    ", taskId='" + taskId + '\'' +
                    ", callback='" + callback + '\'' +
                    ", label=" + label +
                    ", suggestion=" + suggestion +
                    ", message='" + message + '\'' +
                    ", resultType=" + resultType +
                    ", evidences=" + evidences +
                    ", reviewEvidences=" + reviewEvidences +
                    ", failureReason=" + failureReason +
                    ", details=" + details +
                    ", censorLabels=" + censorLabels +
                    ", censorTime=" + censorTime +
                    ", status=" + status +
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
        /**
         * 审核完成时间，结果类型是机器结果，代表机器审核完成时间；审核结果是人审结果，代表人审完成时间
         */
        private Long censorTime;

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

        public Long getCensorTime() {
            return censorTime;
        }

        public void setCensorTime(Long censorTime) {
            this.censorTime = censorTime;
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
                    ", label=" + label +
                    ", censorTime=" + censorTime +
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
        private List<AudioDetail> audios;
        private List<VideoDetail> videos;

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

        public List<AudioDetail> getAudios() {
            return audios;
        }

        public void setAudios(List<AudioDetail> audios) {
            this.audios = audios;
        }

        public List<VideoDetail> getVideos() {
            return videos;
        }

        public void setVideos(List<VideoDetail> videos) {
            this.videos = videos;
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

    /**
     * 音频人审证据信息
     */
    public static class AudioDetail{
        private String url;
        private String originUrl;
        private Long startTime;
        private Long endTime;
        private String reason;
        private String hitId;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getOriginUrl() {
            return originUrl;
        }

        public void setOriginUrl(String originUrl) {
            this.originUrl = originUrl;
        }

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

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getHitId() {
            return hitId;
        }

        public void setHitId(String hitId) {
            this.hitId = hitId;
        }

        @Override
        public String toString() {
            return "AudioDetail{" +
                    "url='" + url + '\'' +
                    ", originUrl='" + originUrl + '\'' +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", reason='" + reason + '\'' +
                    ", hitId='" + hitId + '\'' +
                    '}';
        }
    }

    /**
     * 视频人审证据信息
     */
    public static class VideoDetail{
        private String url;
        private String hitId;
        private List<AvDetail> audios;
        private List<AvDetail> videos;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHitId() {
            return hitId;
        }

        public void setHitId(String hitId) {
            this.hitId = hitId;
        }

        public List<AvDetail> getAudios() {
            return audios;
        }

        public void setAudios(List<AvDetail> audios) {
            this.audios = audios;
        }

        public List<AvDetail> getVideos() {
            return videos;
        }

        public void setVideos(List<AvDetail> videos) {
            this.videos = videos;
        }

        @Override
        public String toString() {
            return "VideoDetail{" +
                    "url='" + url + '\'' +
                    ", hitId='" + hitId + '\'' +
                    ", audios=" + audios +
                    ", videos=" + videos +
                    '}';
        }
    }

    /**
     * 音视频人审详情
     */
    public static class AvDetail{
        private String url;
        private Long startTime;
        private Long endTime;
        private String reason;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

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

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        @Override
        public String toString() {
            return "AvDetail{" +
                    "url='" + url + '\'' +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", reason='" + reason + '\'' +
                    '}';
        }
    }

    public static class EvidenceResult {
        private List<TextEvidence> texts;
        private List<ImageEvidence> images;

        private List<AudioEvidence> audios;

        private List<VideoEvidence> videos;

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

        public List<AudioEvidence> getAudios() {
            return audios;
        }

        public void setAudios(List<AudioEvidence> audios) {
            this.audios = audios;
        }

        public List<VideoEvidence> getVideos() {
            return videos;
        }

        public void setVideos(List<VideoEvidence> videos) {
            this.videos = videos;
        }

        @Override
        public String toString() {
            return "EvidenceResult{" +
                    "texts=" + texts +
                    ", images=" + images +
                    ", audios=" + audios +
                    ", videos=" + videos +
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
        private Integer suggestion;
        private List<ImageEvidenceLabel> labels;
        private Integer page;
        private Integer status;

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

        @Override
        public String toString() {
            return "ImageEvidence{" +
                    "taskId='" + taskId + '\'' +
                    ", sequence=" + sequence +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", suggestion=" + suggestion +
                    ", labels=" + labels +
                    ", page=" + page +
                    ", status=" + status +
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

    /**
     * 音频证据信息
     */
    public static class AudioEvidence {
        private String taskId;
        private Integer sequence;
        private String audioUrl;
        private Integer suggestion;
        private Integer status;
        private VideoSolutionCheckResult videoSolutionCheckResult;

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

        public String getAudioUrl() {
            return audioUrl;
        }

        public void setAudioUrl(String audioUrl) {
            this.audioUrl = audioUrl;
        }

        public Integer getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Integer suggestion) {
            this.suggestion = suggestion;
        }

        public VideoSolutionCheckResult getVideoSolutionCheckResult() {
            return videoSolutionCheckResult;
        }

        public void setVideoSolutionCheckResult(VideoSolutionCheckResult videoSolutionCheckResult) {
            this.videoSolutionCheckResult = videoSolutionCheckResult;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "AudioEvidence{" +
                    "taskId='" + taskId + '\'' +
                    ", sequence=" + sequence +
                    ", audioUrl='" + audioUrl + '\'' +
                    ", suggestion=" + suggestion +
                    ", videoSolutionCheckResult=" + videoSolutionCheckResult +
                    '}';
        }
    }


    /**
     *
     */
    public static class VideoEvidence {
        private String taskId;
        private Integer sequence;
        private String videoUrl;
        private Integer suggestion;
        private Integer status;
        private VideoSolutionCheckResult videoSolutionCheckResult;

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

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public Integer getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Integer suggestion) {
            this.suggestion = suggestion;
        }

        public VideoSolutionCheckResult getVideoSolutionCheckResult() {
            return videoSolutionCheckResult;
        }

        public void setVideoSolutionCheckResult(VideoSolutionCheckResult videoSolutionCheckResult) {
            this.videoSolutionCheckResult = videoSolutionCheckResult;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "VideoEvidence{" +
                    "taskId='" + taskId + '\'' +
                    ", sequence=" + sequence +
                    ", videoUrl='" + videoUrl + '\'' +
                    ", suggestion=" + suggestion +
                    ", videoSolutionCheckResult=" + videoSolutionCheckResult +
                    '}';
        }
    }

    /**
     * 音视频证据信息
     */
    public static class VideoSolutionCheckResult {
        private List<AudioEvidenceSegment> segments;
        private List<VideoEvidencePictures> pictures;

        public List<AudioEvidenceSegment> getSegments() {
            return segments;
        }

        public void setSegments(List<AudioEvidenceSegment> segments) {
            this.segments = segments;
        }

        public List<VideoEvidencePictures> getPictures() {
            return pictures;
        }

        public void setPictures(List<VideoEvidencePictures> pictures) {
            this.pictures = pictures;
        }

        @Override
        public String toString() {
            return "VideoSolutionCheckResult{" +
                    "segments=" + segments +
                    ", pictures=" + pictures +
                    '}';
        }
    }

    /**
     * 音频证据片段信息
     */
    public static class AudioEvidenceSegment {
        private Long startTime;
        private Long endTime;
        private Integer type;
        private String leaderName;
        private String content;
        private List<AudioEvidenceLabel> labels = new ArrayList<>();

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

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getLeaderName() {
            return leaderName;
        }

        public void setLeaderName(String leaderName) {
            this.leaderName = leaderName;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<AudioEvidenceLabel> getLabels() {
            return labels;
        }

        public void setLabels(List<AudioEvidenceLabel> labels) {
            this.labels = labels;
        }

        @Override
        public String toString() {
            return "AudioEvidenceSegment{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", type=" + type +
                    ", leaderName='" + leaderName + '\'' +
                    ", content='" + content + '\'' +
                    ", labels=" + labels +
                    '}';
        }
    }

    /**
     * 音频证据标签信息
     */
    public static class AudioEvidenceLabel {
        private Integer label;
        private Integer level;
        private List<AudioEvidenceSubLabel> subLabels = new ArrayList<>();

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

        public List<AudioEvidenceSubLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<AudioEvidenceSubLabel> subLabels) {
            this.subLabels = subLabels;
        }

        @Override
        public String toString() {
            return "AudioEvidenceLabel{" +
                    "label=" + label +
                    ", level=" + level +
                    ", subLabels=" + subLabels +
                    '}';
        }
    }

    /**
     * 音频证据子标签信息
     */
    public static class AudioEvidenceSubLabel {
        private Integer subLabel;
        private AudioAntispamCallbackV4Response.HintInfo details;

        public Integer getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(Integer subLabel) {
            this.subLabel = subLabel;
        }

        public AudioAntispamCallbackV4Response.HintInfo getDetails() {
            return details;
        }

        public void setDetails(AudioAntispamCallbackV4Response.HintInfo details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "AudioEvidenceSubLabel{" +
                    "subLabel=" + subLabel +
                    ", details=" + details +
                    '}';
        }
    }

    /**
     * 视频证据图片信息
     */
    public static class VideoEvidencePictures {
        private Integer type;
        private String url;
        private Long startTime;
        private Long endTime;
        private List<VideoEvidenceFrontPics> frontPics;
        private List<VideoEvidenceBackPics> backPics;
        private List<VideoEvidenceLabel> labels = new ArrayList<>();

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

        public List<VideoEvidenceFrontPics> getFrontPics() {
            return frontPics;
        }

        public void setFrontPics(List<VideoEvidenceFrontPics> frontPics) {
            this.frontPics = frontPics;
        }

        public List<VideoEvidenceBackPics> getBackPics() {
            return backPics;
        }

        public void setBackPics(List<VideoEvidenceBackPics> backPics) {
            this.backPics = backPics;
        }

        public List<VideoEvidenceLabel> getLabels() {
            return labels;
        }

        public void setLabels(List<VideoEvidenceLabel> labels) {
            this.labels = labels;
        }

        @Override
        public String toString() {
            return "VideoEvidencePictures{" +
                    "type=" + type +
                    ", url='" + url + '\'' +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", frontPics=" + frontPics +
                    ", backPics=" + backPics +
                    ", labels=" + labels +
                    '}';
        }
    }

    /**
     * 视频证据起始图片
     */
    public static class VideoEvidenceFrontPics {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "VideoEvidenceFrontPics{" +
                    "url='" + url + '\'' +
                    '}';
        }
    }

    /**
     * 视频证据结束图片
     */
    public static class VideoEvidenceBackPics {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "VideoEvidenceBackPics{" +
                    "url='" + url + '\'' +
                    '}';
        }
    }


    /**
     * 视频证据标签信息
     */
    public static class VideoEvidenceLabel {
        private Integer label;
        private Integer level;
        private Float rate;
        private List<VideoEvidenceSubLabel> subLabels = new ArrayList<>();

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

        public Float getRate() {
            return rate;
        }

        public void setRate(Float rate) {
            this.rate = rate;
        }

        public List<VideoEvidenceSubLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<VideoEvidenceSubLabel> subLabels) {
            this.subLabels = subLabels;
        }

        @Override
        public String toString() {
            return "VideoEvidenceLabel{" +
                    "label=" + label +
                    ", level=" + level +
                    ", rate=" + rate +
                    ", subLabels=" + subLabels +
                    '}';
        }
    }

    /**
     * 视频证据子标签信息
     */
    public static class VideoEvidenceSubLabel {
        private Integer subLabel;
        private Float rate;
        private ImageV5SubLabelResp.SubLabelDetails details;

        public Integer getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(Integer subLabel) {
            this.subLabel = subLabel;
        }

        public Float getRate() {
            return rate;
        }

        public void setRate(Float rate) {
            this.rate = rate;
        }

        public ImageV5SubLabelResp.SubLabelDetails getDetails() {
            return details;
        }

        public void setDetails(ImageV5SubLabelResp.SubLabelDetails details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "VideoEvidenceSubLabel{" +
                    "subLabel=" + subLabel +
                    ", rate=" + rate +
                    ", details=" + details +
                    '}';
        }
    }
}
