package com.netease.yidun.sdk.antispam.file.v2.callback.response;

import java.util.List;

/**
 * 音频标签详细信息
 */
public class VideoSubLabelDetail {

    /**
     * 反垃圾自定义敏感词结果
     */
    private List<VideoSubLabelKeyword> keywords;
    /**
     * 反垃圾自定义图片名单结果
     */
    private List<VideoSubLabelLibInfo> libInfos;
    /**
     * 反垃圾其他命中信息
     */
    private List<VideoSubLabelHitInfo> hitInfos;

    public List<VideoSubLabelKeyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<VideoSubLabelKeyword> keywords) {
        this.keywords = keywords;
    }

    public List<VideoSubLabelLibInfo> getLibInfos() {
        return libInfos;
    }

    public void setLibInfos(List<VideoSubLabelLibInfo> libInfos) {
        this.libInfos = libInfos;
    }

    public List<VideoSubLabelHitInfo> getHitInfos() {
        return hitInfos;
    }

    public void setHitInfos(List<VideoSubLabelHitInfo> hitInfos) {
        this.hitInfos = hitInfos;
    }

    @Override
    public String toString() {
        return "VideoSubLabelDetail{" +
                "keywords=" + keywords +
                ", libInfos=" + libInfos +
                ", hitInfos=" + hitInfos +
                '}';
    }

    public static class VideoSubLabelKeyword {
        /**
         * 自定义添加敏感词
         */
        private String word;

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

        @Override
        public String toString() {
            return "VideoSubLabelKeyword{" +
                    "word='" + word + '\'' +
                    ", x1=" + x1 +
                    ", y1=" + y1 +
                    ", x2=" + x2 +
                    ", y2=" + y2 +
                    '}';
        }
    }

    public static class VideoSubLabelLibInfo {
        /**
         * 该图片命中自定义图片名单对应原始添加的根源图片url
         */
        private String entity;
        /**
         * 历史针对该数据源图片命中所有次数
         */
        private Integer hitCount;
        private String value;
        private String group;

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

        @Override
        public String toString() {
            return "AudioSubLabelLibInfo{" +
                    "entity='" + entity + '\'' +
                    ", hitCount=" + hitCount +
                    ", value='" + value + '\'' +
                    ", group='" + group + '\'' +
                    '}';
        }
    }


    public static class VideoSubLabelHitInfo {
        private String value;
        private String group;
        /**
         * 坐标左上一个 右下一个
         */
        private Float x1;
        private Float y1;
        private Float x2;
        private Float y2;

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

        @Override
        public String toString() {
            return "AudioSubLabelHitInfo{" +
                    "value='" + value + '\'' +
                    ", group='" + group + '\'' +
                    ", x1=" + x1 +
                    ", y1=" + y1 +
                    ", x2=" + x2 +
                    ", y2=" + y2 +
                    '}';
        }
    }
}
