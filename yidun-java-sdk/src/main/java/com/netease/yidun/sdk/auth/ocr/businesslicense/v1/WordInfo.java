package com.netease.yidun.sdk.auth.ocr.businesslicense.v1;

/**
 * OCR所得文字信息
 */
public class WordInfo {

    /** 识别结果字符串 */
    private String words;

    /** 文字所在坐标信息 */
    private Location location;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "WordInfo(" +
                ", words=" + words +
                "location=" + location +
                ")";
    }

    public static class Location {

        /** 表示定位位置的长方形左上顶点的垂直坐标 */
        private int top;

        /** 表示定位位置的长方形左上顶点的水平坐标 */
        private int left;

        /** 表示定位位置的长方形的宽度 */
        private int width;

        /** 表示定位位置的长方形的高度 */
        private int height;

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "Location(" +
                    "top=" + top +
                    ", left=" + left +
                    ", width=" + width +
                    ", height=" + height +
                    ")";
        }
    }
}
