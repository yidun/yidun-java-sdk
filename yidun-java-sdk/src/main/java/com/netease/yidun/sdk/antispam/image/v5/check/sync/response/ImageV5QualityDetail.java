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

    public static class MetaInfo implements Serializable {
        private static final long serialVersionUID = -6683390533378310610L;
        private Long byteSize;
        private Integer height;
        private Integer width;
        private String format;

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
    }

    public static class BoarderInfo implements Serializable {
        private static final long serialVersionUID = -9179971722295657691L;
        private Boolean hit;
        private Boolean top;
        private Boolean right;
        private Boolean bottom;
        private Boolean left;

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
}
