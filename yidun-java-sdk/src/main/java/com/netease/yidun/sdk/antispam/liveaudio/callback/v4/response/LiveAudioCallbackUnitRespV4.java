package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response;

import java.util.List;

import lombok.Data;

@Data
public class LiveAudioCallbackUnitRespV4 {
    private Integer suggestion;
    private Integer suggestionLevel;
    private Long startTime;
    private Long endTime;
    private String content;
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
        private List<AudioSubLabelV4> subLabels;
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
