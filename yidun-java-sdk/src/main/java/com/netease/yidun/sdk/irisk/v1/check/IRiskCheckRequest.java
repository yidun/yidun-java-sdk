package com.netease.yidun.sdk.irisk.v1.check;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import javax.validation.constraints.NotBlank;
import java.util.Map;

public class IRiskCheckRequest extends BizPostFormRequest<IRiskCheckResponse> {

    /**
     * 风控SDK上报的数据后回参获取到的 token，应用方需要从智能风控客户端SDK获取该数据。详情请查看客户端接入文档。
     */
    @NotBlank
    private String token;

    /**
     * 用户/ 玩家的IP，或当前客户端业务事件发生时的公网IP地址（ipv4）
     */
    @NotBlank
    private String ip;

    /**
     * 用户/玩家的角色 ID，非游戏类型应用，roleId 可以与 roleAccount 相同
     */
    private String roleId;

    /**
     * 用户/玩家的角色名称，非游戏类型应用，roleName 可以是当前用户昵称相同
     */
    private String roleName;

    /**
     * 用户/玩家的角色的服务器名称
     */
    private String roleServer;

    /**
     * 用户/玩家的账号
     */
    private String account;

    /**
     * 用户用于登录的手机号码或者关联的手机号码，默认国内手机号。
     * 如有海外手机，需包含国家地区代码，格式为“+447410xxx186（+44即为国家码）”。
     * 如果需要加密，支持传入hash值，hash算法：md5(phone)
     */
    private String phone;

    /**
     * 活动的唯一标识，用于标记场景下的细分类别，如：注册-自主注册、注册-受邀请注册；再如：登录- app登录、登录-web登录等
     */
    private String activityId;

    /**
     * 活动操作的目标，比如：A给B点赞，则target为B。如果target是手机号或邮箱，请提供hash值，hash算法：md5(target)。如没有，可传空
     */
    private String target;

    /**
     * 用户的邮箱，如果需要加密，支持传入hash值，hash算法：md5(email)
     */
    private String email;

    /**
     * 用户的注册时间，单位：毫秒
     */
    private Long registerTime;

    /**
     * 用户的注册IP
     */
    private String registerIp;

    /**
     * 用户/玩家的等级
     */
    private String roleLevel;

    /**
     * 游戏类型应用的版本号
     */
    private String gameVersion;

    /**
     * 游戏类型应用的资源版本号
     */
    private String assetVersion;

    /**
     * 额外/拓展的信息，应用 / 游戏方可以自己构建json结构，最大长度：2048。不同场景构建信息见分场景extData接入说明
     */
    private String extData;

    public IRiskCheckRequest(String businessId) {
        domain = "ir-open.dun.163.com";
        productCode = "irisk";
        version = "400";
        uriPattern = "/v5/risk/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("token", token);
        customSignParams.put("ip", ip);
        customSignParams.put("roleId", roleId);
        customSignParams.put("roleName", roleName);
        customSignParams.put("roleServer", roleServer);
        customSignParams.put("account", account);
        customSignParams.put("phone", phone);
        customSignParams.put("activityId", activityId);
        customSignParams.put("target", target);
        customSignParams.put("email", email);
        if (registerTime != null) {
            customSignParams.put("registerTime", String.valueOf(registerTime));
        }
        customSignParams.put("registerIp", registerIp);
        customSignParams.put("roleLevel", roleLevel);
        customSignParams.put("gameVersion", gameVersion);
        customSignParams.put("assetVersion", assetVersion);
        customSignParams.put("extData", extData);
        return customSignParams;
    }

    @Override
    public Class<IRiskCheckResponse> getResponseClass() {
        return IRiskCheckResponse.class;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleServer() {
        return roleServer;
    }

    public void setRoleServer(String roleServer) {
        this.roleServer = roleServer;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
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

    public String getExtData() {
        return extData;
    }

    public void setExtData(String extData) {
        this.extData = extData;
    }


    public IRiskCheckRequest token(String token) {
        this.token = token;
        return this;
    }

    public IRiskCheckRequest ip(String ip) {
        this.ip = ip;
        return this;
    }

    public IRiskCheckRequest roleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public IRiskCheckRequest roleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public IRiskCheckRequest roleServer(String roleServer) {
        this.roleServer = roleServer;
        return this;
    }

    public IRiskCheckRequest account(String account) {
        this.account = account;
        return this;
    }

    public IRiskCheckRequest phone(String phone) {
        this.phone = phone;
        return this;
    }

    public IRiskCheckRequest activityId(String activityId) {
        this.activityId = activityId;
        return this;
    }

    public IRiskCheckRequest target(String target) {
        this.target = target;
        return this;
    }

    public IRiskCheckRequest email(String email) {
        this.email = email;
        return this;
    }

    public IRiskCheckRequest registerTime(Long registerTime) {
        this.registerTime = registerTime;
        return this;
    }

    public IRiskCheckRequest registerIp(String registerIp) {
        this.registerIp = registerIp;
        return this;
    }

    public IRiskCheckRequest roleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
        return this;
    }

    public IRiskCheckRequest gameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
        return this;
    }

    public IRiskCheckRequest assetVersion(String assetVersion) {
        this.assetVersion = assetVersion;
        return this;
    }

    public IRiskCheckRequest extData(String extData) {
        this.extData = extData;
        return this;
    }


    @Override
    public String toString() {
        return "IRiskCheckRequest(" +
                "super=" + super.toString() +
                ", token=" + token +
                ", ip=" + ip +
                ", roleId=" + roleId +
                ", roleName=" + roleName +
                ", roleServer=" + roleServer +
                ", account=" + account +
                ", phone=" + phone +
                ", activityId=" + activityId +
                ", target=" + target +
                ", email=" + email +
                ", registerTime=" + registerTime +
                ", registerIp=" + registerIp +
                ", roleLevel=" + roleLevel +
                ", gameVersion=" + gameVersion +
                ", assetVersion=" + assetVersion +
                ", extData=" + extData +
                ")";
    }

}
