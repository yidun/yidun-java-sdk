package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;
import java.util.List;

public class ImageV5LabelDetail implements Serializable {
    private static final long serialVersionUID = -4440650787738192711L;
    /**
     * 对外的图片label {@link com.netease.yidun.sdk.antispam.enums.LabelEnum}
     */
    private int label;
    /**
     * 判断结果，{@link com.netease.yidun.sdk.antispam.enums.LevelEnum}
     */
    private int level;
    /**
     * 得分，范围为0到1
     */
    private float rate;
    /**
     * 各个类别检测结果
     */
    private List<ImageV5SubLabelDetail> subLabels;

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public List<ImageV5SubLabelDetail> getSubLabels() {
        return subLabels;
    }

    public void setSubLabels(List<ImageV5SubLabelDetail> subLabels) {
        this.subLabels = subLabels;
    }
}
