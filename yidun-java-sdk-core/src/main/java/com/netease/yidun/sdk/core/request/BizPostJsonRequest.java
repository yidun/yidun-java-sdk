/*
 * @(#) BizPostJsonRequest.java 2022-05-10
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.request;

import com.netease.yidun.sdk.core.response.BaseResponse;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import java.util.Map;

/**
 * 这是对 {@link PostJsonRequest} 的扩展。适用于和具体业务绑定的子服务。如果子服务只和产品绑定，则可以使用 {@link PostJsonRequest}
 */
public abstract class BizPostJsonRequest<T extends BaseResponse> extends PostJsonRequest<T> {

    @NotBlank(message = "businessId不能为空")
    protected String businessId;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String businessId() {
        return businessId;
    }

    public BizPostJsonRequest<T> businessId(String businessId) {
        this.businessId = businessId;
        return this;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("businessId", businessId);
        return params;
    }

    @Override
    public String toString() {
        return "BizPostJsonRequest(" +
                "super=" + super.toString() +
                ", businessId=" + businessId +
                ")";
    }
}
