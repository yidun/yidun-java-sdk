/*
 * @(#) SubLabel.java 2020-04-02
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.label.query.response;


import java.util.List;
import java.util.Set;

public class SubLabel {

    private String businessId;

    private Set<Integer> businessType;

    private Long createTime;

    private String code;

    private Integer depth;

    private String name;

    private Integer type;

    private List<SubLabel> subLabels;


    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Set<Integer> getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Set<Integer> businessType) {
        this.businessType = businessType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<SubLabel> getSubLabels() {
        return subLabels;
    }

    public void setSubLabels(List<SubLabel> subLabels) {
        this.subLabels = subLabels;
    }
}
