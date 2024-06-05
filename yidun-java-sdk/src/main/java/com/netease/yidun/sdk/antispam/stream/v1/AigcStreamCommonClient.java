/*
 * @(#) AigcStreamCheckClient.java 2024-06-03
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.stream.v1;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.stream.v1.callback.AigcStreamCallbackRequestV1;
import com.netease.yidun.sdk.antispam.stream.v1.callback.AigcStreamCallbackResponseV1;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * @author ruicha
 * @version 2024-06-03
 */
public class AigcStreamCommonClient extends AntispamClient {

    public AigcStreamCommonClient(ClientProfile profile) {
        super(profile);
    }

    public AigcStreamCallbackResponseV1 callback(AigcStreamCallbackRequestV1 request) {
        return client.execute(request);
    }

    @Override
    protected String clientName() {
        return "AigcStreamCommon";
    }
    
}
