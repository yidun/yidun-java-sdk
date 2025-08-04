package com.netease.yidun.sdk.irisk.v6.detail;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.BizPostJsonRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import java.util.Map;

/**
 * @author wuhanyu@corp.netease.com
 * @version 2024/2/2
 */
public class IRiskDetailV6Request extends BizPostJsonRequest<IRiskDetailV6Response> {
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
     * 用户/玩家的账号集合(转成JSON后的字符串)
     */
    private String accounts;

    /**
     * 用户/玩家的角色ID
     */
    private String roleId;

    /**
     * 用户/玩家的角色ID集合(转成JSON后的字符串)
     */
    private String roleIds;

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
     * 服务端ip
     */
    private String ip;
    /**
     * 服务端ip集合(转成JSON后的字符串)
     */
    private String ips;
    /**
     * 服务端sdkIp
     */
    private String sdkIp;
    /**
     * sdkIp集合(转成JSON后的字符串)
     */
    private String sdkIps;
    /**
     * 命中的风险标签
     */
    private String matchedRiskTags;
    /**
     * 命中的风险标签类型
     */
    private String matchedTypes;
    /**
     * 游戏版本
     */
    private String gameVersion;
    /**
     * 资源版本
     */
    private String assetVersion;
    /**
     * 服务器ID
     */
    private String serverId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * 签名V1
     */
    private String signV1;
    /**
     * 签名V2
     */
    private String signV2;

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

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
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

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getSdkIp() {
        return sdkIp;
    }

    public void setSdkIp(String sdkIp) {
        this.sdkIp = sdkIp;
    }

    public String getSdkIps() {
        return sdkIps;
    }

    public void setSdkIps(String sdkIps) {
        this.sdkIps = sdkIps;
    }

    public String getMatchedRiskTags() {
        return matchedRiskTags;
    }

    public void setMatchedRiskTags(String matchedRiskTags) {
        this.matchedRiskTags = matchedRiskTags;
    }

    public String getMatchedTypes() {
        return matchedTypes;
    }

    public void setMatchedTypes(String matchedTypes) {
        this.matchedTypes = matchedTypes;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    public String getAssetVersion() {
        return assetVersion;
    }

    public void setAssetVersion(String assetVersion) {
        this.assetVersion = assetVersion;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSignV1() {
        return signV1;
    }

    public void setSignV1(String signV1) {
        this.signV1 = signV1;
    }

    public String getSignV2() {
        return signV2;
    }

    public void setSignV2(String signV2) {
        this.signV2 = signV2;
    }

    @Override
    public Class<IRiskDetailV6Response> getResponseClass() {
        return IRiskDetailV6Response.class;
    }

    public IRiskDetailV6Request(String businessId) {
        productCode = "irisk";
        version = "600";
        uriPattern = "/v6/risk/detail";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("beginTimestamp", String.valueOf(beginTimestamp));
        customSignParams.put("endTimestamp", String.valueOf(endTimestamp));
        customSignParams.put("startFlag", startFlag);
        customSignParams.put("account", account);
        customSignParams.put("accounts", accounts);
        customSignParams.put("roleId", roleId);
        customSignParams.put("roleIds", roleIds);
        if (riskLevel != null) {
            customSignParams.put("riskLevel", String.valueOf(riskLevel));
        }
        customSignParams.put("packageName", packageName);
        customSignParams.put("appVersion", appVersion);
        customSignParams.put("ip", ip);
        customSignParams.put("ips", ips);
        customSignParams.put("sdkIp", sdkIp);
        customSignParams.put("sdkIps", sdkIps);
        customSignParams.put("matchedRiskTags", matchedRiskTags);
        customSignParams.put("matchedTypes", matchedTypes);
        customSignParams.put("gameVersion", gameVersion);
        customSignParams.put("assetVersion", assetVersion);
        customSignParams.put("serverId", serverId);
        customSignParams.put("nickname", nickname);
        customSignParams.put("deviceId", deviceId);
        customSignParams.put("signV1", signV1);
        customSignParams.put("signV2", signV2);
        return customSignParams;
    }
}
