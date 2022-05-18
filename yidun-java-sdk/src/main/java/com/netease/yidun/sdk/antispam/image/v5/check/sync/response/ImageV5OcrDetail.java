package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;
import java.util.List;

public class ImageV5OcrDetail implements Serializable {
    private static final long serialVersionUID = -3301990969056584719L;
    /**
     * ocr文本
     */
    private String content;
    /**
     * ocr文本详情
     */
    private List<OcrLineContent> lineContents;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<OcrLineContent> getLineContents() {
        return lineContents;
    }

    public void setLineContents(List<OcrLineContent> lineContents) {
        this.lineContents = lineContents;
    }

    public static class OcrLineContent implements Serializable {
        private static final long serialVersionUID = 4074114561576709085L;
        /**
         * 行ocr文本
         */
        private String lineContent;
        /**
         * 相对坐标
         */
        private Float x1;
        private Float y1;
        private Float x2;
        private Float y2;
        /**
         * 语种信息
         */
        private String lang;

        public String getLineContent() {
            return lineContent;
        }

        public void setLineContent(String lineContent) {
            this.lineContent = lineContent;
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

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }
    }
}
