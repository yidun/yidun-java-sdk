package com.netease.yidun.sdk.antispam.video.submit.v4.request;

import java.util.Map;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.video.submit.v4.response.VideoCheckResp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Getter;
import lombok.Setter;

/**
 * 点播检测请求
 */
@Getter
@Setter
public class VideoCheckReq extends BizPostFormRequest<VideoCheckResp> {

    private static Gson GSON = new Gson();
    /**
     * 链接地址
     */
    private String url;

    /**
     * 数据唯一标识
     */
    private String dataId;

    /**
     * 点播名称/标题
     */
    private String title;

    /**
     * ip
     */
    private String ip;

    /**
     * 账号
     */
    private String account;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 设备id
     */
    private String deviceId;

    /**
     * 回调地址
     */
    private String callback;

    /**
     * 主动回调地址
     */
    private String callbackUrl;

    /**
     * 截图间隔
     */
    private Float scFrequency = 5f;

    /**
     * 高级截图频率配置，结构是json结构
     */
    private AdvancedFrequencyRequest advancedFrequency;

    /**
     * unique key
     */
    private String uniqueKey;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 反作弊token
     */
    private String token;

    /**
     * 性别， 0: 未知，1: 女性，2: 男性 非必填字段
     */
    private Integer gender;

    /**
     * 年龄，0: 未知 非必填字段
     */
    private Integer age;

    /**
     * 用户等级，0: 未知，1: 低，2: 中，3: 高 非必填字段
     */
    private Integer level;

    /**
     * 注册时间 非必填字段
     */
    private Long registerTime;

    /**
     * 好友数 非必填字段
     */
    private Long friendNum;

    /**
     * 粉丝数 非必填字段
     */
    private Long fansNum;

    /**
     * 是否付费用户，1:优质账号，0:默认 非必填字段
     */
    private Integer isPremiumUse;

    /**
     * 用户角色 非必填字段
     */
    private String role;

    /**
     * 设备唯一标识mac 非必填字段
     */
    private String mac;

    /**
     * 设备唯一标识imei 非必填字段
     */
    private String imei;

    /**
     * 设备唯一标识idfa 非必填字段
     */
    private String idfa;

    /**
     * 设备唯一标识idfv 非必填字段
     */
    private String idfv;

    /**
     * 文章/主贴/动态id 非必填字段
     */
    private String topic;

    /**
     * 私聊接收用户uid 非必填字段
     */
    private String receiveUid;

    /**
     * 群聊id 非必填字段
     */
    private String groupId;

    /**
     * 房间id 非必填字段
     */
    private String roomId;

    /**
     * 商品id 非必填字段
     */
    private String commodityId;

    /**
     * 主评论id 非必填字段
     */
    private String commentId;

    /**
     * app版本号 非必填字段
     */
    private String appVersion;

    /**
     * 好友关系，1接收人关注发送人，2发送人关注接收人，3互相关注，4互未关注 非必填字段
     */
    private Integer relationship;

    /**
     * 客户提交的额外信息
     */
    private String extension;

    /**
     * 自定义业务标识
     */
    private String subProduct;

    public VideoCheckReq() {
        productCode = "videoCheck";
        uriPattern = "/v4/video/submit";
        version = "v4";
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
        params.put("scFrequency", getScFrequency());
        if (advancedFrequency != null) {
            params.put("advancedFrequency", GSON.toJson(getAdvancedFrequency()));
        }
        params.put("uniqueKey", getUniqueKey());
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
        params.put("extension", getExtension());
        params.put("subProduct", getSubProduct());
        return params;
    }

    @Override
    public Class<VideoCheckResp> getResponseClass() {
        return VideoCheckResp.class;
    }
}
