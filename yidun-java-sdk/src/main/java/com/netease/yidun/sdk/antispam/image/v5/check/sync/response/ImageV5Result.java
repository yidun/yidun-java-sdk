package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class ImageV5Result implements Serializable {
    private static final long serialVersionUID = -8325642804450472491L;
    /**
     * 反垃圾结果
     */
    private ImageV5AntispamResp antispam;
    /**
     * ocr结果
     */
    private ImageV5OcrResp ocr;
    /**
     * 人脸结果
     */
    private ImageV5FaceResp face;
    /**
     * 图片质量结果
     */
    private ImageV5QualityResp quality;
    /**
     * 图片logo结果
     */
    private ImageV5LogoResp logo;
    /**
     * 图片识别结果
     */
    private ImageV5DiscernResp discern;
    /**
     * 用户画像结果
     */
    private ImageV5UserRiskResp userRisk;
    /**
     * 反作弊结果
     */
    private ImageAnticheatV5Resp anticheat;

    public ImageV5AntispamResp getAntispam() {
        return antispam;
    }

    public void setAntispam(ImageV5AntispamResp antispam) {
        this.antispam = antispam;
    }

    public ImageV5OcrResp getOcr() {
        return ocr;
    }

    public void setOcr(ImageV5OcrResp ocr) {
        this.ocr = ocr;
    }

    public ImageV5FaceResp getFace() {
        return face;
    }

    public void setFace(ImageV5FaceResp face) {
        this.face = face;
    }

    public ImageV5QualityResp getQuality() {
        return quality;
    }

    public void setQuality(ImageV5QualityResp quality) {
        this.quality = quality;
    }

    public ImageV5LogoResp getLogo() {
        return logo;
    }

    public void setLogo(ImageV5LogoResp logo) {
        this.logo = logo;
    }

    public ImageV5DiscernResp getDiscern() {
        return discern;
    }

    public void setDiscern(ImageV5DiscernResp discern) {
        this.discern = discern;
    }

    public ImageV5UserRiskResp getUserRisk() {
        return userRisk;
    }

    public void setUserRisk(ImageV5UserRiskResp userRisk) {
        this.userRisk = userRisk;
    }

    public ImageAnticheatV5Resp getAnticheat() {
        return anticheat;
    }

    public void setAnticheat(ImageAnticheatV5Resp anticheat) {
        this.anticheat = anticheat;
    }
}
