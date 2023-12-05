package com.netease.yidun.sdk.irisk.v6.check.v601;

import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.netease.yidun.sdk.core.response.DataResponse;
import com.netease.yidun.sdk.irisk.v6.check.v600.hitinfo.HitInfo;
import com.netease.yidun.sdk.irisk.v6.check.v600.IRiskCheckV600Result;

public class IRiskCheckV601Request extends IRiskCheckV601PureRequest<DataResponse<IRiskCheckV600Result<HitInfo>>> {

    public IRiskCheckV601Request(String businessId) {
        productCode = "irisk";
        version = "601";
        uriPattern = "/v6/risk/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        return customSignParams;
    }

    @Override
    public Class<DataResponse<IRiskCheckV600Result<HitInfo>>> getResponseClass() {
        return null;
    }

    @Override
    public java.lang.reflect.Type getResponseType() {
        return new TypeToken<DataResponse<IRiskCheckV600Result<HitInfo>>>() {}.getType();
    }
}
