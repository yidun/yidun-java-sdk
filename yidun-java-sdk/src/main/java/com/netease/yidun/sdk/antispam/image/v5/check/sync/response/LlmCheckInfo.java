/*
 * @(#) LlmCheckInfo.java 2025-12-17
 *
 * Copyright 2025 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;

/**
 * @author admin
 * @version 2025-12-17
 */
public class LlmCheckInfo implements Serializable {
    private static final long serialVersionUID = -8325642804450466691L;
    /**
     * 模型识别结果
     */
    private String label;
    /**
     * 图片explain
     */
    private String explain;
    /**
     * 分数
     */
    private Float rate;
    /**
     * 大模型标识
     */
    private String modelIdentifier;


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
    public Float getRate() {
        return rate;
    }
    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getModelIdentifier() {
        return modelIdentifier;
    }

    public void setModelIdentifier(String modelIdentifier) {
        this.modelIdentifier = modelIdentifier;
    }

    @Override
    public String toString() {
        return "LlmCheckInfo{" +
                "label='" + label + '\'' +
                ", explain='" + explain + '\'' +
                ", rate=" + rate +
                ", modelIdentifier='" + modelIdentifier + '\'' +
                '}';
    }
}
