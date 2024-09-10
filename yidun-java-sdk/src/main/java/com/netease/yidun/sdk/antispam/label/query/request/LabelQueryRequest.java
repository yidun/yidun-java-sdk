/*
 * @(#) LabelQueryRequest.java 2023-03-14
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.label.query.request;

import com.netease.yidun.sdk.antispam.enums.LabelBusinessTypeEnum;
import com.netease.yidun.sdk.antispam.label.query.response.LabelQueryResponse;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.core.request.OpenApiGetRequest;
import com.netease.yidun.sdk.core.utils.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author zhuliyang02
 * @version 2023-03-14
 */
public class LabelQueryRequest extends OpenApiGetRequest<LabelQueryResponse> {

    /**
     * 默认返回二级标签
     */
    private static final Integer DEFAULT_DEPTH = 2;

    /**
     * 客户ID
     */
    @Deprecated
    private String clientId;

    /**
     * @see LabelBusinessTypeEnum
     */
    private List<String> businessTypes;

    /**
     * 业务ID
     */
    private String businessId;

    /**
     * 最大标签层级
     */
    private Integer maxDepth = DEFAULT_DEPTH;
    /**
     * 是否获取客户维度的标签
     */
    private Boolean fetchClientLabel;

    public LabelQueryRequest() {
        productCode = "label";
        uriPattern = "/openapi/v2/antispam/label/query";
        domain = "openapi.dun.163.com";
        protocol = ProtocolEnum.HTTPS;
        method = HttpMethodEnum.GET;
    }

    public String getClientId() {
        return clientId;
    }

    public List<String> getBusinessTypes() {
        return businessTypes;
    }

    public String getBusinessId() {
        return businessId;
    }

    public Integer getMaxDepth() {
        return maxDepth;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setBusinessTypes(List<String> businessTypes) {
        this.businessTypes = businessTypes;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public void setMaxDepth(Integer maxDepth) {
        this.maxDepth = maxDepth;
    }

    public Boolean getFetchClientLabel() {
        return fetchClientLabel;
    }

    public void setFetchClientLabel(Boolean fetchClientLabel) {
        this.fetchClientLabel = fetchClientLabel;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("clientId", clientId);
        params.put("businessId", businessId);
        params.put("fetchClientLabel", Boolean.TRUE.equals(fetchClientLabel) ? "true" : "false");
        params.put("maxDepth", String.valueOf(maxDepth));
        params.put("businessTypes", StringUtils.join(businessTypes, ","));
        return params;
    }

    @Override
    public String toString() {
        return "LabelQueryRequest{" +
                "clientId='" + clientId + '\'' +
                ", businessTypes=" + businessTypes +
                ", businessId='" + businessId + '\'' +
                ", fetchClientLabel='" + fetchClientLabel + '\'' +
                ", maxDepth=" + maxDepth +
                '}';
    }

    @Override
    public Class<LabelQueryResponse> getResponseClass() {
        return LabelQueryResponse.class;
    }
}
