package com.netease.yidun.sdk.antispam.videosolution.callback.v2.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 文本回调结果实体V3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextCallbackUnit {

    private int action;
    private String taskId;
    private Integer suggestReason;
    private List<LabelInfo> labels;

    @Data
    public class LabelInfo {
        private int label;
        private int level;
        private HintInfo details;
        /**
         * 二级分类标签
         */
        private List<TextSubLabel> subLabels;
    }

    @Data
    public class HintInfo {
        private List<String> hint;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TextSubLabel {
        /**
         * 值定义见SpamType
         */
        private String subLabel;

        private Integer subLabelDepth;

        private String secondLabel;

        private String thirdLabel;
    }
}
