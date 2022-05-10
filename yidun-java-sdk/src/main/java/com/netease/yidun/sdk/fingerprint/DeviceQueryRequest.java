/*
 * @(#) DeviceQueryRequest.java 2022-05-10
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.fingerprint;

import com.netease.yidun.sdk.core.http.HttpHeaders;
import com.netease.yidun.sdk.core.request.BizPostJsonRequest;

import javax.validation.constraints.NotBlank;
import java.util.Map;


public class DeviceQueryRequest extends BizPostJsonRequest<DeviceQueryResponse> {

    /**
     * 上传设备数据时，指纹服务返回的token。也可能是客户端在超时场景下生产的超时token（包含设备数据）
     */
    @NotBlank(message = "token不能为空")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DeviceQueryRequest token(String token) {
        this.token = token;
        return this;
    }

    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        headers.put(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8");
        return headers;
    }

    public DeviceQueryRequest(String businessId) {
        productCode = "fingerprint";
        version = "v1";
        uriPattern = "/v1/device/query";
        this.businessId = businessId;
    }

    @Override
    public Class<DeviceQueryResponse> getResponseClass() {
        return DeviceQueryResponse.class;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("token", token);
        return params;
    }
}
