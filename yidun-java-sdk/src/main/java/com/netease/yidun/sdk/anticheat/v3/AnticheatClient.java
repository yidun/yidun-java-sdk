package com.netease.yidun.sdk.anticheat.v3;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

public class AnticheatClient {

    private final Client client;

    public AnticheatClient(Client client) {
        this.client = client;
    }

    public AnticheatClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(new AnticheatCheckRequest(null));

        client = new DefaultClient(profile);
    }

    public AnticheatClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    public AnticheatCheckResponse check(AnticheatCheckRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "AnticheatClient("
                + "client=" + client
                + ")";
    }
}
