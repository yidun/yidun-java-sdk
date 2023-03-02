package com.netease.yidun.sdk.profile.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.profile.v1.check.ProfileCheckRequest;
import com.netease.yidun.sdk.profile.v1.check.ProfileCheckResponse;
import com.netease.yidun.sdk.profile.v1.ipquery.ProfileIpQueryRequest;
import com.netease.yidun.sdk.profile.v1.ipquery.ProfileIpQueryResponse;
import com.netease.yidun.sdk.profile.v1.phonequery.ProfilePhoneQueryRequest;
import com.netease.yidun.sdk.profile.v1.phonequery.ProfilePhoneQueryResponse;
import com.netease.yidun.sdk.profile.v1.riskquery.ProfileRiskQueryRequest;
import com.netease.yidun.sdk.profile.v1.riskquery.ProfileRiskQueryResponse;
import com.netease.yidun.sdk.profile.v1.userquery.ProfileUserQueryRequest;
import com.netease.yidun.sdk.profile.v1.userquery.ProfileUserQueryResponse;

/**
 * 适用场景：【风险画像】
 */
public class ProfileClient {

    private final Client client;

    public ProfileClient(Client client) {
        this.client = client;
    }

    public ProfileClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(
                        new ProfileCheckRequest(null),
                        new ProfileIpQueryRequest(null),
                        new ProfilePhoneQueryRequest(null),
                        new ProfileRiskQueryRequest(),
                        new ProfileUserQueryRequest(null));
        client = new DefaultClient(profile);
    }

    public ProfileClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public ProfileCheckResponse check(ProfileCheckRequest request) {
        return client.execute(request);
    }

    public ProfileIpQueryResponse ipQuery(ProfileIpQueryRequest request) {
        return client.execute(request);
    }

    public ProfileUserQueryResponse userQuery(ProfileUserQueryRequest request) {
        return client.execute(request);
    }

    public ProfilePhoneQueryResponse phoneQuery(ProfilePhoneQueryRequest request) {
        return client.execute(request);
    }

    public ProfileRiskQueryResponse riskQuery(ProfileRiskQueryRequest request) {
        return client.execute(request);
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    @Override
    public String toString() {
        return "ProfileClient(" +
                "client=" + client +
                ")";
    }
}
