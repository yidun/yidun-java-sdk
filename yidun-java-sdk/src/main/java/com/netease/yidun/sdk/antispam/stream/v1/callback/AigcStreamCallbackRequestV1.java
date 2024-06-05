/*
 * @(#) AigcStreamCallbackResponseV1.java 2024-06-04
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.stream.v1.callback;

import com.netease.yidun.sdk.core.request.PostFormRequest;

/**
 * @author ruicha
 * @version 2024-06-04
 */
public class AigcStreamCallbackRequestV1 extends PostFormRequest<AigcStreamCallbackResponseV1>  {

    public AigcStreamCallbackRequestV1() {
        productCode = "aigcStream";
        version = "v1.0";
        uriPattern = "/v1/stream/callback/results";
    }

    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }

    @Override
    public Class<AigcStreamCallbackResponseV1> getResponseClass() {
        return AigcStreamCallbackResponseV1.class;
    }
}
