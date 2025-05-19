
package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class VideoCallbackUnitV4Response {
    private String taskId;
    private String dataId;
    private String callback;
    private Integer status;
    private Integer failureReason;
    private Integer suggestion;
    private Integer label;
    private String secondLabel;
    private String thirdLabel;
    private Integer suggestionLevel;
    /**
     * 风险描述，拼接 label｜secondLabel｜thirdLabel 的中文实时释义
     */
    private String riskDescription;
    private Integer resultType;
    private Integer censorSource;
    /**
     * 策略类型
     */
    private Integer strategySource;
    private Long censorTime;
    private Long duration;
    private Integer customAction;
    private Integer picCount;
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
        private String pictureId;
        /**
         * 建议风险等级
         */
        private Integer suggestionRiskLevel;
        /**
         * 舆情专项信息
         */
        private String publicOpinionInfo;
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
