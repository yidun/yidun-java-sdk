package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import java.util.List;

/**
 * 图片标签详细信息
 */
public class ImageSubLabelDetail {

    /**
     * 反垃圾自定义敏感词结果
     */
    private List<ImageSubLabelDetailInfo> keywords;
    /**
     * 反垃圾自定义图片名单结果
     */
    private List<ImageSubLabelDetailInfo> libInfos;
    /**
     * 反垃圾其他命中信息
     */
    private List<ImageSubLabelDetailInfo> hitInfos;
    /**
     * saas自定义规则
     */
    private List<ImageSubLabelDetailInfo> rules;

    public List<ImageSubLabelDetailInfo> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<ImageSubLabelDetailInfo> keywords) {
        this.keywords = keywords;
    }

    public List<ImageSubLabelDetailInfo> getLibInfos() {
        return libInfos;
    }

    public void setLibInfos(List<ImageSubLabelDetailInfo> libInfos) {
        this.libInfos = libInfos;
    }

    public List<ImageSubLabelDetailInfo> getHitInfos() {
        return hitInfos;
    }

    public void setHitInfos(List<ImageSubLabelDetailInfo> hitInfos) {
        this.hitInfos = hitInfos;
    }

    public List<ImageSubLabelDetailInfo> getRules() {
        return rules;
    }

    public void setRules(List<ImageSubLabelDetailInfo> rules) {
        this.rules = rules;
    }

    public static class ImageSubLabelDetailInfo {
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
        /**
         * saas自定义规则
         */
        private String name;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }

        public Integer getHitCount() {
            return hitCount;
        }

        public void setHitCount(Integer hitCount) {
            this.hitCount = hitCount;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public Float getX1() {
            return x1;
        }

        public void setX1(Float x1) {
            this.x1 = x1;
        }

        public Float getY1() {
            return y1;
        }

        public void setY1(Float y1) {
            this.y1 = y1;
        }

        public Float getX2() {
            return x2;
        }

        public void setX2(Float x2) {
            this.x2 = x2;
        }

        public Float getY2() {
            return y2;
        }

        public void setY2(Float y2) {
            this.y2 = y2;
        }
    }
}
