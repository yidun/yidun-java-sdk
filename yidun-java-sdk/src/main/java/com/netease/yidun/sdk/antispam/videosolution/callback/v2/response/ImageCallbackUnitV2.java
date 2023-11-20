package com.netease.yidun.sdk.antispam.videosolution.callback.v2.response;

import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.ImageSubLabelResp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 图片回调结果实体V3
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class ImageCallbackUnitV2 {
    /**
     * name
     */
    private String name;
    /**
     * dataId
     */
    private String dataId;
    /**
     * suggestion
     */
    private Integer suggestion;
    /**
     * resultType
     */
    private Integer resultType;
    /**
     * labels
     */
    private List<CallbackImageLabel> labels;
    /**
     * status
     */
    private Integer status;

    @AllArgsConstructor
    @Data
    public static class CallbackImageLabel {
        private int label;
        private int level;
        private float rate;
        private List<ImageSubLabelResp> subLabels;
    }
}
