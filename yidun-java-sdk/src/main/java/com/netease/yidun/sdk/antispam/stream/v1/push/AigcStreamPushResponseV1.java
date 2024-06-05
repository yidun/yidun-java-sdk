/*
 * @(#) AigcStreamPushResponseV1.java 2024-06-03
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.stream.v1.push;

import com.netease.yidun.sdk.antispam.stream.v1.AigcStreamCheckResult;
import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * @author ruicha
 * @version 2024-06-03
 */
public class AigcStreamPushResponseV1 extends CommonResponse {
    
    private AigcStreamCheckResult result;
    
    public AigcStreamCheckResult getResult() {
        return result;
    }

    public void setResult(AigcStreamCheckResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AigcStreamPushResponseV1{" +
                "result=" + result +
                "} " + super.toString();
    }
}
