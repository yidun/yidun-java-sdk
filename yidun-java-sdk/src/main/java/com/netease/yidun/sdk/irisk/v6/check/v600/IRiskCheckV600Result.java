package com.netease.yidun.sdk.irisk.v6.check.v600;

import java.util.List;

import com.netease.yidun.sdk.irisk.v6.check.abst.AbstractHitInfo;

public class IRiskCheckV600Result<H extends AbstractHitInfo> {

    /**
     * 风险等级：0 正常，1 高风险，2 中风险，3 低风险。 风险等级只会返回一个，取本次命中的最高风险等级，
     */
    private Integer riskLevel;

    /**
     * 命中风险信息
     */
    private List<H> hitInfos;

    /**
     * 检测任务 ID，建议记录存储，便于后续数据查询验证。
     */
    private String taskId;

    /**
     * 风控检测结果加密数据，应用/游戏方可转交给风控 sdk 解析处理。
     */
    private String sdkRespData;

    /**
     * 购买设备指纹功能后，check结果中才会包含deviceId。
     */
    private String deviceId;

    /**
     * 设备信息
     */
    private Object deviceInfo;

    /**
     * 命中规则
     */
    private List<String> matchedRules;

    /**
     * 命中自定义规则
     */
    private List<String> matchedCustomRules;

    /**
     * 证据信息
     */
    private List<String> evidences;

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public List<H> getHitInfos() {
        return hitInfos;
    }

    public void setHitInfos(List<H> hitInfos) {
        this.hitInfos = hitInfos;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getSdkRespData() {
        return sdkRespData;
    }

    public void setSdkRespData(String sdkRespData) {
        this.sdkRespData = sdkRespData;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Object getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(Object deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public List<String> getMatchedRules() {
        return matchedRules;
    }

    public void setMatchedRules(List<String> matchedRules) {
        this.matchedRules = matchedRules;
    }

    public List<String> getMatchedCustomRules() {
        return matchedCustomRules;
    }

    public void setMatchedCustomRules(List<String> matchedCustomRules) {
        this.matchedCustomRules = matchedCustomRules;
    }

    public List<String> getEvidences() {
        return evidences;
    }

    public void setEvidences(List<String> evidences) {
        this.evidences = evidences;
    }

    @Override
    public String toString() {
        return "IRiskCheckV600Result{" +
                "riskLevel=" + riskLevel +
                ", hitInfos=" + hitInfos +
                ", taskId='" + taskId + '\'' +
                ", sdkRespData='" + sdkRespData + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceInfo=" + deviceInfo +
                ", matchedRules=" + matchedRules +
                ", matchedCustomRules=" + matchedCustomRules +
                ", evidences=" + evidences +
                '}';
    }
}
