package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 直播音频LLM检测回调响应V4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiveAudioLlmCheckCallbackRespV4 implements BaseResponse {
    /**
     * 音频uuid
     */
    private String taskId;
    /**
     * 数据标识
     */
    private String dataId;
    /**
     * 片段ID（segmentId）
     */
    private String segmentId;
    /**
     * 说话人id
     */
    private String speakerId;
    /**
     * 片段开始时间（毫秒时间戳）
     */
    private Long startTime;
    /**
     * LLM检测详情列表
     */
    private List<LlmCheckDetail> details;

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
