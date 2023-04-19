package com.netease.yidun.sdk.auth.mobilenumber;

import com.netease.yidun.sdk.auth.mobilenumber.idname.v1.MobileNumberOwnerIdNameCheckRequest;
import com.netease.yidun.sdk.auth.mobilenumber.idname.v1.MobileNumberOwnerIdNameCheckResponse;
import com.netease.yidun.sdk.auth.mobilenumber.name.v1.MobileNumberOwnerNameCheckRequest;
import com.netease.yidun.sdk.auth.mobilenumber.name.v1.MobileNumberOwnerNameCheckResponse;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

/**
 * 适用场景：验证手机号所有者
 */
public class MobileNumberOwnerCheckClient {

    private final Client client;

    public MobileNumberOwnerCheckClient(Client client) {
        this.client = client;
    }

    public MobileNumberOwnerCheckClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(
                        new MobileNumberOwnerIdNameCheckRequest(null),
                        new MobileNumberOwnerNameCheckRequest(null));

        client = new DefaultClient(profile);
    }

    public MobileNumberOwnerCheckClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 验证手机号所有者姓名
     */
    public MobileNumberOwnerNameCheckResponse checkMobileNumberOwnerName(MobileNumberOwnerNameCheckRequest request) {
        return client.execute(request);
    }

    /**
     * 验证手机号所有者身份证号及姓名
     */
    public MobileNumberOwnerIdNameCheckResponse checkMobileNumberOwnerIdName(
            MobileNumberOwnerIdNameCheckRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "MobileNumberOwnerCheckClient(" +
                "client=" + client +
                ")";
    }
}
