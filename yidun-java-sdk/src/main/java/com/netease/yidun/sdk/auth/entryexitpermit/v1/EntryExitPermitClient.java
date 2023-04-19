package com.netease.yidun.sdk.auth.entryexitpermit.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

/**
 * 适用场景：出入境证件核验
 */
public class EntryExitPermitClient {

    private final Client client;

    public EntryExitPermitClient(Client client) {
        this.client = client;
    }

    public EntryExitPermitClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(new EntryExitPermitCheckRequest(null));

        client = new DefaultClient(profile);
    }

    public EntryExitPermitClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 执行出入境证件核验
     */
    public EntryExitPermitCheckResponse check(EntryExitPermitCheckRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "EntryExitPermitClient(" +
                "client=" + client +
                ")";
    }
}
