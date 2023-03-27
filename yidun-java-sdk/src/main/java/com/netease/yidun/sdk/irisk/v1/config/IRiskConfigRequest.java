package com.netease.yidun.sdk.irisk.v1.config;

import com.netease.yidun.sdk.core.request.BizPostJsonRequest;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import java.util.Map;


public class IRiskConfigRequest extends BizPostJsonRequest<IRiskConfigResponse> {

    /**
     * 用户/ 玩家的IP，或当前客户端业务事件发生时的公网IP地址（ipv4）
     */
    @NotBlank(message = "ip不能为空")
    private String ip;

    /**
     * 从风控SDK获取的拉取配置的参数
     */
    private String sdkData;

    public IRiskConfigRequest(String businessId) {
        productCode = "irisk";
        version = "400";
        uriPattern = "/v5/risk/getConfig";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("ip", ip);
        customSignParams.put("sdkData", sdkData);
        return customSignParams;
    }

    @Override
    public Class<IRiskConfigResponse> getResponseClass() {
        return IRiskConfigResponse.class;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSdkData() {
        return sdkData;
    }

    public void setSdkData(String sdkData) {
        this.sdkData = sdkData;
    }

    public IRiskConfigRequest ip(String ip) {
        this.ip = ip;
        return this;
    }

    public IRiskConfigRequest sdkData(String sdkData) {
        this.sdkData = sdkData;
        return this;
    }

    @Override
    public String toString() {
        return "IRiskConfigRequest(" +
                "super=" + super.toString() +
                ", ip=" + ip +
                ", sdkData=" + sdkData +
                ")";
    }
}
