package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 融媒体机审-文档证据信息
 */
public class MediaFileEvidence implements Serializable {
    private static final long serialVersionUID = -1582338926731782509L;

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
     * 专项信息
     */
    private String publicOpinionInfo;

    /**
     * 建议风险等级
     */
    private Integer suggestionRiskLevel;

    private String riskDescription;
    /**
     * 失败原因
     */
    private Integer failureReason;

    private FileEvidenceResult evidences;

    private String fileUrl;

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
     *
     * 命中策略来源
     */
    private Integer strategySource;

    public Integer getSuggestionRiskLevel() {
        return suggestionRiskLevel;
    }

    public void setSuggestionRiskLevel(Integer suggestionRiskLevel) {
        this.suggestionRiskLevel = suggestionRiskLevel;
    }

    public String getPublicOpinionInfo() {
        return publicOpinionInfo;
    }

    public void setPublicOpinionInfo(String publicOpinionInfo) {
        this.publicOpinionInfo = publicOpinionInfo;
    }

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

    public String getRiskDescription() {
        return riskDescription;
    }

    public void setRiskDescription(String riskDescription) {
        this.riskDescription = riskDescription;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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

    public Integer getStrategySource() {
        return strategySource;
    }

    public void setStrategySource(Integer strategySource) {
        this.strategySource = strategySource;
    }

    public static class Detail implements Serializable {
        private static final long serialVersionUID = -1482338926731782509L;
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

    public static class FileEvidenceResult implements Serializable {
        private static final long serialVersionUID = -1382338926731782509L;
        private List<TextEvidence> texts;
        private List<ImageEvidence> images;
        /**
         * 音频证据
         */
        private List<AudioEvidence> audios;
        /**
         * 视频证据
         */
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
    }

    public static class TextEvidence implements Serializable {
        private static final long serialVersionUID = -1282338926731782509L;
        private Integer sequence;
        private String startText;
        private String endText;
        private Integer suggestion;
        // 建议风险等级
        private Integer suggestionRiskLevel;
        // 专项信息
        private String publicOpinionInfo;
        private List<TextEvidenceLabel> labels;
        private Integer page;
        private String riskDescription;

        public Integer getSuggestionRiskLevel() {
            return suggestionRiskLevel;
        }

        public void setSuggestionRiskLevel(Integer suggestionRiskLevel) {
            this.suggestionRiskLevel = suggestionRiskLevel;
        }

        public String getPublicOpinionInfo() {
            return publicOpinionInfo;
        }

        public void setPublicOpinionInfo(String publicOpinionInfo) {
            this.publicOpinionInfo = publicOpinionInfo;
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

        public String getRiskDescription() {
            return riskDescription;
        }

        public void setRiskDescription(String riskDescription) {
            this.riskDescription = riskDescription;
        }
    }

    public static class TextEvidenceLabel implements Serializable {
        private static final long serialVersionUID = -1182338926731782509L;
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
    public static class TextEvidenceSubLabel implements Serializable {
        private static final long serialVersionUID = -1882338926701782509L;
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

    public static class ImageEvidence implements Serializable {
        private static final long serialVersionUID = -1882338926731722509L;
        private Integer sequence;
        private String imageUrl;
        private Integer suggestion;
        // 专项信息
        private String publicOpinionInfo;
        // 建议风险等级
        private Integer suggestionRiskLevel;
        private List<FileCallbackV2Response.ImageEvidenceLabel> labels;
        private Integer page;
        private String riskDescription;

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

        public String getRiskDescription() {
            return riskDescription;
        }

        public void setRiskDescription(String riskDescription) {
            this.riskDescription = riskDescription;
        }
    }

    /**
     * 直接用文档回调结果里的ImageEvidenceLabel结构
     */
    @Deprecated
    public static class ImageEvidenceLabel implements Serializable {
        private static final long serialVersionUID = -1882338926131782509L;
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

    public static class ImageEvidenceLabelSubLabel implements Serializable {
        private static final long serialVersionUID = -1882338916731782509L;
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

    public static class AudioEvidence implements Serializable {
        private static final long serialVersionUID = -1882338926731792509L;
        /**
         * 元数据 taskId 解析的时候生成的
         */
        private String taskId;
        /**
         * 序号
         */
        private Integer sequence;
        /**
         * 音频地址
         */
        private String audioUrl;
        /**
         * 0 通过 2删除 1嫌疑
         */
        private Integer suggestion;
        /**
         * 检测状态
         */
        private Integer status;
        /**
         * 标签
         */
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

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public VideoSolutionCheckResult getVideoSolutionCheckResult() {
            return videoSolutionCheckResult;
        }

        public void setVideoSolutionCheckResult(VideoSolutionCheckResult videoSolutionCheckResult) {
            this.videoSolutionCheckResult = videoSolutionCheckResult;
        }
    }

    public static class AudioEvidenceSegment implements Serializable {
        private static final long serialVersionUID = -1882338928731782509L;
        /**
         * 音频片段开始时间
         */
        private Long startTime;
        /**
         * 音频片段结束时间
         */
        private Long endTime;
        /**
         * 类型
         */
        private Integer type;
        /**
         * 领导人
         */
        private String leaderName;
        /**
         * 内容
         */
        private String content;
        /**
         * 标签信息
         */
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
    }

    public static class AudioEvidenceLabel implements Serializable {
        private static final long serialVersionUID = -1882338921731782509L;
        /**
         * 标签
         */
        private Integer label;
        /**
         * 级别
         */
        private Integer level;
        /**
         * 分数
         */
        private Double rate;
        /**
         * 子标签
         */
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

        public Double getRate() {
            return rate;
        }

        public void setRate(Double rate) {
            this.rate = rate;
        }

        public List<AudioEvidenceSubLabel> getSubLabels() {
            return subLabels;
        }

        public void setSubLabels(List<AudioEvidenceSubLabel> subLabels) {
            this.subLabels = subLabels;
        }
    }

    public static class AudioEvidenceSubLabel implements Serializable {
        private static final long serialVersionUID = -1882338926731722509L;
        /**
         * 子标签
         */
        private Long subLabel;
        /**
         * 分数
         */
        private Double rate;
        /**
         * 子标签深度
         */
        private Integer subLabelDepth;
        /**
         * 二级标签
         */
        private String secondLabel;
        /**
         * 三级标签
         */
        private String thirdLabel;
        /**
         * 风险描述
         */
        private String riskDescription;

        /**
         * 详情
         */
        private HintInfo details;

        public Long getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(Long subLabel) {
            this.subLabel = subLabel;
        }

        public Double getRate() {
            return rate;
        }

        public void setRate(Double rate) {
            this.rate = rate;
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

        public HintInfo getDetails() {
            return details;
        }

        public void setDetails(HintInfo details) {
            this.details = details;
        }
    }

    public static class VideoEvidence implements Serializable {
        private static final long serialVersionUID = -1812338926731782509L;
        /**
         * 元数据 taskId 解析的时候生成的
         */
        private String taskId;
        /**
         * 序号
         */
        private Integer sequence;
        /**
         * 视频地址
         */
        private String videoUrl;
        /**
         * 0 通过 2删除 1嫌疑
         */
        private Integer suggestion;
        /**
         * 检测状态
         */
        private Integer status;
        /**
         * 音视频检测结果
         */
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

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public VideoSolutionCheckResult getVideoSolutionCheckResult() {
            return videoSolutionCheckResult;
        }

        public void setVideoSolutionCheckResult(VideoSolutionCheckResult videoSolutionCheckResult) {
            this.videoSolutionCheckResult = videoSolutionCheckResult;
        }
    }

    public static class VideoSolutionCheckResult implements Serializable {
        private static final long serialVersionUID = -1882338226731782509L;
        /**
         * 音频断句
         */
        private List<AudioEvidenceSegment> segments;
        /**
         * 截图
         */
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
    }

    public static class VideoEvidencePictures implements Serializable {
        private static final long serialVersionUID = -1882338926732782509L;
        /**
         * 类型
         */
        private Integer type;
        /**
         * 图片地址
         */
        private String url;
        /**
         * 开始时间
         */
        private Long startTime;
        /**
         * 结束时间
         */
        private Long endTime;
        /**
         * 建议风险等级
         *
         * @see com.netease.is.antispam.business.common.enums.SuggestionRiskLevel
         */
        private Integer suggestionRiskLevel;
        /**
         * 专项信息 对应 publicOpinionLabelName
         */
        private String publicOpinionInfo;
        /**
         * 图片
         */
        private List<VideoEvidenceFrontPics> frontPics;
        /**
         * 图片
         */
        private List<VideoEvidenceBackPics> backPics;
        /**
         * 标签
         */
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

        public Integer getSuggestionRiskLevel() {
            return suggestionRiskLevel;
        }

        public void setSuggestionRiskLevel(Integer suggestionRiskLevel) {
            this.suggestionRiskLevel = suggestionRiskLevel;
        }

        public String getPublicOpinionInfo() {
            return publicOpinionInfo;
        }

        public void setPublicOpinionInfo(String publicOpinionInfo) {
            this.publicOpinionInfo = publicOpinionInfo;
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
    }

    public static class VideoEvidenceFrontPics implements Serializable {
        private static final long serialVersionUID = -1882338926731722509L;
        /**
         * 图片地址
         */
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class VideoEvidenceBackPics implements Serializable {
        private static final long serialVersionUID = -1882318926731782509L;
        /**
         * 图片地址
         */
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class VideoEvidenceLabel implements Serializable {
        private static final long serialVersionUID = -1882338226731782509L;
        /**
         * 标签
         */
        private Integer label;
        /**
         * 级别
         */
        private Integer level;
        /**
         * 分数
         */
        private Float rate;
        /**
         * 子标签
         */
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
    }

    public static class VideoEvidenceSubLabel implements Serializable {
        private static final long serialVersionUID = -1882338926731782509L;
        /**
         * 子标签
         */
        private Long subLabel;
        /**
         * 分数
         */
        private Float rate;
        /**
         * 子标签深度
         */
        private Integer subLabelDepth;
        /**
         * 二级标签
         */
        private String secondLabel;
        /**
         * 三级标签
         */
        private String thirdLabel;
        /**
         * 详情
         */
        private ImageSubLabelDetail details;

        public Long getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(Long subLabel) {
            this.subLabel = subLabel;
        }

        public Float getRate() {
            return rate;
        }

        public void setRate(Float rate) {
            this.rate = rate;
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

        public ImageSubLabelDetail getDetails() {
            return details;
        }

        public void setDetails(ImageSubLabelDetail details) {
            this.details = details;
        }
    }

    @Data
    public static class HintInfo implements Serializable {
        private static final long serialVersionUID = -1888338016741782509L;
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
        /**
         * 自定义规则
         */
        private List<Rule> rules;
    }

    @Data
    public static class Rule implements Serializable {
        private static final long serialVersionUID = -1888338916731782509L;
        private String name;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LibResult implements Serializable {
        private static final long serialVersionUID = -1888338816731782509L;
        /**
         * 名单类型
         */
        private Integer listType;
        /**
         * 名单内容
         */
        private String entity;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Keywords implements Serializable {
        private static final long serialVersionUID = -1888338716731782509L;
        /**
         * 自定义添加敏感词
         */
        private String word;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AudioHitInfo implements Serializable {
        private static final long serialVersionUID = -1888338616731782509L;

        /**
         * 命中类型 @see hitType;
         */
        private Integer hitType;

        /**
         * 命中原因
         */
        private Integer hitReason;

        /**
         * 命中线索，敏感词/名单
         */
        private List<String> hitClues;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HintDetail implements Serializable {
        private static final long serialVersionUID = -1888338516731782509L;
        /**
         * 命中的敏感词或者声纹检测的分值
         */
        private String value;
        /**
         * 命中的涉政歌曲名称
         */
        private String songName;
    }
}
