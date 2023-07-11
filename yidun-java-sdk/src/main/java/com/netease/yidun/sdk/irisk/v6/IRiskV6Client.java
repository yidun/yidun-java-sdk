package com.netease.yidun.sdk.irisk.v6;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.irisk.v6.check.IRiskCheckV6Request;
import com.netease.yidun.sdk.irisk.v6.check.IRiskCheckV6Response;

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

    @Override
    public String toString() {
        return "IRiskCheckV6Client("
                + "client=" + client
                + ")";
    }
}
