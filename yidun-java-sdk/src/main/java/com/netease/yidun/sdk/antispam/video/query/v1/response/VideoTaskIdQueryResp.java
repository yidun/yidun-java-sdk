package com.netease.yidun.sdk.antispam.video.query.v1.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 点播根据id查询响应
 */
@Slf4j
@Data
public class VideoTaskIdQueryResp extends CommonResponse {

    private List<VideoTaskIdQueryResult> result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class VideoTaskIdQueryResult {
        private String taskId;
        private String callback;
        private Integer status;
        private Integer level;
        private List<VideoEvidence> evidences;
    }

    @Data
    @AllArgsConstructor
    public static class VideoEvidence {
        private Integer type;
        private String url;
        private Long beginTime;
        private Long endTime;
        private List<CallbackImageLabel> labels;
    }

    @AllArgsConstructor
    @Data
    public static class CallbackImageLabel {
        private int label;
        private int level;
        private float rate;
        private List<ImageSubLabelV3Resp> subLabels;
    }
}
