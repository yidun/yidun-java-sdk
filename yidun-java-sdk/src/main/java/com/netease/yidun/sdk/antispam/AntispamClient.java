package com.netease.yidun.sdk.antispam;

import com.netease.yidun.sdk.antispam.recover.DefaultRequestRecover;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.core.response.BaseResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AntispamClient {
    protected Client client;

    public AntispamClient(ClientProfile clientProfile) {
        client = new DefaultClient(clientProfile);
    }

    protected String clientName() {
        return null;
    }

}
