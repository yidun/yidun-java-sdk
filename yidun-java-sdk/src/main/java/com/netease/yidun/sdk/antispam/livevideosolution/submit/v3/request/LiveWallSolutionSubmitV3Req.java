package com.netease.yidun.sdk.antispam.livevideosolution.submit.v3.request;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.livevideosolution.submit.v3.response.LiveWallSolutionSubmitV3Resp;
import com.netease.yidun.sdk.antispam.video.submit.v4.request.AdvancedFrequencyRequest;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class LiveWallSolutionSubmitV3Req extends PostFormRequest<LiveWallSolutionSubmitV3Resp> {
    private static final Gson GSON = new Gson();

    private String url;

    private String dataId;

    private String ip;

    private String account;

    private String deviceId;

    /**
     * 设备类型
     */
    private Integer deviceType;

    /**
     * 主播年龄
     */
    private String age;

    /**
     * 主播所属工会
     */
    private String labourUnion;

    /**
     * 运营管理者
     */
    private String operationManager;

    private String callback;

    private String callbackUrl;

    private String accountLevel;

    private String accountName;

    private String roomId;

    private String title;

    private String scFrequency;
    /**
     * 指定过检测类型
     */
    private Integer detectType;
    /**
     * 去重，该字段不传则用url来去重 <br>
     * 最长256
     */
    private String uniqueKey;
    /**
     * 背景图
     */
    private String backgroundImage;
    /**
     * 封面
     */
    private String cover;
    /**
     * 主播头像
     */
    private String photo;

    private Long publishTime;

    private String liveLink;

    private AdvancedFrequencyRequest advancedFrequency;
    /**
     * 0-竖屏 1-横屏
     */
    private Integer screenMode;
    /**
     * 指定语言检测音频内容，需以易盾标准填入
     */
    private String checkLanguageCode;

    private Integer gender;

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

    /**
     * 截图策略 0-易盾截图 1-云信上传截图
     */
    private Integer screenShotStrategy;

    private String subProduct;

    private String censorStreamUrl;
    private String accountInfo;

    public LiveWallSolutionSubmitV3Req() {
        productCode = "liveVideoSolutionCheck";
        uriPattern = "/v3/livewallsolution/check";
        version = "v3.1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("account", getAccount());
        params.put("accountLevel", getAccountLevel());
        params.put("accountName", getAccountName());
        params.put("age", getAge());
        params.put("backgroundImage", getBackgroundImage());
        params.put("callback", getCallback());
        params.put("callbackUrl", getCallbackUrl());
        params.put("cover", getCover());
        params.put("dataId", getDataId());
        params.put("detectType", getDetectType());
        params.put("deviceId", getDeviceId());
        params.put("deviceType", getDeviceType());
        params.put("ip", getIp());
        params.put("labourUnion", getLabourUnion());
        params.put("operationManager", getOperationManager());
        params.put("photo", getPhoto());
        params.put("publishTime", getPublishTime());
        params.put("roomId", getRoomId());
        params.put("scFrequency", getScFrequency());
        params.put("title", getTitle());
        params.put("uniqueKey", getUniqueKey());
        params.put("url", getUrl());
        params.put("censorStreamUrl", getCensorStreamUrl());
        params.put("accountInfo", getAccountInfo());
        if (advancedFrequency != null) {
            params.put("advancedFrequency", GSON.toJson(getAdvancedFrequency()));
        }
        params.put("liveLink", getLiveLink());
        params.put("screenMode", getScreenMode());
        params.put("checkLanguageCode", getCheckLanguageCode());
        params.put("gender", getGender());
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
        params.put("screenShotStrategy", screenShotStrategy);
        params.put("subProduct", subProduct);
        params.put("extension", extension);
        return params;
    }

    @Override
    public Class<LiveWallSolutionSubmitV3Resp> getResponseClass() {
        return LiveWallSolutionSubmitV3Resp.class;
    }
}
