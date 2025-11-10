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
         * 说明
         */
        private String explain;
        /**
         * 标签
         */
        private String label;
        /**
         * 得分
         */
        private Double rate;
        /**
         * 识别键
         */
        private String discernKey;
        /**
         * 识别名称
         */
        private String discernName;
    }
}

