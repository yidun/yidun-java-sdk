package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.BaseResponse;

import lombok.Data;

@Data
public class LiveAudioCallbackV4Result implements BaseResponse {
    /**
     * 反垃圾检测结果
     */
    private LiveAudioAntispamCallbackRespV4 antispam;
    /**
     * 语音识别结果
     */
    private LiveAudioAsrContentCallbackRespV3 asr;
    /**
     * 语种识别结果
     */
    private LiveAudioLanguageCallbackRespV3 language;
    /**
     * 人声属性识别结果
     */
    private LiveAudioVoiceCallbackRespV4 voice;
    /**
     * 音频质量识别结果
     */
    private LiveAudioQualityCallbackRespV4 quality;

    @Data
    public static class LiveAudioAntispamCallbackRespV4 {
        private String taskId;
        private String callback;
        private String dataId;
        private Integer censorSource;
        private Integer status;
        private Integer failureReason;
        private LiveAudioCallbackUnitRespV4 evidences;
        private LiveAudioMonitorCallbackUnitRespV4 reviewEvidences;
        private Integer riskLevel;
        private Integer riskScore;
        private Long duration;
        private Long billDuration;
    }

    @Data
    public static class LiveAudioAsrContentCallbackRespV3 {
        private String taskId;
        private Long startTime;
        private Long endTime;
        private String content;
        private String speakerId;
        private String dataId;
        private String callback;
        private String url;
    }

    @Data
    public static class LiveAudioCallbackUnitRespV3 {
        /**
         * 本次回调片段中最高优先级的level
         */
        private Integer action;
        /**
         * 语音翻译状态
         */
        private Integer asrStatus;
        /**
         * 语音翻译失败错误码
         */
        private Integer asrResult;

        private Long startTime;

        private Long endTime;

        private String content;
        /**
         * 片段信息
         */
        private List<SegmentsInfo> segments;

        private String url;
        /**
         * 音频断句关联用户id
         */
        private String speakerId;
        private String segmentId;

    }

    @Data
    public static class SegmentsInfo implements BaseResponse {
        private Integer label;
        private Integer level;
        private List<AudioSubLabel> subLabels;
    }

    @Data
    public static class AudioSubLabel implements BaseResponse {
        private HintInfo details;
        private String subLabel;
    }

    @Data
    public static class HintInfo implements BaseResponse {
        private String evidence;
    }

    @Data
    public static class LiveAudioMonitorCallbackUnitRespV3 implements BaseResponse {
        /**
         * 操作
         */
        private Integer action;
        /**
         * 判断时间点
         */
        private Long actionTime;
        /**
         * 违规类型
         */
        private Integer spamType;
        /**
         * 违规详情
         */
        private String spamDetail;
        /**
         * 警告次数
         */
        private Integer warnCount;
        /**
         * 提示次数
         */
        private Integer promptCount;
        /**
         * 截图证据
         */
        private List<Evidence> segments;
        /**
         * 检测状态
         */
        private Integer status;
    }

    @Data
    public static class Evidence implements BaseResponse {
        private Long startTime;
        private Long endTime;
    }
}
