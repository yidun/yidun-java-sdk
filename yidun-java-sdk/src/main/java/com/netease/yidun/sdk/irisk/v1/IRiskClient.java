package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.irisk.v1.mediacheck.IRiskMediaCheckResponse;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckRequest;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckResponse;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigRequest;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigResponse;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailRequest;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailResponse;
import com.netease.yidun.sdk.irisk.v1.mediacheck.IRiskMediaCheckRequest;

/**
 * 适用场景：【智能风控】在线检测、数据查询、配置拉取、图片外挂识别
 */
public class IRiskClient {

    private final Client client;

    public IRiskClient(Client client) {
        this.client = client;
    }

    public IRiskClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(
                        new IRiskCheckRequest(null),
                        new IRiskMediaCheckRequest(null),
                        new IRiskConfigRequest(null),
                        new IRiskDetailRequest(null));

        client = new DefaultClient(profile);
    }

    public IRiskClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    public IRiskCheckResponse check(IRiskCheckRequest request) {
        return client.execute(request);
    }

    public IRiskMediaCheckResponse mediaCheck(IRiskMediaCheckRequest request) {
        return client.execute(request);
    }

    public IRiskConfigResponse getConfig(IRiskConfigRequest request) {
        return client.execute(request);
    }

    public IRiskDetailResponse getDetail(IRiskDetailRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "IRiskCheckClient("
                + "client=" + client
                + ")";
    }
}
