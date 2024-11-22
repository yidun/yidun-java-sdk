package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;

public class ImageV5QualityDetail implements Serializable {
    private static final long serialVersionUID = -469818616102685197L;
    /**
     * 美观度分数
     */
    private Float aestheticsRate;
    /**
     * 清晰度分数
     */
    private Float sharpnessRate;
    /**
     * 分屏重复分数
     */
    private Float similarityScore;
    /**
     * true表示分屏重复分数
     */
    private Boolean similarityImage;
    /**
     * 图片基本信息
     */
    private MetaInfo metaInfo;
    /**
     * 图片边框信息
     */
    private BoarderInfo boarderInfo;
    /**
     * 背景信息
     */
    private BackgroundInfo backgroundInfo;
    /**
     * 毛玻璃边框信息
     */
    private GlassmorphismBoarderInfo glassmorphismBoarderInfo;
    /**
     * 图片灰度值
     */
    private Integer grayValue;
    public GlassmorphismBoarderInfo getGlassmorphismBoarderInfo() {
        return glassmorphismBoarderInfo;
    }
    public void setGrayValue(GlassmorphismBoarderInfo glassmorphismBoarderInfo) {
        this.glassmorphismBoarderInfo = glassmorphismBoarderInfo;
    }
    public Integer getGrayValue() {
        return grayValue;
    }
    public void setGrayValue(Integer grayValue) {
        this.grayValue = grayValue;
    }
    public Float getSimilarityScore() {
        return similarityScore;
    }

    public void setSimilarityScore(Float similarityScore) {
        this.similarityScore = similarityScore;
    }

    public Boolean getSimilarityImage() {
        return similarityImage;
    }

    public void setSimilarityImage(Boolean similarityImage) {
        this.similarityImage = similarityImage;
    }

    public Float getAestheticsRate() {
        return aestheticsRate;
    }

    public void setAestheticsRate(Float aestheticsRate) {
        this.aestheticsRate = aestheticsRate;
    }

    public Float getSharpnessRate() {
        return sharpnessRate;
    }

    public void setSharpnessRate(Float sharpnessRate) {
        this.sharpnessRate = sharpnessRate;
    }

    public MetaInfo getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }

    public BoarderInfo getBoarderInfo() {
        return boarderInfo;
    }

    public void setBoarderInfo(BoarderInfo boarderInfo) {
        this.boarderInfo = boarderInfo;
    }

    public BackgroundInfo getBackgroundInfo() {
        return backgroundInfo;
    }

    public void setBackgroundInfo(BackgroundInfo backgroundInfo) {
        this.backgroundInfo = backgroundInfo;
    }

    public static class BackgroundInfo implements Serializable {
        private static final long serialVersionUID = 7026856830137401276L;
        private boolean pureBackground = false;

        public boolean isPureBackground() {
            return pureBackground;
        }

        public void setPureBackground(boolean pureBackground) {
            this.pureBackground = pureBackground;
        }
    }

    public static class BoarderColor implements Serializable {

        private static final long serialVersionUID = 4458873342676622865L;

        private Integer top;
        private Integer right;
        private Integer bottom;
        private Integer left;

        public Integer getTop() {
            return top;
        }

        public void setTop(Integer top) {
            this.top = top;
        }

        public Integer getRight() {
            return right;
        }

        public void setRight(Integer right) {
            this.right = right;
        }

        public Integer getBottom() {
            return bottom;
        }

        public void setBottom(Integer bottom) {
            this.bottom = bottom;
        }

        public Integer getLeft() {
            return left;
        }

        public void setLeft(Integer left) {
            this.left = left;
        }
    }

    public static class MetaInfo implements Serializable {
        private static final long serialVersionUID = -6683390533378310610L;
        private Long byteSize;
        private Integer height;
        private Integer width;
        private String format;
        /**
         * 是否有隐藏
         */
        private Boolean hidden;
        /**
         * 隐藏文件的格式
         */
        private String hiddenFormat;

        public Long getByteSize() {
            return byteSize;
        }

        public void setByteSize(Long byteSize) {
            this.byteSize = byteSize;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public Boolean getHidden() {
            return hidden;
        }

        public void setHidden(Boolean hidden) {
            this.hidden = hidden;
        }

        public String getHiddenFormat() {
            return hiddenFormat;
        }

        public void setHiddenFormat(String hiddenFormat) {
            this.hiddenFormat = hiddenFormat;
        }
    }

    public static class BoarderInfo implements Serializable {
        private static final long serialVersionUID = -9179971722295657691L;
        private Boolean hit;
        private Boolean top;
        private Boolean right;
        private Boolean bottom;
        private Boolean left;

        /**
         * 图片边框颜色
         */
        private BoarderColor color;

        public BoarderColor getColor() {
            return color;
        }

        public void setColor(BoarderColor color) {
            this.color = color;
        }

        public Boolean getHit() {
            return hit;
        }

        public void setHit(Boolean hit) {
            this.hit = hit;
        }

        public Boolean getTop() {
            return top;
        }

        public void setTop(Boolean top) {
            this.top = top;
        }

        public Boolean getRight() {
            return right;
        }

        public void setRight(Boolean right) {
            this.right = right;
        }

        public Boolean getBottom() {
            return bottom;
        }

        public void setBottom(Boolean bottom) {
            this.bottom = bottom;
        }

        public Boolean getLeft() {
            return left;
        }

        public void setLeft(Boolean left) {
            this.left = left;
        }
    }
    public static class GlassmorphismBoarderInfo implements Serializable {

        private static final long serialVersionUID = -3538216920124713028L;
        /**
         * 是否命中边框
         */
        private Boolean anyHit;

        private Boolean left;

        private Boolean right;

        private Boolean top;

        private Boolean bottom;

        public Boolean getAnyHit() {
            return anyHit;
        }

        public void setAnyHit(Boolean anyHit) {
            this.anyHit = anyHit;
        }

        public Boolean getLeft() {
            return left;
        }

        public void setLeft(Boolean left) {
            this.left = left;
        }

        public Boolean getTop() {
            return top;
        }

        public void setTop(Boolean top) {
            this.top = top;
        }

        public Boolean getRight() {
            return right;
        }

        public void setRight(Boolean right) {
            this.right = right;
        }

        public Boolean getBottom() {
            return bottom;
        }

        public void setBottom(Boolean bottom) {
            this.bottom = bottom;
        }
    }
}
