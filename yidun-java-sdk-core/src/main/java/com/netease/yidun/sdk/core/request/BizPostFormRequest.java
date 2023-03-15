

package com.netease.yidun.sdk.core.request;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;

import java.util.Map;

/**
 * 这是对 {@link PostFormRequest} 的扩展。适用于和具体业务绑定的子服务。如果子服务只和产品绑定，则可以使用 {@link PostFormRequest}
 */
public abstract class BizPostFormRequest<T extends BaseResponse> extends PostFormRequest<T> {

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

    public BizPostFormRequest<T> businessId(String businessId) {
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
        return "BizPostFormRequest(" +
                "super=" + super.toString() +
                ", businessId=" + businessId +
                ")";
    }
}
