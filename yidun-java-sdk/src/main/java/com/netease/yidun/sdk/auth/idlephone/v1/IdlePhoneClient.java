package com.netease.yidun.sdk.auth.idlephone.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

/**
 * 号码状态检测
 */
public class IdlePhoneClient {

    private final Client client;

    public IdlePhoneClient(Client client) {
        this.client = client;
    }

    public IdlePhoneClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(new IdlePhoneCheckRequest(null));

        client = new DefaultClient(profile);
    }

    public IdlePhoneClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 执行号码状态检测
     */
    public IdlePhoneCheckResponse check(IdlePhoneCheckRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "IdCardClient(" +
                "client=" + client +
                ")";
    }
}
