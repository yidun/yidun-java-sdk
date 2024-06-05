/*
 * @(#) AigcStreamCallbackResponseV1.java 2024-06-04
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.stream.v1.callback;

import com.netease.yidun.sdk.antispam.stream.v1.AigcStreamCheckResult;
import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;

/**
 * @author ruicha
 * @version 2024-06-04
 */
public class AigcStreamCallbackResponseV1 extends CommonResponse {
    
    private List<AigcStreamCheckResult> result;

    public List<AigcStreamCheckResult> getResult() {
        return result;
    }

    public void setResult(List<AigcStreamCheckResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AigcStreamCallbackResponseV1{" +
                "result=" + result +
                "} " + super.toString();
    }
}
