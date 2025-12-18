package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class LiveAudioCallbackUnitRespV4 {
    private Integer suggestion;
    /**
     * 专项信息
     */
    private String publicOpinionInfo;

    private Integer suggestionLevel;
    private Integer label;
    private String secondLabel;
    private String thirdLabel;
    /**
     * 建议风险等级
     */
    private Integer suggestionRiskLevel;

    private String riskDescription;

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
        /**
         * 建议风险等级
         */
        private Integer suggestionRiskLevel;

        private String riskDescription;

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
        /**
         * 命中的名单信息
         */
        private List<LibResultV4> libInfos;
        private IntentUnit intent;
        private List<Rule> rules;
    }

    @Data
    public static class Rule {
        private String name;
    }

    /**
     * 名单命中结果
     */
    @Data
    public static class LibResultV4 {
        /**
         * 命中类型;
         */
        private Integer listType;
        /**
         * 命中原因
         */
        private String entity;
        /**
         * 策略组名称
         */
        private String strategyGroupName;
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
        private String strategyGroupId;
        private String strategyGroupName;
    }

}
