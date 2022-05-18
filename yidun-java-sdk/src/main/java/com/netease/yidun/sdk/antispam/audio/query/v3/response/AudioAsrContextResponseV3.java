package com.netease.yidun.sdk.antispam.audio.query.v3.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AudioAsrContextResponseV3 {

    private Integer status;
    /**
     * 音频uuid
     */
    private String taskId;
    /**
     * 断句详情
     */
    private List<AsrContentResponse> details;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AsrContentResponse {
        private int startTime;
        private int endTime;
        private String content;
    }

}
