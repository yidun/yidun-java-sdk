package com.netease.yidun.sdk.antispam.text.v5.check.sync.single;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.List;
import java.util.Map;

/**
 * 文本检测请求基类
 */
public class TextCheckSceneRequest<T extends BaseResponse> extends BizPostFormRequest<T> {

    /**
     * 数据唯一标识，能够根据该值定位到该条数据
     */
    @NotBlank(message = "dataId不能为空")
    @Size(max = 128, message = "dataId最长128个字符")
    private String dataId;
    /**
     * 用户发表内容，建议对内容中json、表情符、HTML标签、UBB标签等做过滤，只传递纯文本，以减少误判概率
     */
    @NotBlank(message = "content不能为空")
    @Size(max = 10000, message = "content最长10000个字符")
    private String content;
    /**
     * 内容标题，适用于贴子、博客的文章标题等场景，建议抄送，辅助机审策略精准调优
     */
    @Size(max = 512, message = "title最长512个字符")
    private String title;
    /**
     * 大小限制 子数据类型，与易盾内容安全服务约定即可
     */
    private Integer dataType;
    /**
     * 数据回调参数，调用方根据业务情况自行设计，当调用文本结果获取接口-轮询模式或文本结果获取接口-推送模式时，该接口会原样返回该字段。
     */
    @Size(max = 65535, message = "callback最长65535个字符")
    private String callback;
    /**
     * 发表时间，UNIX 时间戳(毫秒值)
     */
    private Long publishTime;
    /**
     * 人工审核结果回调通知到客户的URL
     */
    @Size(max = 256, message = "callbackUrl最长256个字符")
    private String callbackUrl;
    /**
     * 来源，用于展示渠道名称，应用名称等
     */
    @Size(max = 128, message = "category最长128个字符")
    private String category;

    /**
     * 用户唯一标识
     */
    @Size(max = 128, message = "account最长128个字符")
    private String account;

    /**
     * 手机号
     */
    @Size(max = 64, message = "phone最长64个字符")
    private String phone;

    /**
     * 自定义业务标识
     */
    private String subProduct;


    /**
     * 用户昵称
     */
    @Size(max = 128, message = "nickname最长128个字符")
    private String nickname;

    /**
     * 性别， 0: 未知，1: 男性，2: 女性
     */
    private Integer gender;

    /**
     * 年龄，0: 未知
     */
    private Integer age;

    /**
     * 用户等级，0: 未知，1: 低，2: 中，3: 高
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
     * 是否付费用户，0为默认值，1为付费
     */
    private Integer isPremiumUse;

    /**
     * 用户类型角色
     */
    @Size(max = 32, message = "role最长32个字符")
    private String role;

    /**
     * 用户设备id的类型
     */
    private Integer deviceType;

    /**
     * 用户设备 id
     */
    @Size(max = 128, message = "deviceId最长128个字符")
    private String deviceId;

    /**
     * 用户设备mac信息
     */
    @Size(max = 64, message = "mac最长64个字符")
    private String mac;

    /**
     * 国际移动设备识别码
     */
    @Size(max = 64, message = "imei最长64个字符")
    private String imei;

    /**
     * iOS设备标识码
     */
    @Size(max = 64, message = "idfa最长64个字符")
    private String idfa;

    /**
     * iOS设备标识码
     */
    @Size(max = 64, message = "idfv最长64个字符")
    private String idfv;

    /**
     * APP版本号
     */
    @Size(max = 32, message = "appVersion最长32个字符")
    private String appVersion;

    /**
     * 接受消息的用户标识
     */
    @Size(max = 64, message = "receiveUid最长64个字符")
    private String receiveUid;

    /**
     * 收发消息者好友关系，1接收人关注发送人，2发送人关注接收人，3互相关注，4互未关注
     */
    private Integer relationship;

    /**
     * 群聊id
     */
    @Size(max = 32, message = "groupId最长32个字符")
    private String groupId;

    /**
     * 聊天室/直播/游戏房间
     */
    @Size(max = 32, message = "roomId最长32个字符")
    private String roomId;

    /**
     * 文章/帖子id
     */
    @Size(max = 128, message = "topic最长128个字符")
    private String topic;

    /**
     * 主评论id
     */
    @Size(max = 32, message = "commentId最长32个字符")
    private String commentId;

