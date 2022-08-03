package com.netease.yidun.sdk.antispam.media.v2.submit.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.media.v2.submit.response.MediaCheckResponseV2;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.utils.StringUtils;

/**
 * 融媒体检测提交v2接口
 */
public class MediaSubmitRequestV2 extends PostFormRequest<MediaCheckResponseV2> {
    private static final Gson GSON = new Gson();

    /**
     * 用户IP地址
     */
    @Size(max = 128, message = "ip最长128个字符")
    private String ip;

    /**
     * 用户账号
     */
    @Size(max = 128, message = "account最长128个字符")
    private String account;

    /**
     * 用户设备id
     */
    @Size(max = 128, message = "deviceId最长128个字符")
    private String deviceId;

    /**
     * 用户设备类型
     */
    @Size(max = 4, message = "deviceType最长4个字符")
    private String deviceType;

    /**
     * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
     */
    @Size(max = 128, message = "dataId最长128个字符")
    private String dataId;

    /**
     * 标题
     */
    @Size(max = 1024, message = "title最长1024个字符")
    private String title;
    /**
     * 支持多种类型内容同时过检，包括文本，图片，点播语音,点播音视频，文档
     */
    @Valid
    private List<DataItem> content;

    /**
     * 用户自定义解析字段
     */
    private Map<String, List<DataItem>> customParseFieldMap;

    /**
     * 用户自定义不解析解析字段
     */
    private Map<String, String> customUnParseFieldMap;

    /**
     * 回调数据
     */
    @Size(max = 512, message = "callback最长512个字符")
    private String callback;

    /**
     * 回调地址
     */
    @Size(max = 1024, message = "callbackUrl最长1024个字符")
    private String callbackUrl;

    /**
     * publishTime
     */
    private Long publishTime;
    /**
     * 语种
     */
    private String checkLanguageCode;

    /**
     * 反作弊的 token，当开通反作弊时，抄送到反作弊服务
     */
    @Size(max = 256, message = "token最长256个字符")
    private String token;

    public MediaSubmitRequestV2() {
        productCode = "mediaSubmit";
        uriPattern = "/v2/mediasolution/submit";
        version = "v2";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("ip", getIp());
        params.put("account", getAccount());
        params.put("deviceId", getDeviceId());
        params.put("deviceType", getDeviceType());
        params.put("dataId", getDataId());
        params.put("title", getTitle());
        params.put("callback", getCallback());
        params.put("callbackUrl", getCallbackUrl());
        params.put("publishTime", getPublishTime());
        params.put("checkLanguageCode", getCheckLanguageCode());
        params.put("token", getToken());
        if (content != null && !content.isEmpty()) {
            params.put("content", GSON.toJson(getContent()));
        }
        if (customParseFieldMap != null && !customParseFieldMap.isEmpty()) {
            for (Map.Entry<String, List<DataItem>> filed : customParseFieldMap.entrySet()) {
                List<DataItem> dataItemList = filed.getValue();
                if (StringUtils.isNotBlank(filed.getKey()) && dataItemList != null && !dataItemList.isEmpty()) {
                    params.put(filed.getKey(), GSON.toJson(dataItemList));
                }
            }
        }
        if (customUnParseFieldMap != null && !customUnParseFieldMap.isEmpty()) {
            for (Map.Entry<String, String> filed : customUnParseFieldMap.entrySet()) {
                String data = filed.getValue();
                if (StringUtils.isNotBlank(filed.getKey()) && StringUtils.isNotBlank(data)) {
                    params.put(filed.getKey(), data);
                }
            }
        }
        return params;
    }

    @Override
    public Class<MediaCheckResponseV2> getResponseClass() {
        return MediaCheckResponseV2.class;
    }

    public static class DataItem {
        @NotBlank(message = "type不能为空")
        @Size(min = 1, max = 10, message = "type最长10个字符")
        private String type;
        @NotBlank(message = "data不能为空")
        @Size(min = 1, max = 5000, message = "data最长5000个字符")
        private String data;
        @Size(max = 128, message = "dataId最长128个字符")
        private String dataId;
        /**
         * 子数据数据配置，主要是针对于过检数据的特定参数设置
         */
        private Map<String, String> config;

        public DataItem type(String type) {
            this.type = type;
            return this;
        }

        public DataItem data(String data) {
            this.data = data;
            return this;
        }

        public DataItem dataId(String dataId) {
            this.dataId = dataId;
            return this;
        }

        public DataItem config(String key, String value) {
            if (config == null) {
                config = new HashMap<>();
            }
            config.put(key, value);
            return this;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public Map<String, String> getConfig() {
            return config;
        }

        public void setConfig(Map<String, String> config) {
            this.config = config;
        }

        @Override
        public String toString() {
            return "DataItem{" +
                    "type='" + type + '\'' +
                    ", data='" + data + '\'' +
                    ", dataId='" + dataId + '\'' +
                    ", config=" + config +
                    '}';
        }
    }

    public MediaSubmitRequestV2 ip(String ip) {
        this.ip = ip;
        return this;
    }

    public MediaSubmitRequestV2 account(String account) {
        this.account = account;
        return this;
    }

    public MediaSubmitRequestV2 deviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public MediaSubmitRequestV2 deviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public MediaSubmitRequestV2 dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public MediaSubmitRequestV2 title(String title) {
        this.title = title;
        return this;
    }

    public MediaSubmitRequestV2 content(List<DataItem> content) {
        this.content = content;
        return this;
    }

    public MediaSubmitRequestV2 customParseFieldMap(Map<String, List<DataItem>> customParseFieldMap) {
        this.customParseFieldMap = customParseFieldMap;
        return this;
    }

    public MediaSubmitRequestV2 customUnParseFieldMap(Map<String, String> customUnParseFieldMap) {
        this.customUnParseFieldMap = customUnParseFieldMap;
        return this;
    }

    public MediaSubmitRequestV2 callback(String callback) {
        this.callback = callback;
        return this;
    }

    public MediaSubmitRequestV2 callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public MediaSubmitRequestV2 publishTime(Long publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public MediaSubmitRequestV2 token(String token) {
        this.token = token;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DataItem> getContent() {
        return content;
    }

    public void setContent(List<DataItem> content) {
        this.content = content;
    }

    public Map<String, List<DataItem>> getCustomParseFieldMap() {
        return customParseFieldMap;
    }

    public void setCustomParseFieldMap(Map<String, List<DataItem>> customParseFieldMap) {
        this.customParseFieldMap = customParseFieldMap;
    }

    public Map<String, String> getCustomUnParseFieldMap() {
        return customUnParseFieldMap;
    }

    public void setCustomUnParseFieldMap(Map<String, String> customUnParseFieldMap) {
        this.customUnParseFieldMap = customUnParseFieldMap;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public String getCheckLanguageCode() {
        return checkLanguageCode;
    }

    public void setCheckLanguageCode(String checkLanguageCode) {
        this.checkLanguageCode = checkLanguageCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "MediaSubmitRequestV2{" +
                "ip='" + ip + '\'' +
                ", account='" + account + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", dataId='" + dataId + '\'' +
                ", title='" + title + '\'' +
                ", content=" + content +
                ", customParseFieldMap=" + customParseFieldMap +
                ", customUnParseFieldMap=" + customUnParseFieldMap +
                ", callback='" + callback + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", publishTime=" + publishTime +
                ", checkLanguageCode=" + checkLanguageCode +
                ", token='" + token + '\'' +
                '}';
    }
}
