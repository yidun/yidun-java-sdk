package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.irisk.ClientRegistry;
import com.netease.yidun.sdk.irisk.v1.antigold.IRiskAntiGoldCheckRequest;
import com.netease.yidun.sdk.irisk.v1.antigold.IRiskAntiGoldCheckResponse;
import com.netease.yidun.sdk.irisk.v1.dispose.IRiskDisposeUploadRequest;
import com.netease.yidun.sdk.irisk.v1.dispose.IRiskDisposeUploadResponse;
import com.netease.yidun.sdk.irisk.v1.list.*;
import com.netease.yidun.sdk.irisk.v1.mediacheck.*;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckRequest;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckResponse;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigRequest;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigResponse;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailRequest;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailResponse;
import com.netease.yidun.sdk.irisk.v1.report.IRiskReportDataRequest;
import com.netease.yidun.sdk.irisk.v1.report.IRiskReportDataResponse;
import com.netease.yidun.sdk.irisk.v6.IRiskV6Client;


/**
 * 适用场景：【智能风控】在线检测、数据查询、配置拉取、图片外挂识别
 */
public class IRiskClient {

    private final Client client;

    public IRiskClient(Client client) {
        this.client = client;
    }
    public IRiskClient(ClientProfile profile){this(new DefaultClient(profile));}
    public static IRiskClient getInstance(String secretId, String secretKey) {
        //通过ClientProfile注册器返回ClientProfile实例，保证同一个secretId使用同一个实例
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(
                        new IRiskCheckRequest(null),
                        new IRiskDetailRequest(null));

        return ClientRegistry.register(profile, IRiskClient.class);
    }
    public static IRiskClient getInstance(ClientProfile profile) {
        return ClientRegistry.register(profile, IRiskClient.class);
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

    public IRiskMediaQueryResponse mediaQuery(IRiskMediaQueryRequest request) {
        return client.execute(request);
    }

    public IRiskMediaBatchQueryResponse mediaBatchQuery(IRiskMediaBatchQueryRequest request) {
        return client.execute(request);
    }

    public IRiskConfigResponse getConfig(IRiskConfigRequest request) {
        return client.execute(request);
    }

    public IRiskDetailResponse getDetail(IRiskDetailRequest request) {
        return client.execute(request);
    }

    public IRiskDisposeUploadResponse disposeUpload(IRiskDisposeUploadRequest request) {
        return client.execute(request);
    }

    public IRiskAntiGoldCheckResponse antiGoldCheck(IRiskAntiGoldCheckRequest request) {
        return client.execute(request);
    }

    public IRiskReportDataResponse reportData(IRiskReportDataRequest request) {
        return client.execute(request);
    }

    public IRiskListQueryResponse listQuery(IRiskListQueryRequest request) {
        return client.execute(request);
    }

    public IRiskListAddResponse listAdd(IRiskListAddRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "IRiskCheckClient("
                + "client=" + client
                + ")";
    }
}
