package com.netease.yidun.sdk.antispam.report.v1.submit.request;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.report.v1.submit.response.ReportCheckResponseV1;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.utils.StringUtils;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;
import com.netease.yidun.sdk.core.validation.limitation.Valid;

import java.util.List;
import java.util.Map;

/**
 * 举报提交v1接口
 */
public class ReportSubmitRequestV1 extends PostFormRequest<ReportCheckResponseV1> {
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
     * 举报内容,支持多种类型内容同时过检，包括文本，图片，点播语音,点播音视频，文档
     */
    @Valid
    private List<DataItem> content;

    /**
     * 证据信息,支持多种类型内容同时过检，包括文本，图片，点播语音,点播音视频，文档
     */
    @Valid
    private List<DataItem> evidence;

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
     * 反作弊的 token，当开通反作弊时，抄送到反作弊服务
     */
    @Size(max = 256, message = "token最长256个字符")
    private String token;

    /**
     * 被举报人
     */
    @NotBlank(message = "reportedId不能为空")
    @Size(max = 64, message = "reportedId最长64个字符")
    public String reportedId;
    /**
     * 举报场景
     */
    @Size(max = 64, message = "scenarios最长64个字符")
    public String scenarios;
    /**
     * 举报类型
     */
    @Size(max = 64, message = "reportType最长64个字符")
    public String reportType;
    /**
     * 房间id
     */
    @Size(max = 64, message = "roomId最长64个字符")
    private String roomId;

    /**
     * 语种
     */
    private String checkLanguageCode;

    public ReportSubmitRequestV1() {
        productCode = "report";
        uriPattern = "/v1/report/submit";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("ip", getIp());
        params.put("account", getAccount());
        params.put("deviceId", getDeviceId());
        params.put("deviceType", getDeviceType());
        params.put("dataId", getDataId());
        params.put("callback", getCallback());
        params.put("callbackUrl", getCallbackUrl());
        params.put("publishTime", getPublishTime());
        params.put("token", getToken());
        params.put("reportedId", getReportedId());
        params.put("scenarios", getScenarios());
        params.put("reportType", getReportType());
        params.put("roomId", getRoomId());
        params.put("checkLanguageCode", getCheckLanguageCode());
        if (content != null && !content.isEmpty()) {
            params.put("content", GSON.toJson(getContent()));
        }
        if (evidence != null && !evidence.isEmpty()) {
            params.put("evidence", GSON.toJson(getEvidence()));
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
    public Class<ReportCheckResponseV1> getResponseClass() {
        return ReportCheckResponseV1.class;
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

        @Override
        public String toString() {
            return "DataItem{" +
                    "type='" + type + '\'' +
                    ", data='" + data + '\'' +
                    ", dataId='" + dataId + '\'' +
                    '}';
        }
    }

    public ReportSubmitRequestV1 ip(String ip) {
        this.ip = ip;
        return this;
    }

    public ReportSubmitRequestV1 account(String account) {
        this.account = account;
        return this;
    }

    public ReportSubmitRequestV1 deviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public ReportSubmitRequestV1 deviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public ReportSubmitRequestV1 dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public ReportSubmitRequestV1 content(List<DataItem> content) {
        this.content = content;
        return this;
    }

    public ReportSubmitRequestV1 customParseFieldMap(Map<String, List<DataItem>> customParseFieldMap) {
        this.customParseFieldMap = customParseFieldMap;
        return this;
    }

    public ReportSubmitRequestV1 customUnParseFieldMap(Map<String, String> customUnParseFieldMap) {
        this.customUnParseFieldMap = customUnParseFieldMap;
        return this;
    }

    public ReportSubmitRequestV1 callback(String callback) {
        this.callback = callback;
        return this;
    }

    public ReportSubmitRequestV1 callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public ReportSubmitRequestV1 publishTime(Long publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public ReportSubmitRequestV1 token(String token) {
        this.token = token;
        return this;
    }

    public ReportSubmitRequestV1 reportType(String reportType) {
        this.reportType = reportType;
        return this;
    }

    public ReportSubmitRequestV1 scenarios(String scenarios) {
        this.scenarios = scenarios;
        return this;
    }

    public ReportSubmitRequestV1 reportedId(String reportedId) {
        this.reportedId = reportedId;
        return this;
    }

    public ReportSubmitRequestV1 roomId(String roomId) {
        this.roomId = roomId;
        return this;
    }

    public ReportSubmitRequestV1 evidence(List<DataItem> evidence) {
        this.evidence = evidence;
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

    public List<DataItem> getContent() {
        return content;
    }

    public void setContent(List<DataItem> content) {
        this.content = content;
    }

    public List<DataItem> getEvidence() {
        return evidence;
    }

    public void setEvidence(List<DataItem> evidence) {
        this.evidence = evidence;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getReportedId() {
        return reportedId;
    }

    public void setReportedId(String reportedId) {
        this.reportedId = reportedId;
    }

    public String getScenarios() {
        return scenarios;
    }

    public void setScenarios(String scenarios) {
        this.scenarios = scenarios;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getCheckLanguageCode() {
        return checkLanguageCode;
    }

    public void setCheckLanguageCode(String checkLanguageCode) {
        this.checkLanguageCode = checkLanguageCode;
    }

    @Override
    public String toString() {
        return "ReportSubmitRequestV1{" +
                "ip='" + ip + '\'' +
                ", account='" + account + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", dataId='" + dataId + '\'' +
                ", content=" + content +
                ", evidence=" + evidence +
                ", customParseFieldMap=" + customParseFieldMap +
                ", customUnParseFieldMap=" + customUnParseFieldMap +
                ", callback='" + callback + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", publishTime=" + publishTime +
                ", token='" + token + '\'' +
                ", reportedId='" + reportedId + '\'' +
                ", scenarios='" + scenarios + '\'' +
                ", reportType='" + reportType + '\'' +
                ", roomId='" + roomId + '\'' +
                ", checkLanguageCode='" + checkLanguageCode + '\'' +
                '}';
    }
}
