/*
 * @(#) AigcStreamPushRequestV1.java 2024-06-03
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.stream.v1.push;

import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.validation.limitation.Max;
import com.netease.yidun.sdk.core.validation.limitation.Min;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.Map;

/**
 * @author ruicha
 * @version 2024-06-03
 */
public class AigcStreamPushRequestV1 extends PostFormRequest<AigcStreamPushResponseV1>  {
    public AigcStreamPushRequestV1() {
        productCode = "aigcStreamPush";
        uriPattern = "/v1/stream/push";
        version = "v1.0";
    }

    /**
     * 会话开启接口返回的Id，用于关联整个流式检测会话，用户也可以直接传一个自定义会话id, 系统接收到之后会自动创建一个新会话
     */
    @NotBlank(message = "sessionId不能为空")
    @Size(max = 128, message = "sessionId长度不能超过128")
    private String sessionId;

    /**
     * 推送的事件类型，1：流式输出检测  2：输入检测  3：会话结束，默认值为：1
     */
    @Min(value = 1, message = "type取值范围为[1,3]")
    @Max(value = 3, message = "type取值范围为[1,3]")
    private Integer type;

    /**
     * 上传数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给策略经理查询，建议客户传递
     */
    @Size(max = 128, message = "dataId长度不能超过128")
    private String dataId;

    /**
     * type = 1：content必传，流式检测内容片段，可对应aigc场景流式输出的tokens，检测片段传入AIGC-输出文本中，最大长度200
     * type = 2：content必传，流式检测场景下输入内容，建议对内容中json、表情符、HTML标签、UBB标签等做过滤，只传递纯文本，以减少误判概率，对应传入AIGC-输入文本中，最大长度10000
     * type = 3：content不需要传
     */
    private String content;

    /**
     * 时间戳，数据片段生成的时间，可以不传，传了之后拼接的内容会基于时间戳进行排序，UNIX 时间戳（毫秒值）
     */
    private Long publishTime;

    // ==== 核心业务参数 end ====

    // ==== 扩展业务参数 start ====

    /**
     * 数据回调参数，调用方根据业务情况自行设计，当调用回调接口时，该接口会原样返回该字段
     */
    @Size(max = 65535, message = "callback最长65535个字符")
    private String callback;

    /**
     * 异步及离线策略检测结果回调通知到客户的URL。主动回调数据接口超时时间设置为2s，为了保证顺利接收数据，需保证接收接口性能稳定并且保证幂等性
     */
    @Size(max = 256, message = "callbackUrl最长256个字符")
    private String callbackUrl;

    /**
     * 业务过检分类,如果没有勾选分类提交返回参数错误，多个垃圾类别以逗号分隔（"100,200"）
     */
    @Size(max = 512, message = "checkLabels最长512个字符")
    private String checkLabels;

    /**
     * 用户唯一标识，
     */
    @Size(max = 128, message = "account最长128个字符")
    private String account;

    /**
     * 用户IP地址，建议抄送，辅助机审策略精准调优
     */
    @Size(max = 128, message = "ip最长128个字符")
    private String ip;

    /**
     * 用户设备 id
     */
    @Size(max = 128, message = "deviceId最长128个字符")
    private String deviceId;

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
     * 自定义扩展参数
     */
    private Long extLon1;

    /**
     * 自定义扩展参数
     */
    private Long extLon2;

    /**
     * 自定义扩展参数，JSON字符串格式。如："{"keyName1":"value1","keyName2":"value2"}"
     */
    private String extension;
    @Override
    public Class<AigcStreamPushResponseV1> getResponseClass() {
        return AigcStreamPushResponseV1.class;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
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

    public String getCheckLabels() {
        return checkLabels;
    }

    public void setCheckLabels(String checkLabels) {
        this.checkLabels = checkLabels;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getExtStr1() {
        return extStr1;
    }

    public void setExtStr1(String extStr1) {
        this.extStr1 = extStr1;
    }

    public String getExtStr2() {
        return extStr2;
    }

    public void setExtStr2(String extStr2) {
        this.extStr2 = extStr2;
    }

    public Long getExtLon1() {
        return extLon1;
    }

    public void setExtLon1(Long extLon1) {
        this.extLon1 = extLon1;
    }

    public Long getExtLon2() {
        return extLon2;
    }

    public void setExtLon2(Long extLon2) {
        this.extLon2 = extLon2;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "AigcStreamPushRequestV1{" +
                "sessionId='" + sessionId + '\'' +
                ", type=" + type +
                ", dataId='" + dataId + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", callback='" + callback + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", checkLabels='" + checkLabels + '\'' +
                ", account='" + account + '\'' +
                ", ip='" + ip + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", extStr1='" + extStr1 + '\'' +
                ", extStr2='" + extStr2 + '\'' +
                ", extLon1=" + extLon1 +
                ", extLon2=" + extLon2 +
                ", extension='" + extension + '\'' +
                "} " + super.toString();
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap customSignParams = new StringHashMap();
        customSignParams.putAll(super.getCustomSignParams());
        customSignParams.put("sessionId", sessionId);
        customSignParams.put("type", type);
        customSignParams.put("dataId", dataId);
        customSignParams.put("content", content);
        customSignParams.put("publishTime", publishTime);
        customSignParams.put("callback", callback);
        customSignParams.put("callbackUrl", callbackUrl);
        customSignParams.put("checkLabels", checkLabels);
        customSignParams.put("account", account);
        customSignParams.put("ip", ip);
        customSignParams.put("deviceId", deviceId);
        customSignParams.put("extStr1", extStr1);
        customSignParams.put("extStr2", extStr2);
        customSignParams.put("extLon1", extLon1);
        customSignParams.put("extLon2", extLon2);
        customSignParams.put("extension", extension);
        return customSignParams;
    }
}
