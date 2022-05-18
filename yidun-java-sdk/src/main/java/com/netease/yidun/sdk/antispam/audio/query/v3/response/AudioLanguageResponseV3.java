package com.netease.yidun.sdk.antispam.audio.query.v3.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AudioLanguageResponseV3 {

    private Integer status;
    /**
     * 音频uuid
     */
    private String taskId;
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
        private int startTime;
        private int endTime;
    }

}
