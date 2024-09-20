package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;

public class ImageV5DiscernDetail implements Serializable {
    private static final long serialVersionUID = 4340424076688152703L;
    /**
     * 识别物体类型 1 场景
     */
    private Integer type;
    /**
     * 识别名称
     */
    private String discernName;
    /**
     * 识别标识
     */
    private String discernKey;
    /**
     * 分数
     */
    private Float rate;
    /**
     * gpt返回label
     */
    private String label;
    /**
     * 图片explain
     */
    private String explain;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDiscernName() {
        return discernName;
    }

    public void setDiscernName(String discernName) {
        this.discernName = discernName;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getDiscernKey() {
        return discernKey;
    }

    public void setDiscernKey(String discernKey) {
        this.discernKey = discernKey;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
