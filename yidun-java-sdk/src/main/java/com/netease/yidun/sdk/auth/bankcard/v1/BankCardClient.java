package com.netease.yidun.sdk.auth.bankcard.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

/**
 * 适用场景：银行卡认证
 */
public class BankCardClient {

    private final Client client;

    public BankCardClient(Client client) {
        this.client = client;
    }

    public BankCardClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(new BankCardCheckRequest(null));

        client = new DefaultClient(profile);
    }

    public BankCardClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 校验银行卡相关信息
     */
    public BankCardResponse check(BankCardCheckRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "BankCardClient(" +
                "client=" + client +
                ")";
    }
}
