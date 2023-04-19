package com.netease.yidun.sdk.antispam.audio.callback.v4.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.BaseResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AudioAntispamCallbackV4Response implements BaseResponse {

    /**
     * 检测任务 id
     */
    private String taskId;
    /**
     * 检测状态，2-检测成功，3-检测失败
     */
    private Integer status;
    /**
     * 音频整体细分类信息 <br>
     * 0：正常，100：色情，200：广告，260：广告法，300：暴恐，400：违禁，500：涉政，600：谩骂，1100：涉价值观
     */
    private Integer label;
    /**
     * 人审标签
     */
    private String remark;
    /**
     * 检测失败原因，当检测失败时返回
     * 1：文件格式错误，2：文件下载失败，3：解析失败，4：音频流不存在
     */
    private Integer failureReason;
    /**
     * 建议结果 0-通过 1-嫌疑 2-删除
     */
    private Integer suggestion;
    /**
     * 嫌疑级别，只有 suggestion 为嫌疑时才返回 1-低嫌疑，2-高嫌疑
     */
    private Integer suggestionLevel;
    /**
     * 结果类型 1-机器结果 2-人审结果
     */
    private Integer resultType;
    /**
     * 提交时传递的回调参数
     */
    private String callback;
    /**
     * 提交时传递的 dataId
     */
    private String dataId;
    /**
     * 审核来源，0：易盾人审，1：客户人审，2：易盾机审
     */
    private Integer censorSource;
    /**
     * 人工审核完成时间，毫秒单位时间戳(13位)
     */
    private Long censorTime;
    /**
     * 音频数据所在断句详细信息
     */
    private List<AudioDataInfo> segments;
    /**
     * 审核标签
     */
    private List<CensorLabelInfo> censorLabels;
    /**
     * 音频时长字段，单位s
     */
    private Long duration;
    /**
     * 自定义建议结果 0-通过 2-删除
     */
    private Integer customAction;

    @Data
    @EqualsAndHashCode
    public static class LabelInfo {
        /**
         * <p>分类信息
         * <p> 100：色情，200：广告，260：广告法，300：暴恐，
         * <p> 400：违禁，500：涉政，600：谩骂，1100：涉价值观
         */
        private Integer label;
        /**
         * 分类级别，0：通过，1：嫌疑，2：不通过
         */
        private Integer level;
        /**
         * 命中细分类信息
         */
        private List<AudioSubLabel> subLabels;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AudioSubLabel {
        /**
         * 细分类
         */
        private String subLabel;
        /**
         * 其他信息
         */
        private HintInfo details;
    }

    @Data
    public static class HintInfo {
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
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LibResult {
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
    public static class Keywords {
        /**
         * 自定义添加敏感词
         */
        private String word;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AudioHitInfo {

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
    public static class HintDetail {
        /**
         * 命中的敏感词或者声纹检测的分值
         */
        private String value;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AudioDataInfo {
        private Integer startTime;
        private Integer endTime;

        private Long startTimeMillis;
        private Long endTimeMillis;
        /**
         * 音频数据所在断句语音识别原文内容，支持返回异常数据所在断句内容或全部原文内容
         */
        private String content;
        /**
         * 断句类型，0-语音识别，1-声纹检测
         */
        private Integer type;
        private String leaderName;
        /**
         * 分类信息
         */
        private List<LabelInfo> labels;
        private String url;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CensorLabelInfo {
        private String code;
        private String desc;
        private String customCode;
        private String name;
    }
}
