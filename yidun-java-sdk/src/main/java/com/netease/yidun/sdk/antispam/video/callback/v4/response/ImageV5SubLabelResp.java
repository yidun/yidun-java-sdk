package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class ImageV5SubLabelResp {
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
     * 风险描述，拼接 label｜secondLabel｜thirdLabel 的中文实时释义
     */
    private String riskDescription;
    /**
     * 命中标识
     */
    private Integer hitStrategy;
    /**
     * 判断结果，0-正常，1-不确定，2-确定
     */
    private float rate;
    /**
     * 二级分类命中详情
     */
    private SubLabelDetails details;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubLabelDetails {
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
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnticheatInfo {
        private Integer hitType;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AntispamInfo {
        /**
         * 命中的名单类型
         * 1:自定义用户名单，2:自定义IP名单，3:自定义设备名单
         */
        private Integer type;
        /**
         * 名单释放时间
         * -1为永久有效
         */
        private Long releaseTime;
        /**
         * 策略组名称
         */
        private String strategyGroupName;
        /**
         * 自定义敏感词
         */
        private String word;
        /**
         * 自定义图片名单url（命中名单类型的内容）
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