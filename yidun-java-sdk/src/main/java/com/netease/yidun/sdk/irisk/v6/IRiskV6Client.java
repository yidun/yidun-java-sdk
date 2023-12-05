package com.netease.yidun.sdk.irisk.v6;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.core.response.DataResponse;
import com.netease.yidun.sdk.irisk.v6.check.IRiskCheckV6Request;
import com.netease.yidun.sdk.irisk.v6.check.IRiskCheckV6Response;
import com.netease.yidun.sdk.irisk.v6.check.v600.hitinfo.HitInfo;
import com.netease.yidun.sdk.irisk.v6.check.v600.IRiskCheckV600Request;
import com.netease.yidun.sdk.irisk.v6.check.v600.IRiskCheckV600Result;
import com.netease.yidun.sdk.irisk.v6.check.v601.IRiskCheckV601Request;
import com.netease.yidun.sdk.irisk.v6.check.v602.HitInfoV602;
import com.netease.yidun.sdk.irisk.v6.check.v602.IRiskCheckV602Request;
import com.netease.yidun.sdk.irisk.v6.check.v603.IRiskCheckV603Request;
import com.netease.yidun.sdk.irisk.v6.check.v603.IRiskCheckV603Result;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpRiskInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneRiskInfo;

/**
 * 适用场景：【智能风控】在线检测V6
 */
public class IRiskV6Client {

    private final Client client;

    public IRiskV6Client(Client client) {
        this.client = client;
    }

    public IRiskV6Client(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(new IRiskCheckV6Request(null));

        client = new DefaultClient(profile);
    }

    public IRiskV6Client(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    public IRiskCheckV6Response check(IRiskCheckV6Request request) {
        return client.execute(request);
    }

    public DataResponse<IRiskCheckV600Result<HitInfo>> check(IRiskCheckV600Request request) {
        return client.execute(request);
    }

    public DataResponse<IRiskCheckV600Result<HitInfo>> check(IRiskCheckV601Request request) {
        return client.execute(request);
    }

    public DataResponse<IRiskCheckV600Result<HitInfoV602>> check(IRiskCheckV602Request request) {
        return client.execute(request);
    }

    public DataResponse<IRiskCheckV603Result<HitInfoV602, PhoneInfo<PhoneBasicInfo, PhoneRiskInfo>, IpInfo<IpBasicInfo, IpRiskInfo>>> check(
            IRiskCheckV603Request request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "IRiskCheckV6Client("
                + "client=" + client
                + ")";
    }
}
