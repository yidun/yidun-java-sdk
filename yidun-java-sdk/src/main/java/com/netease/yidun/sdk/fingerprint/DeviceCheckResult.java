/*
 * @(#) DeviceCheckResult.java 2022-05-10
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.fingerprint;


/**
 * 风险检测结果
 */
public class DeviceCheckResult {

    /**
     * 是否为篡改请求，0为正常
     */
    private Integer isTampered;

    /**
     * 是否为模拟器，0为正常
     */
    private Integer isSimulator;

    /**
     * 是否root，0为正常
     */
    private Integer isRooted;

    /**
     * 是否多开，0为正常
     */
    private Integer isMultiRun;

    /**
     * 是否使用vpn，0为正常
     */
    private Integer isVpn;

    /**
     * 是否使用代理，0为正常
     */
    private Integer isProxy;

    /**
     * 是否存在hook，0为正常
     */
    private Integer isHooked;

    /**
     * 是否存在注入，0为正常
     */
    private Integer isInjected;

    /**
     * 是否在调试，0为正常
     */
    private Integer isDebugged;

    /**
     * 是否安装xposed， 0未安装
     */
    private Integer isXposed;

    /**
     * 云真机检测，大于0表示云手机
     */
    private Integer isCloud;

    /**
     * 疑似云手机，大于0表示疑似云手机
     */
    private Integer isSuspectCloud;

    /**
     * 是否是改机rom，0为正常
     */
    private Integer isRiskRom;

    /**
     * 是否是虚拟机，0为正常
     */
    private Integer isVm;

    /**
     * 是否是改机，0为正常
     */
    private Integer isModify;

    /**
     * 是否安装有改机类工具，0为没有安装
     */
    private Integer isModifyApp;

    /**
     * 是否是刷机，0为正常
     */
    private Integer isFlash;

    /**
     * 是否安装有点击工具，0为没有安装
     */
    private Integer isAutoTouch;

    /**
     * 是否安装有群控类应用，0为没有安装
     */
    private Integer isControlApp;

    /**
     * 脚本工具
     */
    private Integer isScript;

    /**
     * 安全评分
     */
    private Integer securityScore;

    /**
     * CydiaSubstrate
     */
    private Integer isCydiaSubstrate;

    /**
     * m1
     */
    private Integer isM1;

    /**
     * 加速器
     */
    private Integer isSpeedUp;

    /**
     * 反越狱插件
     */
    private Integer isAntiJailbreak;


    public Integer getIsTampered() {
        return isTampered;
    }

    public void setIsTampered(Integer isTampered) {
        this.isTampered = isTampered;
    }

    public Integer getIsSimulator() {
        return isSimulator;
    }

    public void setIsSimulator(Integer isSimulator) {
        this.isSimulator = isSimulator;
    }

    public Integer getIsRooted() {
        return isRooted;
    }

    public void setIsRooted(Integer isRooted) {
        this.isRooted = isRooted;
    }

    public Integer getIsMultiRun() {
        return isMultiRun;
    }

    public void setIsMultiRun(Integer isMultiRun) {
        this.isMultiRun = isMultiRun;
    }

    public Integer getIsVpn() {
        return isVpn;
    }

    public void setIsVpn(Integer isVpn) {
        this.isVpn = isVpn;
    }

    public Integer getIsProxy() {
        return isProxy;
    }

    public void setIsProxy(Integer isProxy) {
        this.isProxy = isProxy;
    }

    public Integer getIsHooked() {
        return isHooked;
    }

    public void setIsHooked(Integer isHooked) {
        this.isHooked = isHooked;
    }

    public Integer getIsInjected() {
        return isInjected;
    }

    public void setIsInjected(Integer isInjected) {
        this.isInjected = isInjected;
    }

    public Integer getIsDebugged() {
        return isDebugged;
    }

    public void setIsDebugged(Integer isDebugged) {
        this.isDebugged = isDebugged;
    }

    public Integer getIsXposed() {
        return isXposed;
    }

