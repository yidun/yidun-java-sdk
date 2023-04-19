package com.netease.yidun.sdk.mobileverify.oneclicklogin.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

/**
 * 适用场景：一键登录
 */
public class OneClickLoginClient {

    private final Client client;

    public OneClickLoginClient(Client client) {
        this.client = client;
    }

    public OneClickLoginClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(new MobileNumberGetRequest(null));

        client = new DefaultClient(profile);
    }

    public OneClickLoginClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 获取手机号
     */
    public MobileNumberGetResponse getMobileNumber(MobileNumberGetRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "OneClickLoginClient("
                + "client=" + client
                + ")";
    }
}
