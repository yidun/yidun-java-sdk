/*
 * @(#) LabelQueryInfo.java 2023-03-14
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.label.query.response;

import java.util.List;

/**
 * @author zhuliyang02
 * @version 2023-03-14
 */
public class LabelQueryInfo {

    private Integer label;
    private String name;
    private List<SubLabel> subLabels;

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubLabel> getSubLabels() {
        return subLabels;
    }

    public void setSubLabels(List<SubLabel> subLabels) {
        this.subLabels = subLabels;
    }
}