    public void setIsXposed(Integer isXposed) {
        this.isXposed = isXposed;
    }

    public Integer getIsCloud() {
        return isCloud;
    }

    public void setIsCloud(Integer isCloud) {
        this.isCloud = isCloud;
    }

    public Integer getIsSuspectCloud() {
        return isSuspectCloud;
    }

    public void setIsSuspectCloud(Integer isSuspectCloud) {
        this.isSuspectCloud = isSuspectCloud;
    }

    public Integer getIsRiskRom() {
        return isRiskRom;
    }

    public void setIsRiskRom(Integer isRiskRom) {
        this.isRiskRom = isRiskRom;
    }

    public Integer getIsVm() {
        return isVm;
    }

    public void setIsVm(Integer isVm) {
        this.isVm = isVm;
    }

    public Integer getIsModify() {
        return isModify;
    }

    public void setIsModify(Integer isModify) {
        this.isModify = isModify;
    }

    public Integer getIsModifyApp() {
        return isModifyApp;
    }

    public void setIsModifyApp(Integer isModifyApp) {
        this.isModifyApp = isModifyApp;
    }

    public Integer getIsFlash() {
        return isFlash;
    }

    public void setIsFlash(Integer isFlash) {
        this.isFlash = isFlash;
    }

    public Integer getIsAutoTouch() {
        return isAutoTouch;
    }

    public void setIsAutoTouch(Integer isAutoTouch) {
        this.isAutoTouch = isAutoTouch;
    }

    public Integer getIsControlApp() {
        return isControlApp;
    }

    public void setIsControlApp(Integer isControlApp) {
        this.isControlApp = isControlApp;
    }

    public Integer getIsScript() {
        return isScript;
    }

    public void setIsScript(Integer isScript) {
        this.isScript = isScript;
    }

    public Integer getSecurityScore() {
        return securityScore;
    }

    public void setSecurityScore(Integer securityScore) {
        this.securityScore = securityScore;
    }

    public Integer getIsCydiaSubstrate() {
        return isCydiaSubstrate;
    }

    public void setIsCydiaSubstrate(Integer isCydiaSubstrate) {
        this.isCydiaSubstrate = isCydiaSubstrate;
    }

    public Integer getIsM1() {
        return isM1;
    }

    public void setIsM1(Integer isM1) {
        this.isM1 = isM1;
    }

    public Integer getIsSpeedUp() {
        return isSpeedUp;
    }

    public void setIsSpeedUp(Integer isSpeedUp) {
        this.isSpeedUp = isSpeedUp;
    }

    public Integer getIsAntiJailbreak() {
        return isAntiJailbreak;
    }

    public void setIsAntiJailbreak(Integer isAntiJailbreak) {
        this.isAntiJailbreak = isAntiJailbreak;
    }

    @Override
    public String toString() {
        return "DeviceCheckResult(" +
                "isTampered=" + isTampered +
                ", isSimulator=" + isSimulator +
                ", isRooted=" + isRooted +
                ", isMultiRun=" + isMultiRun +
                ", isVpn=" + isVpn +
                ", isProxy=" + isProxy +
                ", isHooked=" + isHooked +
                ", isInjected=" + isInjected +
                ", isDebugged=" + isDebugged +
                ", isXposed=" + isXposed +
                ", isCloud=" + isCloud +
                ", isSuspectCloud=" + isSuspectCloud +
                ", isRiskRom=" + isRiskRom +
                ", isVm=" + isVm +
                ", isModify=" + isModify +
                ", isModifyApp=" + isModifyApp +
                ", isFlash=" + isFlash +
                ", isAutoTouch=" + isAutoTouch +
                ", isControlApp=" + isControlApp +
                ", isScript=" + isScript +
                ", securityScore=" + securityScore +
                ", isCydiaSubstrate=" + isCydiaSubstrate +
                ", isM1=" + isM1 +
                ", isSpeedUp=" + isSpeedUp +
                ", isAntiJailbreak=" + isAntiJailbreak +
                ')';
    }
}
