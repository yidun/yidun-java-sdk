package com.netease.yidun.sdk.antispam.livevideo.submit.v4.request;

import com.netease.yidun.sdk.antispam.livevideo.submit.v4.response.LiveVideoCheckResp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * 直播检测请求
 */
@Getter
@Setter
public class LiveVideoCheckReq extends BizPostFormRequest<LiveVideoCheckResp> {

    private String url;

    private String dataId;

    private String ip;

    private String account;

    private String deviceId;

    private String age;

    private String labourUnion;

    private String operationManager;

    private Integer deviceType;

    private String callback;

    private String callbackUrl;

    private String accountLevel;

    private String accountName;

    private String roomNo;

    private String title;

    private Float scFrequency;

    /**
     * 数据唯一key
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
     * 房间id 非必填字段
     */
    private String roomId;

    /**
     * app版本号 非必填字段
     */
    private String appVersion;

    public LiveVideoCheckReq() {
        productCode = "liveVideo";
        uriPattern = "/v4/livevideo/submit";
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
        params.put("labourUnion", getLabourUnion());
        params.put("operationManager", getOperationManager());
        params.put("accountLevel", getAccountLevel());
        params.put("accountName", getAccountName());
        params.put("roomNo", getRoomNo());
        params.put("scFrequency", getScFrequency());
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
        params.put("roomId", getRoomId());
        params.put("appVersion", getAppVersion());
        return params;
    }

    @Override
    public Class<LiveVideoCheckResp> getResponseClass() {
        return LiveVideoCheckResp.class;
    }
}
