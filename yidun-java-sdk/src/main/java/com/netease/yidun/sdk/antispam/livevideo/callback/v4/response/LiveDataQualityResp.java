package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiveDataQualityResp {
    /**
     * 美观度分数
     */
    private Float aestheticsRate;
    /**
     * 清晰度分数
     */
    private Float sharpnessRate;
    /**
     * 截图灰度值
     */
    private Integer grayValue;
    /**
     * 图片基本信息
     */
    private MetaInfo metaInfo;
    /**
     * 图片边框信息
     */
    private BoarderInfo boarderInfo;
    /**
     * 背景信息
     */
    private BackgroundInfo backgroundInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BackgroundInfo {
        private boolean pureBackground;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MetaInfo {
        private Long byteSize;
        private Integer height;
        private Integer width;
        private String format;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoarderInfo {
        private Boolean hit;
        private Boolean top;
        private Boolean right;
        private Boolean bottom;
        private Boolean left;
        private BoarderColor color;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoarderColor {
        private Integer top;
        private Integer right;
        private Integer bottom;
        private Integer left;
    }
}
