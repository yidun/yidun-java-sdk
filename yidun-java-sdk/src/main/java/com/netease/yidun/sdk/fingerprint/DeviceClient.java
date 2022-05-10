/*
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.fingerprint;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

public class DeviceClient {

    private final Client client;

    public DeviceClient(Client client) {
        this.client = client;
    }

    public DeviceClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(new DeviceQueryRequest(null));

        client = new DefaultClient(profile);
    }

    public DeviceClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    public DeviceQueryResponse query(DeviceQueryRequest deviceQueryRequest) {
        return client.execute(deviceQueryRequest);
    }

    @Override
    public String toString() {
        return "DeviceClient(" +
                "client=" + client +
                ')';
    }
}
