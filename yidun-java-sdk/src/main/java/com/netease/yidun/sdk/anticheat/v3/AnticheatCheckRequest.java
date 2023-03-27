package com.netease.yidun.sdk.anticheat.v3;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 反作弊检测请求
 */
public class AnticheatCheckRequest extends BizPostFormRequest<AnticheatCheckResponse> {

    /**
     * 反作弊结果查询token，由业务前端页面提交给业务后端。非必选。最大长度：256
     */
    @Size(max = 256, message = "token最长256个字符")
    private String token;
    /**
     * 用户唯一标识，如果是手机号or邮箱，支持传入hash值，hash算法：md5(account)。非必选。最大长度：256
     */
    @Size(max = 256, message = "account最长256个字符")
    private String account;
    /**
     * 默认国内手机号。如有海外手机，需包含国家地区代码，格式为“+447410xxx186（+44即为国家码）”。如果需要加密，支持传入hash值，hash算法：md5(phone)。非必选。最大长度：64
     */
    @Size(max = 64, message = "phone最长64个字符")
    private String phone;
    /**
     * 用户参加活动时的ip。非必选。最大长度：20
     */
    @Size(max = 20, message = "ip最长20个字符")
    private String ip;
    /**
     * 用户的邮箱，如果需要加密，支持传入hash值，hash算法：md5(email)。非必选。最大长度：64
     */
    @Size(max = 64, message = "email最长64个字符")
    private String email;
    /**
     * 用户的注册时间，单位：毫秒。非必选。最大位数：13
     */
    private Long registerTime;
    /**
     * 用户的注册IP。非必选。最大长度：20
     */
    @Size(max = 20, message = "registerIp最长20个字符")
    private String registerIp;
    /**
     * 用户的昵称。非必选。最大长度：256
     */
    @Size(max = 256, message = "nickname最长256个字符")
    private String nickname;
    /**
     * 用户的等级。非必选。最大长度：32
     */
    @Size(max = 32, message = "userLevel最长32个字符")
    private String userLevel;
    /**
     * 活动的唯一标识。非必选。最大长度：256
     */
    @Size(max = 256, message = "activityId最长256个字符")
    private String activityId;
    /**
     * 活动操作的目标，比如：A给B点赞，则target为B。如果target是手机号或邮箱，请提供hash值，hash算法：md5(target)。非必选。最大长度：256
     */
    @Size(max = 256, message = "target最长256个字符")
    private String target;
    /**
     * 额外信息，建议自己构造json结构。非必选。最大长度：2048
     */
    @Size(max = 2048, message = "extData最长2048个字符")
    private String extData;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String token() {
        return token;
    }

    public AnticheatCheckRequest token(String token) {
        this.token = token;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String account() {
        return account;
    }

    public AnticheatCheckRequest account(String account) {
        this.account = account;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String phone() {
        return phone;
    }

    public AnticheatCheckRequest phone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String ip() {
        return ip;
    }

    public AnticheatCheckRequest ip(String ip) {
        this.ip = ip;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String email() {
        return email;
    }

    public AnticheatCheckRequest email(String email) {
        this.email = email;
        return this;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Long registerTime() {
        return registerTime;
    }

    public AnticheatCheckRequest registerTime(Long registerTime) {
        this.registerTime = registerTime;
        return this;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String registerIp() {
        return registerIp;
    }

    public AnticheatCheckRequest registerIp(String registerIp) {
        this.registerIp = registerIp;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String nickname() {
        return nickname;
    }

    public AnticheatCheckRequest nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String userLevel() {
        return userLevel;
    }

    public AnticheatCheckRequest userLevel(String userLevel) {
        this.userLevel = userLevel;
        return this;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String activityId() {
        return activityId;
    }

    public AnticheatCheckRequest activityId(String activityId) {
        this.activityId = activityId;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String target() {
        return target;
    }

    public AnticheatCheckRequest target(String target) {
        this.target = target;
        return this;
    }

    public String getExtData() {
        return extData;
    }

    public void setExtData(String extData) {
        this.extData = extData;
    }

    public String extData() {
        return extData;
    }

    public AnticheatCheckRequest extData(String extData) {
        this.extData = extData;
        return this;
    }

    public AnticheatCheckRequest(String businessId) {
        productCode = "anticheat";
        version = "300";
        uriPattern = "/v3/common/check";
        this.businessId = businessId;
    }

    @Override
    public Class<AnticheatCheckResponse> getResponseClass() {
        return AnticheatCheckResponse.class;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("token", token);
        params.put("account", account);
        params.put("email", email);
        params.put("phone", phone);
        params.put("ip", ip);
        params.put("registerTime", String.valueOf(registerTime));
        params.put("registerIp", registerIp);
        params.put("nickname", nickname);
        params.put("userLevel", userLevel);
        params.put("activityId", activityId);
        params.put("target", target);
        params.put("extData", extData);

        return params;
    }

    @Override
    public String toString() {
        return "AnticheatCheckRequest("
                + "super=" + super.toString()
                + ", token=" + token
                + ", account=" + account
                + ", phone=" + phone
                + ", ip=" + ip
                + ", email=" + email
                + ", registerTime=" + registerTime
                + ", registerIp=" + registerIp
                + ", nickname=" + nickname
                + ", userLevel=" + userLevel
                + ", activityId=" + activityId
                + ", target=" + target
                + ", extData=" + extData
                + ")";
    }
}
