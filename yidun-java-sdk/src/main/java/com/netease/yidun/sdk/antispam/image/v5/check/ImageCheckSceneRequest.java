package com.netease.yidun.sdk.antispam.image.v5.check;

import com.netease.yidun.sdk.antispam.image.v5.common.ImageV5Request;
import com.netease.yidun.sdk.core.response.BaseResponse;

public abstract class ImageCheckSceneRequest<T extends BaseResponse> extends ImageV5Request<T> {
    /**
     * 用户昵称nickname
     */
    private String nickname;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 用户等级
     */
    private Integer level;

    /**
     * 注册时间，UNIX 时间戳(毫秒值)
     */
    private Long registerTime;

    /**
     * 好友数
     */
    private Long friendNum;

    /**
     * 粉丝数
     */
    private Long fansNum;

    /**
     * 是否付费
     */
    private Integer isPremiumUse;

    /**
     * 用户类型
     */
    private String role;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户IP地址
     */
    private String ip;

    /**
     * 用户设备id
     */
    private String deviceId;

    /**
     * 用户设备类型
     */
    private Integer deviceType;

    /**
     * 反作弊token
     */
    private String token;

    /**
     * 设备mac地址
     */
    private String mac;

    /**
     * Android设备imei信息
     */
    private String imei;

    /**
     * ios设备idfa信息
     */
    private String idfa;

    /**
     * ios设备idfv信息
     */
    private String idfv;

    /**
     * app版本号
     */
    private String appVersion;

    /**
     * 接收人id
     */
    private String receiveUid;

    /**
     * 好友关系，1接收人关注发送人，2发送人关注接收人，3互相关注，4互未关注
     */
    private Integer relationship;

    /**
     * 群id
     */
    private String groupId;

    /**
     * 聊天室编号
     */
    private String roomId;

    /**
     * 动态id
     */
    private String topic;

    /**
     * 主评论id
     */
    private String commentId;

    /**
     * 商品id
     */
    private String commodityId;

    /**
     * 智能风控token
     */
    private String riskControlToken;

    /**
     * 智能风控businessId
     */
    private String riskControlBusinessId;

    /**
     * 广告代理的行业
     */
    private String adSector;

    /**
     * 广告账号名称
     */
    private String adAccountName;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Long getFriendNum() {
        return friendNum;
    }

    public void setFriendNum(Long friendNum) {
        this.friendNum = friendNum;
    }

    public Long getFansNum() {
        return fansNum;
    }

    public void setFansNum(Long fansNum) {
        this.fansNum = fansNum;
    }

    public Integer getIsPremiumUse() {
        return isPremiumUse;
    }

    public void setIsPremiumUse(Integer isPremiumUse) {
        this.isPremiumUse = isPremiumUse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getIdfv() {
        return idfv;
    }

    public void setIdfv(String idfv) {
        this.idfv = idfv;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getReceiveUid() {
        return receiveUid;
    }

    public void setReceiveUid(String receiveUid) {
        this.receiveUid = receiveUid;
    }

    public Integer getRelationship() {
        return relationship;
    }

    public void setRelationship(Integer relationship) {
        this.relationship = relationship;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getRiskControlToken() {
        return riskControlToken;
    }

    public void setRiskControlToken(String riskControlToken) {
        this.riskControlToken = riskControlToken;
    }

    public String getRiskControlBusinessId() {
        return riskControlBusinessId;
    }

    public void setRiskControlBusinessId(String riskControlBusinessId) {
        this.riskControlBusinessId = riskControlBusinessId;
    }

    public String getAdSector() {
        return adSector;
    }

    public void setAdSector(String adSector) {
        this.adSector = adSector;
    }

    public String getAdAccountName() {
        return adAccountName;
    }

    public void setAdAccountName(String adAccountName) {
        this.adAccountName = adAccountName;
    }
}
