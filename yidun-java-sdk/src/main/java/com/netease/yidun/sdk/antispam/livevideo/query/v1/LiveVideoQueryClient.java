package com.netease.yidun.sdk.antispam.livevideo.query.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

public class LiveVideoQueryClient {
    private final Client client;

    public LiveVideoQueryClient(Client client) {
        this.client = client;
    }

    public LiveVideoQueryClient(String secretId, String secretKey) {
        this(DefaultClient.createDefault(secretId, secretKey));
    }

    public LiveVideoQueryClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client client() {
        return client;
    }

    public Client getClient() {
        return client;
    }



    @Override
    public String toString() {
        return "LiveVideoQueryClient("
                + "client=" + client
                + ")";
    }
}
