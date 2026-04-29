package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 视频大模型检测结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoCallbackLlmCheckV4Info implements BaseResponse {
    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 数据ID
     */
    private String dataId;
    /**
     * 图片列表
     */
    private List<LlmCheckPicture> pictures;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LlmCheckPicture implements BaseResponse {
        /**
         * 图片ID
         */
        private String pictureId;
        /**
         * 截图时间
         */
        private Long startTime;
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
        /**
         * 模型分数
         */
        private Double rate;
    }
}

