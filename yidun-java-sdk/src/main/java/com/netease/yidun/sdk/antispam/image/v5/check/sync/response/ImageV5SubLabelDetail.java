package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;
import java.util.List;

public class ImageV5SubLabelDetail implements Serializable {
    private static final long serialVersionUID = -5078938255178052538L;
    /**
     * 对外的图片label
     */
    private String subLabel;
    /**
     * 判断结果，0-正常，1-不确定，2-确定
     */
    private float rate;
    /**
     * 二级分类命中详情
     */
    private SubLabelDetails details;

    public String getSubLabel() {
        return subLabel;
    }

    public void setSubLabel(String subLabel) {
        this.subLabel = subLabel;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public SubLabelDetails getDetails() {
        return details;
    }

    public void setDetails(SubLabelDetails details) {
        this.details = details;
    }

    public static class SubLabelDetails implements Serializable {
        private static final long serialVersionUID = 6494335968771237451L;
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

        public List<AntispamInfo> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<AntispamInfo> keywords) {
            this.keywords = keywords;
        }

        public List<AntispamInfo> getLibInfos() {
            return libInfos;
        }

        public void setLibInfos(List<AntispamInfo> libInfos) {
            this.libInfos = libInfos;
        }

        public List<AntispamInfo> getHitInfos() {
            return hitInfos;
        }

        public void setHitInfos(List<AntispamInfo> hitInfos) {
            this.hitInfos = hitInfos;
        }

        public AnticheatInfo getAnticheat() {
            return anticheat;
        }

        public void setAnticheat(AnticheatInfo anticheat) {
            this.anticheat = anticheat;
        }
    }

    public static class AnticheatInfo implements Serializable {
        private static final long serialVersionUID = -7293935029976375265L;
        private Integer hitType;

        public Integer getHitType() {
            return hitType;
        }

        public void setHitType(Integer hitType) {
            this.hitType = hitType;
        }
    }

    public static class AntispamInfo implements Serializable {
        private static final long serialVersionUID = -7293935029976375265L;
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
