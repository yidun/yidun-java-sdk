package com.netease.yidun.sdk.antispam.videosolution.callback.v2.response;

import java.util.List;

import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.ImageSubLabelResp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 图片回调结果实体V3
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class ImageCallbackUnit {
    private String name;
    private String taskId;
    private Integer suggestReason;
    private List<CallbackImageLabel> labels;
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
