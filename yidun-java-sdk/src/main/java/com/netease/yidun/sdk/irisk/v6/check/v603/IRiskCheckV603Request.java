package com.netease.yidun.sdk.irisk.v6.check.v603;

import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.netease.yidun.sdk.core.response.DataResponse;
import com.netease.yidun.sdk.irisk.v6.check.v601.IRiskCheckV601PureRequest;
import com.netease.yidun.sdk.irisk.v6.check.v602.HitInfoV602;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpRiskInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneRiskInfo;

public class IRiskCheckV603Request extends
        IRiskCheckV601PureRequest<DataResponse<IRiskCheckV603Result<HitInfoV602, PhoneInfo<PhoneBasicInfo, PhoneRiskInfo>, IpInfo<IpBasicInfo, IpRiskInfo>>>> {

    public IRiskCheckV603Request(String businessId) {
        productCode = "irisk";
        version = "603";
        uriPattern = "/v6/risk/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        return customSignParams;
    }

    @Override
    public Class<DataResponse<IRiskCheckV603Result<HitInfoV602, PhoneInfo<PhoneBasicInfo, PhoneRiskInfo>, IpInfo<IpBasicInfo, IpRiskInfo>>>> getResponseClass() {
        return null;
    }

    @Override
    public java.lang.reflect.Type getResponseType() {
        return new TypeToken<DataResponse<IRiskCheckV603Result<HitInfoV602, PhoneInfo<PhoneBasicInfo, PhoneRiskInfo>, IpInfo<IpBasicInfo, IpRiskInfo>>>>() {}
                .getType();
    }
}
