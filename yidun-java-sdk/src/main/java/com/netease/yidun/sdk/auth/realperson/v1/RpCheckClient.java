package com.netease.yidun.sdk.auth.realperson.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

/**
 * 适用场景：实人认证
 */
public class RpCheckClient {

    private final Client client;

    public RpCheckClient(Client client) {
        this.client = client;
    }

    public RpCheckClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(new RpCheckRequest(null));

        client = new DefaultClient(profile);
    }

    public RpCheckClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 发起请求并获得结果
     */
    public RpCheckResponse check(RpCheckRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "RpCheckClient(" +
                "client=" + client +
                ")";
    }
}
