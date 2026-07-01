package com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 直播音视频解决方案LLM检测回调响应V4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiveVideoSolutionLlmCheckCallbackRespV4 implements BaseResponse {
    /**
     * 音频片段列表
     */
    private LlmCheckAudioSegment audio;
    /**
     * 视频截图检测结果
     */
    private LlmCheckVideoPicture video;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LlmCheckAudioSegment implements BaseResponse {
        /**
         * 片段ID
         */
        private String segmentId;
        /**
         * 说话人ID
         */
        private String speakerId;
        /**
         * 片段开始时间
         */
        private Long startTime;
        /**
         * 片段结束时间（毫秒时间戳）
         */
        private Long endTime;
        /**
         * 回调
         */
        private String callback;
        /**
         * 详情列表
         */
        private List<LlmCheckDetail> details;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LlmCheckVideoPicture implements BaseResponse {
        /**
         * 截图ID
         */
        private String pictureId;
        /**
         * 说话人ID
         */
        private String speakerId;
        /**
         * 截图开始时间
         */
        private Long startTime;
        /**
         * 截图结束时间
         */
        private Long endTime;
        /**
         * 回调
         */
        private String callback;
        /**
         * 详情列表
         */
        private List<LlmCheckDetail> details;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LlmCheckDetail implements BaseResponse {
        /**
         * 一级标签（状态值或标签code）
         */
        private String label;
        /**
         * 二级或三级标签code
         */
        private String subLabel;
        /**
         * 命中关键词
         */
        private String keyword;
        /**
         * 扩展信息（JSON格式）
         */
        private String extension;
        /**
         * 解释说明
         */
        private String explain;
        /**
         * 模型标识
         */
        private String modelIdentifier;
    }
}
