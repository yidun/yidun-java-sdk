package com.netease.yidun.sdk.antispam.grammarfix;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.grammarfix.v1.submit.GrammarfixSubmitRequest;
import com.netease.yidun.sdk.antispam.grammarfix.v1.submit.GrammarfixSubmitResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class GrammarfixCommonClient extends AntispamClient {

    public GrammarfixCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public GrammarfixSubmitResponse submit(GrammarfixSubmitRequest request) {
        return client.execute(request);
    }
}
