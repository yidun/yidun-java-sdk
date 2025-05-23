package com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackUnitRespV4;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackV4Result;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioLanguageCallbackRespV3;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioMonitorCallbackUnitRespV4;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioQualityCallbackRespV4;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioVoiceCallbackRespV4;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveDataCallbackDiscernUnitV4;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveDataCallbackFaceUnitV4;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveDataCallbackLogoUnitV4;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveDataCallbackOcrUnitV4;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveDataCallbackQualityUnitV4;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.ImageV5SubLabelResp;
import com.netease.yidun.sdk.core.response.BaseResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LiveVideoSolutionCallbackV3Result implements BaseResponse {
    private LiveVideoSolutionCallbackAntispamV3Result antispam;
    private LiveDataCallbackOcrUnitV4 ocr;
    private LiveDataCallbackDiscernUnitV4 discern;
    private LiveDataCallbackLogoUnitV4 logo;

    /**
     * 人声属性识别结果
     */
    private LiveAudioVoiceCallbackRespV4 voice;

    private LiveCallbackQualityUnitV4 quality;

    private LiveDataCallbackFaceUnitV4 face;
    /**
     * 语种识别结果
     */
    private LiveAudioLanguageCallbackRespV3 language;
    /**
     * asr
     */
    private LiveAudioCallbackV4Result.LiveAudioAsrContentCallbackRespV3 asr;
    @Data
    public static class LiveCallbackQualityUnitV4 {
        private LiveDataCallbackQualityUnitV4 video;
        private LiveAudioQualityCallbackRespV4 audio;
    }

    @Data
    public static class LiveVideoSolutionCallbackAntispamV3Result {
        private String taskId;
        private String callback;
        private String dataId;
        private Integer status;
        /**
         * 结束类型：0易盾结束（拉不到流）；1客户结束（feedback）
         */
        private Integer finishType;
        private Long time;
        private Integer censorSource;
        /**
         * 策略类型
         */
        private Integer strategySource;
        /**
         * 检测失败原因，当检测失败时返回，1：下载失败，2：直播流不存在，3：解析失败，4：格式错误
         */
        private Integer failureReason;
        /**
         * 音频语种码
         */
        private String languageCode;
        private LiveSolutionDataCallbackResult evidences;
        private LiveSolutionCensorCallbackResult reviewEvidences;
        private Integer riskLevel;
        private Integer riskScore;
        private Long duration;
        private Long billDuration;
        private Long picCount;
    }

    @Data
    public static class LiveSolutionDataCallbackResult implements BaseResponse {
        private LiveAudioCallbackUnitRespV4 audio;
        private MachineEvidences video;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SegmentsInfo implements BaseResponse {
        private int label;
        private int level;
        private List<AudioSubLabel> subLabels;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AudioSubLabel implements BaseResponse {
        private HintInfo details;
        private String subLabel;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HintInfo implements BaseResponse {
        private String evidence;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MachineEvidences implements BaseResponse {
        private VideoEvidence evidence;
        private List<CallbackImageLabel> labels;
    }

    @Data
    public static class CallbackImageLabel implements BaseResponse {
        private Integer label;
        private Integer level;
        private Float rate;
        private List<ImageV5SubLabelResp> subLabels;
    }

    @Data
    public static class ImageSubLabel implements BaseResponse {
        /**
         * 对外的图片label
         */
        private String subLabel;
        /**
         * 判断结果，0-正常，1-不确定，2-确定
         */
        private float rate;
        /**
         * 得分，范围为0到1
         */
        private SubLabelDetails details;
    }

    @Data
    public static class SubLabelDetails implements BaseResponse {
        /**
         * 命中信息，包含规则，敏感词，图片模型结果
         */
        private Set<String> hitInfos = new HashSet<>();

        /**
         * 反作弊结果
         */
        private AnticheatInfo anticheatInfo;
        /**
         * 图片命中标签信息
         */
        private List<ImageTagInfo> imageTagInfos;
        /**
         * 命中用户添加图片名单信息
         */
        private List<ImageListInfo> imageListInfos;
        /**
         * 命中内容证据信息
         */
        private List<HitLocationInfo> hitLocationInfos;
    }

    @Data
    public static class AnticheatInfo implements BaseResponse {
        private Integer hitType;
    }

    @Data
    public static class ImageTagInfo implements BaseResponse {
        private String tagName;
        private String tagGroup;
    }

    @Data
    public static class ImageListInfo implements BaseResponse {
        /**
         * 1为自定义图片名单，2为自定义敏感词
         */
        private Integer type;
        private String url;
        private Integer hitCount;
        private String word;
    }

    @Data
    public static class HitLocationInfo implements BaseResponse {
        /**
         * 命中信息
         */
        private String hitInfo;
        /**
         * 坐标左上一个 右下一个
         */
        private Float x1;
        private Float y1;
        private Float x2;
        private Float y2;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class VideoEvidence implements BaseResponse {
        private Integer suggestion;
        private int type;
        private String url;
        private long beginTime;
        private long endTime;
        private String speakerId;
        private List<RelatedPicInfo> frontPics;
        private String pictureId;
        private Integer speakerRiskScore;
        /**
         * 专项信息
         */
        private String publicOpinionInfo;
    }

    @Data
    public static class RelatedPicInfo {
        private String url;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LiveSolutionCensorCallbackResult implements BaseResponse {
        /**
         * 操作
         */
        private int action;
        /**
         * 判断时间点
         */
        private long actionTime;
        /**
         * 违规类型
         */
        private int label;
        /**
         * 违规详情
         */
        private String detail;
        /**
         * 警告次数
         */
        private int warnCount;
        /**
         * 针对接入SDK监听客户，针对房间内具体说话人的处罚，返回说话人ID信息，若为空，则针对房间维度处罚
         */
        private String speakerId;
        /**
         * 审核员账号
         */
        private String censorAccount;
        /**
         * 截图证据
         */
        private List<Evidence> evidence;
        /**
         * 人审标签内容
         */
        private List<LiveAudioMonitorCallbackUnitRespV4.CensorLabelInfo> censorLabels;
        /**
         * 人审视频截图信息
         */
        private List<ReviewPicture> pictures;
        /**
         * 人审音频证据信息
         */
        private List<ReviewSegment> segments;
        /**
         * 人审操作action时返回前20s的音频断句信息，用于还原场景
         */
        private FrontAudioSegment frontAudioSegment;
    }

    @Data
    @AllArgsConstructor
    public static class Evidence {
        private String snapshot;
    }

    @Data
    @AllArgsConstructor
    public static class ReviewPicture {
        /**
         * 人审截图地址
         */
        private String url;
        /**
         * 截图开始时间
         */
        private Long beginTime;
    }

    @Data
    @AllArgsConstructor
    public static class ReviewSegment {
        /**
         * 人审断句开始时间
         */
        private Long startTime;
        /**
         * 人审断句结束时间
         */
        private Long endTime;
        /**
         * 人审断句语音识别内容
         */
        private String content;
        /**
         * 人审断句音频地址
         */
        private String url;
    }

    @Data
    @AllArgsConstructor
    public static class FrontAudioSegment {
        private String url;
        private String content;
    }
}
