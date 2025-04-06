package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 检测接口返回的图片label对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageSubLabelResp implements Serializable {
    private static final long serialVersionUID = 5633857106221598752L;
    /**
     * 对外的图片label
     */
    private String subLabel;
    /**
     * 命中的最终细分类的层级
     */
    private Integer subLabelDepth;
    /**
     * 二级分类，必返回
     */
    private String secondLabel;
    /**
     * 三级分类，可能返回
     */
    private String thirdLabel;
    /**
     * 命中标识
     */
    private Integer hitStrategy;
    /**
     * 判断结果，0-正常，1-不确定，2-确定
     */
    private float rate;
    /**
     * 得分，范围为0到1
     */
    private SubLabelDetails details;
    /**
     * 建议风险等级
     */
    private String suggestionRiskLevel;

    @Data
    public static class SubLabelDetails implements Serializable {

        /**
         * 反垃圾自定义敏感词结果
         */
        private List<AntispamInfo> keywords;
        /**
         * 反垃圾自定义图片名单结果
         */
        private List<AntispamInfo> libInfos;
        /**
         * 反垃圾其他命中信息
         */
        private List<AntispamInfo> hitInfos;
        /**
         * 反作弊结果
         */
        private AnticheatInfo anticheat;
        /**
         * 命中的用户自定义规则的信息
         */
        private List<RuleInfo> rules;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RuleInfo {
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnticheatInfo implements Serializable {
        private Integer hitType;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AntispamInfo implements Serializable {
        /**
         * 自定义敏感词
         */
        private String word;
        /**
         * 自定义图片名单url
         */
        private String entity;
        /**
         * 自定义图片名单命中次数
         */
        private Integer hitCount;
        private String value;
        private String group;
        /**
         * 坐标左上一个 右下一个
         */
        private Float x1;
        private Float y1;
        private Float x2;
        private Float y2;
    }
}
