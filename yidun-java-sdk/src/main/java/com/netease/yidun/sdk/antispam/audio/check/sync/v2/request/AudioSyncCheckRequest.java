package com.netease.yidun.sdk.antispam.audio.check.sync.v2.request;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.audio.check.sync.v2.response.AudioSyncCheckResponse;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class AudioSyncCheckRequest extends BizPostFormRequest<AudioSyncCheckResponse> {
    private static final Gson GSON = new Gson();

    /**
     * 点播语音url
     */
    private String url;

    /**
     * 点播语音标题
     */
    private String title;

    /**
     * 用户IP地址
     */
    private String ip;

    /**
     * 用户唯一标识，如果无需登录则为空
     */
    private String account;

    /**
     * 用户设备 id
     */
    private String deviceId;

    /**
     * 用户设备类型
     */
    private String deviceType;

    /**
     * 数据回调参数，调用方根据业务情况自行设计
     */
    private String callback;

    /**
     * 异步检测结果回调通知的URL
     */
    private String callbackUrl;

    /**
     * 音频标签
     */
    private List<String> tags;

    /**
     * dataId
     */
    private String dataId;

    /**
     * 上下文关联key列表
     */
    private Set<String> relatedKeys;
    /**
     * 检测类型 默认0-url，1-base64
     */
    private Integer dataCheckType;

    /**
     * 同步检测接口-语音内容base64
     */
    private String data;
    /**
     * 发布时间
     */
    private Long publishTime;

    /**
     * 去重key
     */
    private String uniqueKey;

    /**
     * 客户提交的扩展字段，需要严格按照 json 格式
     */
    private String extension;

    /**
     * 自定义业务标识
     */
    private String subProduct;

    /**
     * 昵称
     */
    private String nickname;

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
     * token
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

    public AudioSyncCheckRequest() {
        productCode = "audioCheck";
        uriPattern = "/v2/audio/check";
        version = "v2.1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("url", getUrl());
        params.put("dataId", getDataId());
        params.put("title", getTitle());
        params.put("ip", getIp());
        params.put("account", getAccount());
        params.put("deviceType", getDeviceType());
        params.put("deviceId", getDeviceId());
        params.put("callback", getCallback());
        params.put("callbackUrl", getCallbackUrl());
        params.put("uniqueKey", getUniqueKey());
        params.put("extension", getExtension());
        params.put("subProduct", getSubProduct());
        params.put("nickname", getNickname());
        params.put("phone", getPhone());
        params.put("token", getToken());
        params.put("gender", getGender());
        params.put("age", getAge());
        params.put("level", getLevel());
        params.put("registerTime", getRegisterTime());
        params.put("friendNum", getFriendNum());
        params.put("fansNum", getFansNum());
        params.put("isPremiumUse", getIsPremiumUse());
        params.put("role", getRole());
        params.put("mac", getMac());
        params.put("imei", getImei());
        params.put("idfa", getIdfa());
        params.put("idfv", getIdfv());
        params.put("topic", getTopic());
        params.put("receiveUid", getReceiveUid());
        params.put("groupId", getGroupId());
        params.put("roomId", getRoomId());
        params.put("commodityId", getCommodityId());
        params.put("commentId", getCommentId());
        params.put("appVersion", getAppVersion());
        params.put("relationship", getRelationship());
        params.put("publishTime", getPublishTime());
        params.put("dataCheckType", getDataCheckType());
        params.put("data", getData());
        params.put("relatedKeys", GSON.toJson(relatedKeys));
        params.put("tags", GSON.toJson(tags));
        return params;
    }


    @Override
    public Class<AudioSyncCheckResponse> getResponseClass() {
        return AudioSyncCheckResponse.class;
    }
}