    /**
     * 商品id
     */
    @Size(max = 32, message = "commodityId最长32个字符")
    private String commodityId;

    /**
     * 用户IP地址
     */
    @Size(max = 128, message = "ip最长128个字符")
    private String ip;
    /**
     * 接收者IP地址
     */
    @Size(max = 128, message = "接收者ip最长128个字符")
    private String receiveIp;

    /**
     * 上下文关联key列表
     */
    private List<String> relatedKeys;

    /**
     * 自定义扩展参数1
     */
    @Size(max = 128, message = "extStr2最长128个字符")
    private String extStr1;

    /**
     * 自定义扩展参数2
     */
    @Size(max = 128, message = "extStr2最长128个字符")
    private String extStr2;

    /**
     * 预留扩展long字段1
     */
    private Long extLon1;

    /**
     * 预留扩展long字段2
     */
    private Long extLon2;

    /**
     * 智能风控token
     */
    private String riskControlToken;

    /**
     * 智能风控businessId
     */
    private String riskControlBusinessId;
    /**
     * 人审扩展字段，用于人审调度中心的规则匹配
     */
    @Size(max = 1024, message = "censorExt最长1024个字符")
    private String censorExt;


    /**
     * 客户提交的扩展字段，需要严格按照 json 格式
     */
    private String extension;




    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String dataId() {
        return dataId;
    }

    public TextCheckSceneRequest<T> dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String content() {
        return content;
    }

    public TextCheckSceneRequest<T> content(String content) {
        this.content = content;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }

