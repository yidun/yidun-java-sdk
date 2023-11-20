package com.netease.yidun.sdk.antispam.videosolution.callback.v2.response;

import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;
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
public class TextCallbackUnitV2 {
    /**
     * taskId
     */
    private String taskId;
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
     * censorType
     */
    private Integer censorType;
    /**
     * isRelatedHit
     */
    private Boolean isRelatedHit;
    /**
     * labels
     */
    private List<LabelInfo> labels;

    /**
     * 垃圾类型
     */
    @Data
    public class LabelInfo {
        private int label;
        private int level;
        /**
         * 二级分类标签
         */
        private List<TextSubLabel> subLabels;
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
        /**
         * subLabelDepth
         */
        private Integer subLabelDepth;
        /**
         * secondLabel
         */
        private String secondLabel;
        /**
         * thirdLabel
         */
        private String thirdLabel;
        /**
         * details
         */
        private TextCheckResult.AntispamSubLabelDetail details;
    }
}
