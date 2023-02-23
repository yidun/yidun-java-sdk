package com.netease.yidun.sdk.antispam.media.v2.common.response;

import java.util.List;
import java.util.Set;

/**
 * 融媒体人工审核响应结果
 */
public class MediaCensorResponse {
    private String dataId;
    private String taskId;
    private String callback;
    private Integer suggestion;
    /**
     * 审核类型，1:机器检测，2:审核
     */
    private Integer resultType;
    private Integer censorSource;
    private Integer censorOperateSource;
    private Integer censorRound;
    /**
     * 最近一次人工审核或质检的时间
     */
    private Long censorTime;
    private Integer skipCensor;
    /**
     * 标签
     */
    private Set<CensorLabel> censorLabels;
    private MediaCensorReviewEvidence reviewEvidences;

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

    public Integer getCensorSource() {
        return censorSource;
    }

    public void setCensorSource(Integer censorSource) {
        this.censorSource = censorSource;
    }

    public Integer getCensorOperateSource() {
        return censorOperateSource;
    }

    public void setCensorOperateSource(Integer censorOperateSource) {
        this.censorOperateSource = censorOperateSource;
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

    public Integer getSkipCensor() {
        return skipCensor;
    }

    public void setSkipCensor(Integer skipCensor) {
        this.skipCensor = skipCensor;
    }

    public Set<CensorLabel> getCensorLabels() {
        return censorLabels;
    }

    public void setCensorLabels(Set<CensorLabel> censorLabels) {
        this.censorLabels = censorLabels;
    }

    public MediaCensorReviewEvidence getReviewEvidences() {
        return reviewEvidences;
    }

    public void setReviewEvidences(MediaCensorReviewEvidence reviewEvidences) {
        this.reviewEvidences = reviewEvidences;
    }

    public static class MediaCensorReviewEvidence {
        private String reason;
        private String remark;
        private Set<CensorLabel> censorLabels;
        /** 人审证据详细信息 */
        private Detail detail;

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

        public Set<CensorLabel> getCensorLabels() {
            return censorLabels;
        }

        public void setCensorLabels(Set<CensorLabel> censorLabels) {
            this.censorLabels = censorLabels;
        }

        public Detail getDetail() {
            return detail;
        }

        public void setDetail(Detail detail) {
            this.detail = detail;
        }

        public static class Detail {
            private List<TextDetail> texts;
            private List<ImageDetail> images;
            private List<AudioDetail> audios;
            private List<VideoDetail> videos;
            private List<AudioVideoDetail> audiovideos;
            private List<FileDetail> files;

            public List<TextDetail> getTexts() {
                return texts;
            }

            public void setTexts(List<TextDetail> texts) {
                this.texts = texts;
            }

            public List<ImageDetail> getImages() {
                return images;
            }

            public void setImages(List<ImageDetail> images) {
                this.images = images;
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

            public List<AudioVideoDetail> getAudiovideos() {
                return audiovideos;
            }

            public void setAudiovideos(List<AudioVideoDetail> audiovideos) {
                this.audiovideos = audiovideos;
            }

            public List<FileDetail> getFiles() {
                return files;
            }

            public void setFiles(List<FileDetail> files) {
                this.files = files;
            }
        }

        public static class TextDetail {
            private String field;
            private String dataId;
            private Integer censorResult;
            private String reviseContent;
            private List<TextReason> reasons;

            public String getField() {
                return field;
            }

            public void setField(String field) {
                this.field = field;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public Integer getCensorResult() {
                return censorResult;
            }

            public void setCensorResult(Integer censorResult) {
                this.censorResult = censorResult;
            }

            public String getReviseContent() {
                return reviseContent;
            }

            public void setReviseContent(String reviseContent) {
                this.reviseContent = reviseContent;
            }

            public List<TextReason> getReasons() {
                return reasons;
            }

            public void setReasons(List<TextReason> reasons) {
                this.reasons = reasons;
            }
        }

        public static class ImageDetail {
            private String field;
            private String dataId;
            private Integer censorResult;
            private List<ImageReason> reasons;

            public String getField() {
                return field;
            }

            public void setField(String field) {
                this.field = field;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public Integer getCensorResult() {
                return censorResult;
            }

            public void setCensorResult(Integer censorResult) {
                this.censorResult = censorResult;
            }

            public List<ImageReason> getReasons() {
                return reasons;
            }

            public void setReasons(List<ImageReason> reasons) {
                this.reasons = reasons;
            }
        }

        public static class VideoDetail {
            private String field;
            private String dataId;
            private Integer censorResult;
            private List<AudioVideoReason> reasons;

            public String getField() {
                return field;
            }

            public void setField(String field) {
                this.field = field;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public Integer getCensorResult() {
                return censorResult;
            }

            public void setCensorResult(Integer censorResult) {
                this.censorResult = censorResult;
            }

            public List<AudioVideoReason> getReasons() {
                return reasons;
            }

            public void setReasons(List<AudioVideoReason> reasons) {
                this.reasons = reasons;
            }
        }

        public static class AudioDetail {
            private String field;
            private String dataId;
            private Integer censorResult;
            private List<AudioVideoReason> reasons;

            public String getField() {
                return field;
            }

            public void setField(String field) {
                this.field = field;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public Integer getCensorResult() {
                return censorResult;
            }

            public void setCensorResult(Integer censorResult) {
                this.censorResult = censorResult;
            }

            public List<AudioVideoReason> getReasons() {
                return reasons;
            }

            public void setReasons(List<AudioVideoReason> reasons) {
                this.reasons = reasons;
            }
        }

        public static class AudioVideoDetail {
            private String field;
            private String dataId;
            private Integer censorResult;
            private List<AudioVideoReason> videos;
            private List<AudioVideoReason> audios;

            public String getField() {
                return field;
            }

            public void setField(String field) {
                this.field = field;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public Integer getCensorResult() {
                return censorResult;
            }

            public void setCensorResult(Integer censorResult) {
                this.censorResult = censorResult;
            }

            public List<AudioVideoReason> getVideos() {
                return videos;
            }

            public void setVideos(List<AudioVideoReason> videos) {
                this.videos = videos;
            }

            public List<AudioVideoReason> getAudios() {
                return audios;
            }

            public void setAudios(List<AudioVideoReason> audios) {
                this.audios = audios;
            }
        }

        public static class FileDetail {
            private String field;
            private String dataId;
            private Integer censorResult;
            private List<TextReason> texts;
            private List<ImageReason> images;

            public String getField() {
                return field;
            }

            public void setField(String field) {
                this.field = field;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public Integer getCensorResult() {
                return censorResult;
            }

            public void setCensorResult(Integer censorResult) {
                this.censorResult = censorResult;
            }

            public List<TextReason> getTexts() {
                return texts;
            }

            public void setTexts(List<TextReason> texts) {
                this.texts = texts;
            }

            public List<ImageReason> getImages() {
                return images;
            }

            public void setImages(List<ImageReason> images) {
                this.images = images;
            }
        }

        public static class TextReason {
            private String text;
            private String reason;
            private Set<CensorLabel> censorLabels;

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

            public Set<CensorLabel> getCensorLabels() {
                return censorLabels;
            }

            public void setCensorLabels(Set<CensorLabel> censorLabels) {
                this.censorLabels = censorLabels;
            }
        }

        public static class ImageReason {
            private String url;
            private String reason;
            private Set<CensorLabel> censorLabels;
            /**
             * 图片标注信息
             */
            private List<DetailMark> detailMarks;

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

            public Set<CensorLabel> getCensorLabels() {
                return censorLabels;
            }

            public void setCensorLabels(Set<CensorLabel> censorLabels) {
                this.censorLabels = censorLabels;
            }

            public List<DetailMark> getDetailMarks() {
                return detailMarks;
            }

            public void setDetailMarks(List<DetailMark> detailMarks) {
                this.detailMarks = detailMarks;
            }

            public static class DetailMark {

                /**
                 * 标注描述
                 */
                private String desc;

                /**
                 * 标注标签
                 */
                private Set<CensorLabel> censorLabels;

                /**
                 * 标注位置
                 */
                private List<Point> position;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public Set<CensorLabel> getCensorLabels() {
                    return censorLabels;
                }

                public void setCensorLabels(Set<CensorLabel> censorLabels) {
                    this.censorLabels = censorLabels;
                }

                public List<Point> getPosition() {
                    return position;
                }

                public void setPosition(List<Point> position) {
                    this.position = position;
                }

                public static class Point {

                    /**
                     * x轴坐标
                     */
                    private Float x;
                    /**
                     * y轴坐标
                     */
                    private Float y;

                    public Float getX() {
                        return x;
                    }

                    public void setX(Float x) {
                        this.x = x;
                    }

                    public Float getY() {
                        return y;
                    }

                    public void setY(Float y) {
                        this.y = y;
                    }
                }
            }
        }

        public static class AudioVideoReason {
            private String url;
            private Long startTime;
            private Long endTime;
            private String reason;
            private Set<CensorLabel> censorLabels;

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

            public Set<CensorLabel> getCensorLabels() {
                return censorLabels;
            }

            public void setCensorLabels(Set<CensorLabel> censorLabels) {
                this.censorLabels = censorLabels;
            }
        }
    }

    public static class CensorLabel {
        private String code;
        private String name;
        private String customCode;
        private String desc;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCustomCode() {
            return customCode;
        }

        public void setCustomCode(String customCode) {
            this.customCode = customCode;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
