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
    /**
     * 大模型识别子标签
     */
    private String subLabel;
    /**
     * 大模型命中关键词
     */
    private String keyword;
    /**
     * 大模型自定义扩展字段，JSON字符串格式
     */
    private String extension;
    /**
     * 大模型检测状态1：成功，2：失败
     */
    private Integer llmStatus;
    /**
     * 对应大模型服务返回的errorCode字段
     */
    private Integer llmFailureReason;


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

    public String getSubLabel() {
        return subLabel;
    }

    public void setSubLabel(String subLabel) {
        this.subLabel = subLabel;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Integer getLlmStatus() {
        return llmStatus;
    }

    public void setLlmStatus(Integer llmStatus) {
        this.llmStatus = llmStatus;
    }

    public Integer getLlmFailureReason() {
        return llmFailureReason;
    }

    public void setLlmFailureReason(Integer llmFailureReason) {
        this.llmFailureReason = llmFailureReason;
    }

    @Override
    public String toString() {
        return "LlmCheckInfo{" +
                "label='" + label + '\'' +
                ", explain='" + explain + '\'' +
                ", rate=" + rate +
                ", modelIdentifier='" + modelIdentifier + '\'' +
                ", subLabel='" + subLabel + '\'' +
                ", keyword='" + keyword + '\'' +
                ", extension='" + extension + '\'' +
                ", llmStatus=" + llmStatus +
                ", llmFailureReason=" + llmFailureReason +
                '}';
    }
}
