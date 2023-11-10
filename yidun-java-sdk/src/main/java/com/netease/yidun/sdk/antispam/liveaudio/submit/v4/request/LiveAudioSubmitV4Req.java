package com.netease.yidun.sdk.antispam.liveaudio.submit.v4.request;

import java.util.List;
import java.util.Map;

import com.netease.yidun.sdk.antispam.liveaudio.submit.v4.response.LiveAudioSubmitV4Resp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import java.util.stream.Collectors;
import lombok.Data;

@Data
public class LiveAudioSubmitV4Req extends BizPostFormRequest<LiveAudioSubmitV4Resp> {

    /**
     * 直播语音url
     */
    private String url;

    /**
     * 直播音频标题
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
    private Integer deviceType;

    /**
     * 数据回调参数，调用方根据业务情况自行设计
     */
    private String callback;

    /**
     * 异步检测结果回调通知的URL
     */
    private String callbackUrl;

    /**
     * 主播房间号
     */
    private String roomNo;

    /**
     * 主播昵称
     */
    private String accountName;

    /**
     * 主播头像
     */
    private String photo;

    /**
     * 背景图
     */
    private String backgroundImage;

    /**
     * 封面
     */
    private String cover;

    /**
     * dataId
     */
    private String dataId;

    /**
     * 主播等级
     */
    private String accountLevel;

    /**
     * uniqueKey
     */
    private String uniqueKey;
    /**
     * 指定语言检测音频内容，需以易盾标准填入
     */
    private String checkLanguageCode;

    /**
     * 发布时间
     */
    private Long publishTime;

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
     * 主播所属工会
     */
    private String labourUnion;

    /**
     * 运营管理者
     */
    private String operationManager;

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
     * 聊天室编号
     */
    private String roomId;

    /**
     * 指定监听必审列表范围内的数据 speakerId
     */
    private List<Long> checkSpeakerIds;

    /**
     * 指定不监听信任用户列表范围内的数据 speakerId
     */
    private List<Long> noCheckSpeakerIds;

    private Long extLon1;

    private Long extLon2;

    private String extStr1;

    private String extStr2;
    /**
     * 业务扩展字段,json字符串
     */
    private String extension;

    private String subProduct;

    public LiveAudioSubmitV4Req() {
        productCode = "liveAudio";
        uriPattern = "/v4/liveaudio/check";
        version = "v4";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("account", getAccount());
        params.put("accountLevel", getAccountLevel());
        params.put("accountName", getAccountName());
        params.put("age", getAge());
        params.put("appVersion", getAppVersion());
        params.put("backgroundImage", getBackgroundImage());
        params.put("callback", getCallback());
        params.put("callbackUrl", getCallbackUrl());
        params.put("cover", getCover());
        params.put("dataId", getDataId());
        params.put("deviceId", getDeviceId());
        params.put("deviceType", getDeviceType());
        params.put("fansNum", getFansNum());
        params.put("friendNum", getFriendNum());
        params.put("gender", getGender());
        params.put("idfa", getIdfa());
        params.put("idfv", getIdfv());
        params.put("imei", getImei());
        params.put("ip", getIp());
        params.put("isPremiumUse", getIsPremiumUse());
        params.put("labourUnion", getLabourUnion());
        params.put("level", getLevel());
        params.put("mac", getMac());
        params.put("nickname", getNickname());
        params.put("operationManager", getOperationManager());
        params.put("phone", getPhone());
        params.put("photo", getPhoto());
        params.put("publishTime", getPublishTime());
        params.put("registerTime", getRegisterTime());
        params.put("role", getRole());
        params.put("roomId", getRoomId());
        params.put("roomNo", getRoomNo());
        params.put("title", getTitle());
        params.put("uniqueKey", getUniqueKey());
        params.put("token", getToken());
        params.put("url", getUrl());
        params.put("checkLanguageCode", getCheckLanguageCode());
        List<Long> checkSpeakerIds = getCheckSpeakerIds();
        if (checkSpeakerIds != null && checkSpeakerIds.size() > 0) {
            params.put("checkSpeakerIds",
                    checkSpeakerIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
        List<Long> noCheckSpeakerIds = getNoCheckSpeakerIds();
        if (noCheckSpeakerIds != null && noCheckSpeakerIds.size() > 0) {
            params.put("noCheckSpeakerIds",
                    noCheckSpeakerIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
        params.put("extLon1", extLon1);
        params.put("extLon2", extLon2);
        params.put("extStr1", extStr1);
        params.put("extStr2", extStr2);
        params.put("subProduct", subProduct);
        return params;
    }

    @Override
    public Class<LiveAudioSubmitV4Resp> getResponseClass() {
        return LiveAudioSubmitV4Resp.class;
    }
}
