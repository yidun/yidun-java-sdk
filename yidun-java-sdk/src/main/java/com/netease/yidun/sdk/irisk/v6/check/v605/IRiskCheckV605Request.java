package com.netease.yidun.sdk.irisk.v6.check.v605;

import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.netease.yidun.sdk.core.response.DataResponse;
import com.netease.yidun.sdk.irisk.v6.check.v601.IRiskCheckV601PureRequest;

public class IRiskCheckV605Request extends
        IRiskCheckV601PureRequest<DataResponse<IRiskCheckV605Result>> {

    public IRiskCheckV605Request(String businessId) {
        productCode = "irisk";
        version = "605";
        uriPattern = "/v6/risk/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        return customSignParams;
    }

    @Override
    public Class<DataResponse<IRiskCheckV605Result>> getResponseClass() {
        return null;
    }

    @Override
    public java.lang.reflect.Type getResponseType() {
        return new TypeToken<DataResponse<IRiskCheckV605Result>>() {}.getType();
    }
}
