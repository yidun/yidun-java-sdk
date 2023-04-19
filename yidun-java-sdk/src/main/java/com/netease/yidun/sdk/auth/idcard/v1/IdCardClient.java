package com.netease.yidun.sdk.auth.idcard.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

/**
 * 适用场景：实证认证-实名校验
 */
public class IdCardClient {

    private final Client client;

    public IdCardClient(Client client) {
        this.client = client;
    }

    public IdCardClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(new IdCardCheckRequest(null));

        client = new DefaultClient(profile);
    }

    public IdCardClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 执行实证认证-实名校验
     */
    public IdCardCheckResponse check(IdCardCheckRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "IdCardClient(" +
                "client=" + client +
                ")";
    }
}
