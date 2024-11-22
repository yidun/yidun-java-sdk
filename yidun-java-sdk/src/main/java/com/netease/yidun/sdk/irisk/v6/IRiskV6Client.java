package com.netease.yidun.sdk.irisk.v6;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.core.response.DataResponse;
import com.netease.yidun.sdk.irisk.ClientRegistry;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckRequest;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailRequest;
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
import com.netease.yidun.sdk.irisk.v6.detail.IRiskDetailV6Request;
import com.netease.yidun.sdk.irisk.v6.detail.IRiskDetailV6Response;

/**
 * 适用场景：【智能风控】在线检测V6, 数据查询V6
 */
public class IRiskV6Client {

    private final Client client;

    public IRiskV6Client(Client client) {
        this.client = client;
    }
    public IRiskV6Client(ClientProfile profile){this(new DefaultClient(profile));}
    public static IRiskV6Client getInstance(String secretId, String secretKey) {
        //通过ClientProfile注册器返回ClientProfile实例，保证同一个secretId使用同一个实例
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(
                        new IRiskCheckV6Request(null),
                        new IRiskDetailV6Request(null));
        return ClientRegistry.register(profile, IRiskV6Client.class);
    }

    public static IRiskV6Client getInstance(ClientProfile profile) {
        return ClientRegistry.register(profile, IRiskV6Client.class);
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

    public IRiskDetailV6Response detailV6(IRiskDetailV6Request request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "IRiskCheckV6Client("
                + "client=" + client
                + ")";
    }
}
