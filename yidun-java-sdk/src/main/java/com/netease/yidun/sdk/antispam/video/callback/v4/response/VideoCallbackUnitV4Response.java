
package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class VideoCallbackUnitV4Response {
    private String taskId;
    private String dataId;
    private String callback;
    private Integer status;
    private Integer failureReason;
    private Integer suggestion;
    private Integer suggestionLevel;
    private Integer resultType;
    private Integer censorSource;
    private Long censorTime;
    private Long duration;
    private Integer customAction;
    private List<VideoEvidenceResponse> pictures;

    @Data
    @AllArgsConstructor
    public static class VideoEvidenceResponse {
        private Integer type;
        private String url;
        private Long startTime;
        private Long endTime;
        private List<CallbackImageLabelResponse> labels;
        private Integer censorSource;
        private List<RelatedPicInfoResponse> frontPics;
        private List<RelatedPicInfoResponse> backPics;

    }

    @AllArgsConstructor
    @Data
    public static class CallbackImageLabelResponse {
        private Integer label;
        private Integer level;
        private Float rate;
        private List<ImageV5SubLabelResp> subLabels;
    }

    /**
     * 相邻截图信息
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class RelatedPicInfoResponse {
        private String url;
    }
}
