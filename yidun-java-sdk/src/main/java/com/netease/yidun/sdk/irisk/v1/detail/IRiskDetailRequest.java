package com.netease.yidun.sdk.irisk.v1.detail;

import com.netease.yidun.sdk.core.request.BizPostJsonRequest;

import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import java.util.Map;

public class IRiskDetailRequest extends BizPostJsonRequest<IRiskDetailResponse> {

    /**
     * 开始时间戳，单位： ms, 不能小于30天前
     */
    @NotNull(message = "beginTimestamp不能为空")
    private Long beginTimestamp;

    /**
     * 结束时间戳，单位： ms, 结束时间戳与开始时间戳的时间间隔不能大于30天
     */
    @NotNull(message = "endTimestamp不能为空")
    private Long endTimestamp;

    /**
     * 用于分页查询的关联标记。第一次查询时，该字段填充空字符串""或不传该字段均可，后续查询时，需要判断上一次查询的返回数据中startFlag值，如果startFlag不为空字符串""，表示需要分页查询。
     * 当使用分页查询时，startFlag字段使用上一次返回值填充，其他字段保持不变，继续调用查询接口。
     * 如果startFlag为空字符串""，例如返回数据为{"code": 200, "msg": "ok", "data": {"size": 100, "startFlag": "", "detail": [{},...]}}，表示不需要分页查询，可以使用新的时间条件查询。
     */
    private String startFlag;

    /**
     * 用户/玩家的账号
     */
    private String account;

    /**
     * 用户/玩家的角色ID
     */
    private String roleId;

    /**
     * 风险等级，1-高风险，2-中风险，3-低风险
     */
    private Integer riskLevel;

    /**
     * 包名
     */
    private String packageName;

    /**
     * app版本
     */
    private String appVersion;

    /**
     * ip地址
     */
    private String ip;

    public IRiskDetailRequest(String businessId) {
        productCode = "irisk";
        version = "400";
        uriPattern = "/v5/risk/detail";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("beginTimestamp", String.valueOf(beginTimestamp));
        customSignParams.put("endTimestamp", String.valueOf(endTimestamp));
        customSignParams.put("startFlag", startFlag);
        customSignParams.put("account", account);
        customSignParams.put("roleId", roleId);
        if (riskLevel != null) {
            customSignParams.put("riskLevel", String.valueOf(riskLevel));
        }
        customSignParams.put("packageName", packageName);
        customSignParams.put("appVersion", appVersion);
        customSignParams.put("ip", ip);
        return customSignParams;
    }

    @Override
    public Class<IRiskDetailResponse> getResponseClass() {
        return IRiskDetailResponse.class;
    }

    public Long getBeginTimestamp() {
        return beginTimestamp;
    }

    public void setBeginTimestamp(Long beginTimestamp) {
        this.beginTimestamp = beginTimestamp;
    }

    public Long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public String getStartFlag() {
        return startFlag;
    }

    public void setStartFlag(String startFlag) {
        this.startFlag = startFlag;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public IRiskDetailRequest beginTimestamp(Long beginTimestamp) {
        this.beginTimestamp = beginTimestamp;
        return this;
    }

    public IRiskDetailRequest endTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
        return this;
    }

    public IRiskDetailRequest startFlag(String startFlag) {
        this.startFlag = startFlag;
        return this;
    }

    public IRiskDetailRequest account(String account) {
        this.account = account;
        return this;
    }

    public IRiskDetailRequest roleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public IRiskDetailRequest riskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
        return this;
    }

    public IRiskDetailRequest packageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public IRiskDetailRequest appVersion(String appVersion) {
        this.appVersion = appVersion;
        return this;
    }

    public IRiskDetailRequest ip(String ip) {
        this.ip = ip;
        return this;
    }

    @Override
    public String toString() {
        return "IRiskDetailRequest(" +
                "super=" + super.toString() +
                ", beginTimestamp=" + beginTimestamp +
                ", endTimestamp=" + endTimestamp +
                ", startFlag=" + startFlag +
                ", account=" + account +
                ", roleId=" + roleId +
                ", riskLevel=" + riskLevel +
                ", packageName=" + packageName +
                ", appVersion=" + appVersion +
                ", ip=" + ip +
                ")";
    }

}
