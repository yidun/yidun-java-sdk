package com.netease.yidun.sdk.captcha.v2;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

public class CaptchaClient {

    private final Client client;

    public CaptchaClient(Client client) {
        this.client = client;
    }

    public CaptchaClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestClassesForValidation(CaptchaVerifyRequest.class);

        client = new DefaultClient(profile);
    }

    public CaptchaClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    public CaptchaVerifyResponse verify(CaptchaVerifyRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "CaptchaClient("
                + "client=" + client
                + ")";
    }
}
