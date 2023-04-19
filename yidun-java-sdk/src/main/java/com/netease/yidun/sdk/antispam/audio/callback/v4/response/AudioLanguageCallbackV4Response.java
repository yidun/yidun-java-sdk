package com.netease.yidun.sdk.antispam.audio.callback.v4.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AudioLanguageCallbackV4Response {
    /**
     * 检测任务 id
     */
    private String taskId;
    /**
     * 提交时传递的 dataId
     */
    private String dataId;
    /**
     * 提交时传递的 callback 参数
     */
    private String callback;
    /**
     * 语种详情
     */
    private List<LanguageDetail> details;

    @Data
    public static class LanguageDetail {
        /**
         * 语种类型
         */
        private String type;
        /**
         * 片段
         */
        private List<SegmentsInfo> segments;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SegmentsInfo {
        private Integer startTime;
        private Integer endTime;

        private Long startTimeMillis;
        private Long endTimeMillis;
    }
}