    public TextCheckSceneRequest<T> title(String title) {
        this.title = title;
        return this;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer dataType() {
        return dataType;
    }

    public TextCheckSceneRequest<T> dataType(Integer dataType) {
        this.dataType = dataType;
        return this;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String callback() {
        return callback;
    }

    public TextCheckSceneRequest<T> callback(String callback) {
        this.callback = callback;
        return this;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public Long publishTime() {
        return publishTime;
    }

    public TextCheckSceneRequest<T> publishTime(Long publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String callbackUrl() {
        return callbackUrl;
    }

    public TextCheckSceneRequest<T> callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String category() {
        return category;
    }

    public TextCheckSceneRequest<T> category(String category) {
        this.category = category;
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

    public TextCheckSceneRequest<T> account(String account) {
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

    public TextCheckSceneRequest<T> phone(String phone) {
        this.phone = phone;
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

    public TextCheckSceneRequest<T> nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer gender() {
        return gender;
    }

    public TextCheckSceneRequest<T> gender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer age() {
        return age;
    }

    public TextCheckSceneRequest<T> age(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer level() {
        return level;
    }

    public TextCheckSceneRequest<T> level(Integer level) {
        this.level = level;
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

    public TextCheckSceneRequest<T> registerTime(Long registerTime) {
        this.registerTime = registerTime;
        return this;
    }

    public Long getFriendNum() {
        return friendNum;
    }

    public void setFriendNum(Long friendNum) {
        this.friendNum = friendNum;
    }

    public Long friendNum() {
        return friendNum;
    }

    public TextCheckSceneRequest<T> friendNum(Long friendNum) {
        this.friendNum = friendNum;
        return this;
    }

    public Long getFansNum() {
        return fansNum;
    }

    public void setFansNum(Long fansNum) {
        this.fansNum = fansNum;
    }

    public Long fansNum() {
        return fansNum;
    }

    public TextCheckSceneRequest<T> fansNum(Long fansNum) {
        this.fansNum = fansNum;
        return this;
    }

    public Integer getIsPremiumUse() {
        return isPremiumUse;
    }

    public void setIsPremiumUse(Integer isPremiumUse) {
        this.isPremiumUse = isPremiumUse;
    }

    public Integer isPremiumUse() {
        return isPremiumUse;
    }

    public TextCheckSceneRequest<T> isPremiumUse(Integer isPremiumUse) {
        this.isPremiumUse = isPremiumUse;
        return this;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String role() {
        return role;
    }

    public TextCheckSceneRequest<T> role(String role) {
        this.role = role;
        return this;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer deviceType() {
        return deviceType;
    }

    public TextCheckSceneRequest<T> deviceType(Integer deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String deviceId() {
        return deviceId;
    }

    public TextCheckSceneRequest<T> deviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String mac() {
        return mac;
    }

    public TextCheckSceneRequest<T> mac(String mac) {
        this.mac = mac;
        return this;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String imei() {
        return imei;
    }

    public TextCheckSceneRequest<T> imei(String imei) {
        this.imei = imei;
        return this;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String idfa() {
        return idfa;
    }

    public TextCheckSceneRequest<T> idfa(String idfa) {
        this.idfa = idfa;
        return this;
    }

    public String getIdfv() {
        return idfv;
    }

    public void setIdfv(String idfv) {
        this.idfv = idfv;
    }

    public String idfv() {
        return idfv;
    }

    public TextCheckSceneRequest<T> idfv(String idfv) {
        this.idfv = idfv;
        return this;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String appVersion() {
        return appVersion;
    }

    public TextCheckSceneRequest<T> appVersion(String appVersion) {
        this.appVersion = appVersion;
        return this;
    }

    public String getReceiveUid() {
        return receiveUid;
    }

    public void setReceiveUid(String receiveUid) {
        this.receiveUid = receiveUid;
    }

    public String receiveUid() {
        return receiveUid;
    }

    public TextCheckSceneRequest<T> receiveUid(String receiveUid) {
        this.receiveUid = receiveUid;
        return this;
    }

    public Integer getRelationship() {
        return relationship;
    }

    public void setRelationship(Integer relationship) {
        this.relationship = relationship;
    }

    public Integer relationship() {
        return relationship;
    }

    public TextCheckSceneRequest<T> relationship(Integer relationship) {
        this.relationship = relationship;
        return this;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String groupId() {
        return groupId;
    }

    public TextCheckSceneRequest<T> groupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String roomId() {
        return roomId;
    }

    public TextCheckSceneRequest<T> roomId(String roomId) {
        this.roomId = roomId;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String topic() {
        return topic;
    }

    public TextCheckSceneRequest<T> topic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String commentId() {
        return commentId;
    }

    public TextCheckSceneRequest<T> commentId(String commentId) {
        this.commentId = commentId;
        return this;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String commodityId() {
        return commodityId;
    }

    public TextCheckSceneRequest<T> commodityId(String commodityId) {
        this.commodityId = commodityId;
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

    public TextCheckSceneRequest<T> ip(String ip) {
        this.ip = ip;
        return this;
    }

    public String getReceiveIp() {
        return receiveIp;
    }

    public void setReceiveIp(String receiveIp) {
        this.receiveIp = receiveIp;
    }

    public String receiveIp() {
        return receiveIp;
    }

    public TextCheckSceneRequest<T> receiveIp(String receiveIp) {
        this.receiveIp = receiveIp;
        return this;
    }

    public List<String> getRelatedKeys() {
        return relatedKeys;
    }

    public void setRelatedKeys(List<String> relatedKeys) {
        this.relatedKeys = relatedKeys;
    }

    public List<String> relatedKeys() {
        return relatedKeys;
    }

    public TextCheckSceneRequest<T> relatedKeys(List<String> relatedKeys) {
        this.relatedKeys = relatedKeys;
        return this;
    }

    public String getExtStr1() {
        return extStr1;
    }

    public void setExtStr1(String extStr1) {
        this.extStr1 = extStr1;
    }

    public String extStr1() {
        return extStr1;
    }

    public TextCheckSceneRequest<T> extStr1(String extStr1) {
        this.extStr1 = extStr1;
        return this;
    }

    public String getExtStr2() {
        return extStr2;
    }

    public void setExtStr2(String extStr2) {
        this.extStr2 = extStr2;
    }

    public String extStr2() {
        return extStr2;
    }

    public TextCheckSceneRequest<T> extStr2(String extStr2) {
        this.extStr2 = extStr2;
        return this;
    }

    public Long getExtLon1() {
        return extLon1;
    }

    public void setExtLon1(Long extLon1) {
        this.extLon1 = extLon1;
    }

    public Long extLon1() {
        return extLon1;
    }

    public TextCheckSceneRequest<T> extLon1(Long extLon1) {
        this.extLon1 = extLon1;
        return this;
    }

    public Long getExtLon2() {
        return extLon2;
    }

    public void setExtLon2(Long extLon2) {
        this.extLon2 = extLon2;
    }

    public Long extLon2() {
        return extLon2;
    }

    public TextCheckSceneRequest<T> extLon2(Long extLon2) {
        this.extLon2 = extLon2;
        return this;
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
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }


    public String getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(String subProduct) {
        this.subProduct = subProduct;
    }

    @Override
    public Class<T> getResponseClass() {
        return null;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("dataId", dataId);
        params.put("content", content);
        params.put("title", title);
        params.put("dataType", dataType != null ? String.valueOf(dataType) : null);
        params.put("callback", callback);
        params.put("publishTime", publishTime != null ? String.valueOf(publishTime) : null);
        params.put("callbackUrl", callbackUrl);
        params.put("category", category);
        params.put("account", account);
        params.put("phone", phone);
        params.put("nickname", nickname);
        params.put("gender", gender != null ? String.valueOf(gender) : null);
        params.put("age", age != null ? String.valueOf(age) : null);
        params.put("level", level != null ? String.valueOf(level) : null);
        params.put("registerTime", registerTime != null ? String.valueOf(registerTime) : null);
        params.put("friendNum", friendNum != null ? String.valueOf(friendNum) : null);
        params.put("fansNum", fansNum != null ? String.valueOf(fansNum) : null);
        params.put("isPremiumUse", isPremiumUse != null ? String.valueOf(isPremiumUse) : null);
        params.put("role", role);
        params.put("deviceType", deviceType != null ? String.valueOf(deviceType) : null);
        params.put("deviceId", deviceId);
        params.put("mac", mac);
        params.put("imei", imei);
        params.put("idfa", idfa);
        params.put("idfv", idfv);
        params.put("appVersion", appVersion);
        params.put("receiveUid", receiveUid);
        params.put("relationship", relationship != null ? String.valueOf(relationship) : null);
        params.put("groupId", groupId);
        params.put("roomId", roomId);
        params.put("topic", topic);
        params.put("commentId", commentId);
        params.put("commodityId", commodityId);
        params.put("ip", ip);
        params.put("receiveIp", receiveIp);
        params.put("relatedKeys", relatedKeys != null ? String.join(",", relatedKeys) : null);
        params.put("extStr1", extStr1);
        params.put("extStr2", extStr2);
        params.put("extLon1", extLon1 != null ? String.valueOf(extLon1) : null);
        params.put("extLon2", extLon2 != null ? String.valueOf(extLon2) : null);
        params.put("riskControlBusinessId", riskControlBusinessId);
        params.put("riskControlToken", riskControlToken);
        params.put("censorExt", censorExt);
        params.put("extension",extension);
        params.put("subProduct",subProduct);
        return params;
    }

    @Override
    public String toString() {
        return "TextCheckSceneRequest("
                + "super=" + super.toString()
                + ", dataId=" + dataId
                + ", content=" + content
                + ", title=" + title
                + ", dataType=" + dataType
                + ", callback=" + callback
                + ", publishTime=" + publishTime
                + ", callbackUrl=" + callbackUrl
                + ", category=" + category
                + ", account=" + account
                + ", phone=" + phone
                + ", nickname=" + nickname
                + ", gender=" + gender
                + ", age=" + age
                + ", level=" + level
                + ", registerTime=" + registerTime
                + ", friendNum=" + friendNum
                + ", fansNum=" + fansNum
                + ", isPremiumUse=" + isPremiumUse
                + ", role=" + role
                + ", deviceType=" + deviceType
                + ", deviceId=" + deviceId
                + ", mac=" + mac
                + ", imei=" + imei
                + ", idfa=" + idfa
                + ", idfv=" + idfv
                + ", appVersion=" + appVersion
                + ", receiveUid=" + receiveUid
                + ", relationship=" + relationship
                + ", groupId=" + groupId
                + ", roomId=" + roomId
                + ", topic=" + topic
                + ", commentId=" + commentId
                + ", commodityId=" + commodityId
                + ", ip=" + ip
                + ", relatedKeys=" + relatedKeys
                + ", extStr1=" + extStr1
                + ", extStr2=" + extStr2
                + ", extLon1=" + extLon1
                + ", extLon2=" + extLon2
                + ", riskControlBusinessId=" + riskControlBusinessId
                + ", riskControlBusinessId=" + riskControlBusinessId
                + ", censorExt=" + censorExt
                + ", extension=" + extension
                + ", subProduct=" + subProduct
                + ")";
    }

    public String getCensorExt() {
        return censorExt;
    }

    public void setCensorExt(String censorExt) {
        this.censorExt = censorExt;
    }
}
