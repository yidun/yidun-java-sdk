/*
 * @(#) AigcStreamCheckClient.java 2024-06-03
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.stream.v1;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.stream.v1.push.AigcStreamPushRequestV1;
import com.netease.yidun.sdk.antispam.stream.v1.push.AigcStreamPushResponseV1;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * @author ruicha
 * @version 2024-06-03
 */
public class AigcStreamPushClient extends AntispamClient {

    public AigcStreamPushClient(ClientProfile profile) {
        super(profile);
    }

    public AigcStreamPushResponseV1 push(AigcStreamPushRequestV1 request) {
        return client.execute(request);
    }

    @Override
    protected String clientName() {
        return "AigcStreamPush";
    }
    
}
