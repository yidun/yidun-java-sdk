package com.netease.yidun.sdk.antispam.audio.callback.v4.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.BaseResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 点播音频LLM检测回调响应V4
 * <p>
 * 点播是文件级检测，与直播不同：只有 taskId/dataId/callback/details，没有 segmentId/speakerId/startTime/endTime
 * </p>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AudioLlmCheckCallbackV4Response implements BaseResponse {
    /**
     * 音频uuid
     */
    private String taskId;
    /**
     * 数据标识
     */
    private String dataId;
    /**
     * 回调
     */
    private String callback;
    /**
     * 大模型检测状态
     */
    private Integer llmStatus;
    /**
     * 大模型检测失败原因
     */
    private Integer llmFailureReason;
    /**
     * LLM检测详情列表
     */
    private List<LlmCheckDetail> details;

    @Data
    @Builder
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
