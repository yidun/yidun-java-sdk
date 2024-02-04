package com.netease.yidun.sdk.antispam.videosolution.callback.v2.response;

import java.util.List;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioAntispamCallbackV4Response;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackUnitV4Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class VideoSolutionAntispamCallbackV2Response {
    /**
     * 音视频数据请求标识，可以根据该标识查询音视频数据最新结果
     */
    private String taskId;
    /**
     * 调用音视频检测时传递的dataId字段
     */
    private String dataId;

    /**
     * md5 值
     */
    private String md5;
    /**
     * 调用音视频检测时传递的callback字段
     */
    private String callback;
    private Integer suggestion;
    private Integer status;
    private Integer resultType;
    /**
     * 人审轮次
     */
    private Integer censorRound;
    /**
     * 审核来源，0：易盾人审，1：客户人审，2：易盾机审
     */
    private Integer censorSource;
    /**
     * 策略类型
     */
    private Integer strategySource;
    /**
     * 机器检测结束时间，毫秒单位的时间戳形式 <br>
     * （2021.1.1 01:00转换时间戳1609434000000）
     */
    private Long checkTime;
    /**
     * 人工审核完成时间，毫秒单位时间戳(13位)
     */
    private Long censorTime;
    /**
     * 音视频时长字段，单位毫秒
     */
    private Long duration;
    /**
     * 音频时长字段，单位毫秒
     */
    private Long durationMs;
    /**
     * 一级垃圾类型
     */
    private Integer label;
    /**
     * 截图数量
     */
    private Long picCount;
    /**
     * 机器检测证据信息，接入机器检测时参考证据信息
     */
    private VideoSolutionCallbackEvidenceV2Response evidences;
    /**
     * 音视频解决方案额外信息
     */
    private VideoSolutionCallbackExtraV2Response solutionExtra;
    /**
     * 人审证据信息，接入人工审核后，参考人审证据信息，人审证据信息与机器检测证据信息不共存
     */
    private VideoSolutionCallbackReviewEvidenceV2Response reviewEvidences;
    private List<CensorLabelInfoV2Response> censorLabels;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VideoSolutionCallbackExtraV2Response {
        private VideoSolutionFailUnitResponse failUnit;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VideoSolutionFailUnitResponse {
        private List<VideoSolutionImageFailUnitResponse> images;
        private VideoSolutionTargetFailUnitResponse audio;
        private VideoSolutionTargetFailUnitResponse video;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VideoSolutionTargetFailUnitResponse {
        private Integer failureReason;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VideoSolutionImageFailUnitResponse {
        private Integer failureReason;
        private String name;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VideoSolutionCallbackEvidenceV2Response {
        /**
         * 标题证据信息
         */
        private TextCallbackUnitV2 text;
        /**
         * 图片证据信息
         */
        private List<ImageCallbackUnitV2> images;
        /**
         * 语音证据信息
         */
        private AudioAntispamCallbackV4Response audio;
        /**
         * 视频证据信息
         */
        private VideoCallbackUnitV4Response video;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VideoSolutionCallbackReviewEvidenceTextV2Response {
        private String snippet;
        private String description;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    public static class VideoSolutionCallbackReviewEvidenceImageV2Response {
        private String url;
        private String description;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    public static class VideoSolutionCallbackReviewEvidenceAudioV2Response {
        private Long startTime;
        private Long endTime;
        private String description;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VideoSolutionCallbackReviewEvidenceVideoV2Response {
        private Long startTime;
        private Long endTime;
        private String url;
        private String description;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VideoSolutionCallbackReviewEvidenceV2Response {
        private String description;
        private String detail;
        private List<VideoSolutionCallbackReviewEvidenceTextV2Response> texts;
        private List<VideoSolutionCallbackReviewEvidenceImageV2Response> images;
        private List<VideoSolutionCallbackReviewEvidenceAudioV2Response> audios;
        private List<VideoSolutionCallbackReviewEvidenceVideoV2Response> videos;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CensorLabelInfoV2Response {
        private String code;
        private String desc;
    }
}
