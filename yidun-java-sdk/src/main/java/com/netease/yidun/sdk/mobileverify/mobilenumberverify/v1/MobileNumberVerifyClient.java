package com.netease.yidun.sdk.mobileverify.mobilenumberverify.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

/**
 * 适用场景：本机号码校验
 */
public class MobileNumberVerifyClient {

    private final Client client;

    public MobileNumberVerifyClient(Client client) {
        this.client = client;
    }

    public MobileNumberVerifyClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(new MobileNumberVerifyRequest(null));

        client = new DefaultClient(profile);
    }

    public MobileNumberVerifyClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 验证本机号码是否与指定的号码相同
     */
    public MobileNumberVerifyResponse verifyMobileNumber(MobileNumberVerifyRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "MobileNumberVerifyClient("
                + "client=" + client
                + ")";
    }
}
