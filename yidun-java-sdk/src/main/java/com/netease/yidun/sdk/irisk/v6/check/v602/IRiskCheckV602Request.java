package com.netease.yidun.sdk.irisk.v6.check.v602;

import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.netease.yidun.sdk.core.response.DataResponse;
import com.netease.yidun.sdk.irisk.v6.check.v600.IRiskCheckV600Result;
import com.netease.yidun.sdk.irisk.v6.check.v601.IRiskCheckV601PureRequest;

public class IRiskCheckV602Request extends IRiskCheckV601PureRequest<DataResponse<IRiskCheckV600Result<HitInfoV602>>> {

    public IRiskCheckV602Request(String businessId) {
        productCode = "irisk";
        version = "602";
        uriPattern = "/v6/risk/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        return customSignParams;
    }

    @Override
    public Class<DataResponse<IRiskCheckV600Result<HitInfoV602>>> getResponseClass() {
        return null;
    }

    @Override
    public java.lang.reflect.Type getResponseType() {
        return new TypeToken<DataResponse<IRiskCheckV600Result<HitInfoV602>>>() {}.getType();
    }
}
