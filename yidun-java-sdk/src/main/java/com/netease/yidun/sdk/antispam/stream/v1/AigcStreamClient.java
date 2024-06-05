/*
 * @(#) AigcStreamClient.java 2024-06-03
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.stream.v1;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.CallbackRegistry;
import com.netease.yidun.sdk.antispam.ClientRegistry;
import com.netease.yidun.sdk.antispam.stream.v1.callback.AigcStreamCallback;
import com.netease.yidun.sdk.antispam.stream.v1.callback.AigcStreamCallbackRequestV1;
import com.netease.yidun.sdk.antispam.stream.v1.callback.AigcStreamCallbackResponseV1;
import com.netease.yidun.sdk.antispam.stream.v1.push.AigcStreamPushRequestV1;
import com.netease.yidun.sdk.antispam.stream.v1.push.AigcStreamPushResponseV1;

/**
 * AigcStreamClient
 * @author ruicha
 * @version 2024-06-03
 */
public class AigcStreamClient extends BaseClient {

    /**
     * 获取secretId对应的唯一实例
     *
     * @param requester
     * @return
     */
    public static AigcStreamClient getInstance(AntispamRequester requester) {
        return ClientRegistry.register(requester, AigcStreamClient.class);
    }

    /**
     * 获取secretId对应的唯一实例
     *
     * @param requester
     * @param aigcStreamCallbacks
     * @return
     */
    public static AigcStreamClient getInstance(AntispamRequester requester, AigcStreamCallback... aigcStreamCallbacks) {
        CallbackRegistry.register(requester, aigcStreamCallbacks);
        return ClientRegistry.register(requester, AigcStreamClient.class);
    }
    
    public AigcStreamClient(AntispamRequester requester) {
        super(requester);
    }

    public AigcStreamClient(AntispamRequester requester, AigcStreamCallback callback) {
        super(requester, callback);
    }

    public AigcStreamClient(AntispamRequester requester, AigcStreamCallback... callbacks) {
        super(requester, callbacks);
    }
    
    public AigcStreamPushResponseV1 push(AigcStreamPushRequestV1 request) {
        return requester.getAigcStreamPushClient().push(request);
    }

    public AigcStreamCallbackResponseV1 callback(AigcStreamCallbackRequestV1 request) {
        return requester.getAigcStreamCommonClient().callback(request);
    }
}
