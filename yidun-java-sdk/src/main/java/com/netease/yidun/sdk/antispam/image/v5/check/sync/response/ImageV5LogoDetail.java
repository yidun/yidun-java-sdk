package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;

public class ImageV5LogoDetail implements Serializable {
    private static final long serialVersionUID = -250717250523490063L;
    /**
     * logo信息
     */
    private String logoName;
    private Float x1;
    private Float y1;
    private Float x2;
    private Float y2;
    /**
     * 子标签分数
     */
    private Float rate;
    /**
     * logo大小占比
     */
    private String sizeRatio;

    public String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
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

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getSizeRatio() {
        return sizeRatio;
    }

    public void setSizeRatio(String sizeRatio) {
        this.sizeRatio = sizeRatio;
    }
}
