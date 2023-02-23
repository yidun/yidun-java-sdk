/*
 * @(#) PhoneInfo.java 2023-02-23
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.auth.idlephone.v1;

/**
 * 查询的手机号信息
 */
public class PhoneInfo {

    /**
     * 手机号，仅支持国内号码，11位
     */
    private String mobile;

    /**
     * 手机号所属区域
     */
    private String area;

    /**
     * 手机号运营商类型。
     */
    private String numberType;

    /**
     * 检测结果
     */
    private String status;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumberType() {
        return numberType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PhoneInfo(" +
                "mobile=" + mobile +
                ", area=" + area +
                ", numberType=" + numberType +
                ", status=" + status +
                ")";
    }
}
