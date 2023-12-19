package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class LiveAudioCallbackUnitRespV4 {
    private Integer suggestion;
    private Integer suggestionLevel;
    private Long startTime;
    private Long endTime;
    private String content;
    private Integer type;
    /**
     * 命中声纹检测模型分值
     */
    private Double rate;
    private List<SegmentsInfoV4> labels;
    private String url;
    private String speakerId;
    private Integer speakerRiskScore;
    private String segmentId;
    private RelatedSegmentInfo frontSegment;

    @Data
    public static class RelatedSegmentInfo {
        private String content;
        private String url;
    }

    @Data
    public static class SegmentsInfoV4 {
        private Integer label;
        private Integer level;
        private Double rate;
        private List<AudioThirdLabel> subLabels;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AudioThirdLabel extends AudioSubLabelV4 {
        private String secondLabel;
        private String thirdLabel;
        private Integer subLabelDepth;
        private Double rate;
    }

    @Data
    public static class AudioSubLabelV4 {
        private HintInfoV4 details;
        private String subLabel;
    }

    @Data
    public static class HintInfoV4 {
        private List<HintDetailV4> hitInfos;
        private List<LeaderV4> hitLeaders;
        private List<Keywords> keywords;
        private IntentUnit intent;
    }

    @Data
    public static class IntentUnit {
        private Integer result;
        private Double score;
    }

    @Data
    public static class HintDetailV4 {
        private String value;
    }

    @Data
    public static class LeaderV4 {
        private String value;
    }

    @Data
    public static class Keywords {
        private String word;
    }

}
