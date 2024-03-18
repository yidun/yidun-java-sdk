package com.netease.yidun.sdk.antispam.videosolution.query.v1.response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class VideoSolutionQueryV1Resp extends CommonResponse {
    private List<VideoSolutionQueryV1Result> result;

    @Data
    public static class VideoSolutionQueryV1Result implements BaseResponse {
        /**
         * 数据状态 0-检测完成或检测失败 20-非7天内数据 30-数据不存在 40-检测中
         */
        private int status;
        /**
         * 调用音视频检测时传递的dataId字段
         */
        private String dataId;
        /**
         * 音视频数据请求标识，可以根据该标识查询音视频数据最新结果
         */
        private String taskId;
        /**
         * 调用音视频检测时传递的callback字段
         */
        private String callback;
        /**
         * 检测结果, 1:正常 2:异常 3:疑似
         */
        private Integer result;
        /**
         * 检测状态 0-检测中 1-检测成功 2-检测失败
         */
        private Integer checkStatus;
        /**
         * 审核来源，0：易盾人审，1：客户人审，2：易盾机审
         */
        private Integer censorSource;
        /**
         * 机器检测结束时间，毫秒单位的时间戳形式 <br>
         * （2021.1.1 01:00转换时间戳1609434000000）
         */
        private Long checkTime;
        /**
         * 机审证据信息
         */
        private Evidence evidences;
        /**
         * 人审证据信息
         */
        private ReviewEvidence reviewEvidences;
    }

    @Data
    public static class Evidence implements BaseResponse {
        /**
         * 标题证据信息
         */
        private TextCallbackUnit text;
        /**
         * 图片证据信息
         */
        private List<ImageCallbackUnit> images;
        /**
         * 语音证据信息
         */
        private AudioCallbackUnit audio;
        /**
         * 视频证据信息
         */
        private VideoCallbackUnit video;
    }

    @Data
    public class TextCallbackUnit implements BaseResponse {
        /**
         * 检测结果，0：通过，1：嫌疑，2：不通过
         */
        private int action;
        /**
         * 唯一标识
         */
        private String taskId;
        private Integer suggestReason = 0;
        /**
         * 分类信息 详细数据与文本在线检测 labels 数据结构一致
         */
        private List<LabelInfo> labels;
    }

    @Data
    public static class LabelInfo implements BaseResponse {
        private int label;
        private int level;
        private TextHintInfo details;
        /**
         * 二级分类标签
         */
        private List<TextSubLabel> subLabels;
    }

    @Data
    public static class TextHintInfo implements BaseResponse {
        private List<String> hint;
    }

    @Data
    public static class TextSubLabel implements BaseResponse {
        /**
         * 值定义见 SpamType
         */
        private String subLabel;
    }

    @Data
    public static class ImageCallbackUnit implements BaseResponse {
        private String name;
        private String taskId;
        private Integer suggestReason = 0;
        private List<CallbackImageLabel> labels;
    }

    @Data
    public static class CallbackImageLabel implements BaseResponse {
        private int label;
        private int level;
        private float rate;
        private List<ImageSubLabel> subLabels;
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
    public static class AudioCallbackUnit implements BaseResponse {

        private Integer action;

        /**
         * 语音翻译状态
         */
        private int asrStatus;

        /**
         * 语音翻译失败错误码 @see VideoSolutionAudioAsrResult
         */
        private Integer asrResult;

        private String taskId;

        private Integer suggestReason;
        private List<LabelInfoResponse> labels;

        private List<AudioDataInfo> segments;
    }

    @Data
    public static class HintInfo implements BaseResponse {
        private List<HintDetail> hint;
        private int hitType;
    }

    @Data
    public static class HintDetail {
        private String value;
        private List<SegmentsInfo> segments;
    }

    @Data
    public class SegmentsInfo implements BaseResponse {
        private int startTime;
        private int endTime;
    }

    @Data
    public static class AudioDataInfo implements BaseResponse {
        private Integer startTime;
        private Integer endTime;
        private String content;
        private Integer label;
        private Integer level;
        private List<String> hintList;
    }

    @Data
    public static class LabelInfoResponse implements BaseResponse {
        private int label;
        private int level;
        private List<String> subLabels;
        private HintInfo details;
    }

    @Data
    public static class AudioSubLabel implements BaseResponse {
        private String subLabel;
        private HintInfo details;
    }

    @Data
    public static class VideoCallbackUnit implements BaseResponse {
        private String taskId;
        private int status;
        private int level;
        private Integer suggestReason = 0;
        private List<VideoEvidence> evidences;
    }

    @Data
    public static class VideoEvidence implements BaseResponse {
        private int type;
        private String url;
        private long beginTime;
        private long endTime;
        private List<CallbackImageLabel> labels;
    }

    @Data
    public static class ReviewEvidence implements BaseResponse {
        /**
         * 人工判定原因
         */
        private String reason;
        /**
         * 详细人审证据信息
         */
        private ReviewEvidenceDetail detail;
    }

    @Data
    public static class ReviewEvidenceDetail implements BaseResponse {
        /**
         * 文本证据信息
         */
        private List<TextCensorEvidenceCallback> text;
        /**
         * 图片证据信息
         */
        private List<ImageCensorEvidenceCallback> image;
        /**
         * 人审音频片段证据信息
         */
        private List<AudioCensorEvidenceCallback> audio;
        /**
         * 人审视频截图证据信息
         */
        private List<VideoCensorEvidenceCallback> video;
    }

    @Data
    public static class TextCensorEvidenceCallback implements BaseResponse {
        /**
         * 证据信息文本
         */
        private String word;
        /**
         * 加入原因
         */
        private String description;
    }

    @Data
    public static class ImageCensorEvidenceCallback implements BaseResponse {
        /**
         * 证据截图 url
         */
        private String url;
        /**
         * 加入原因
         */
        private String description;
    }

    @Data
    public static class AudioCensorEvidenceCallback implements BaseResponse {
        /**
         * 音频断句证据开始时间戳，单位秒
         */
        private long startTime;
        /**
         * 音频断句证据结束时间戳，单位秒
         */
        private long endTime;
        /**
         * 加入原因
         */
        private String description;
    }

    @Data
    public static class VideoCensorEvidenceCallback implements BaseResponse {
        /**
         * 证据截图url
         */
        private String url;
        /**
         * 证据开始时间戳，单位毫秒
         */
        private long startTime;
        /**
         * 证据结束时间戳，单位毫秒
         */
        private long endTime;
        /**
         * 加入原因
         */
        private String description;
    }
}
