package com.netease.yidun.sdk.antispam;

import com.netease.yidun.sdk.antispam.recover.DefaultRequestRecover;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

public class AntispamClient {
    protected Client client;

    public AntispamClient(ClientProfile clientProfile) {
        client = new DefaultClient(clientProfile);
        if (clientProfile.getRequestRecover() != null && clientProfile.getRequestRecover() instanceof DefaultRequestRecover) {
            ((DefaultRequestRecover) clientProfile.getRequestRecover()).setClient(client);
        }
    }
}
