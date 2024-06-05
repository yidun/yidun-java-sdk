/*
 * @(#) AigcStreamCallbackResponseV1.java 2024-06-04
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.stream.v1.callback;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.stream.v1.AigcStreamCheckResult;

/**
 * @author ruicha
 * @version 2024-06-04
 */
public class AigcStreamActiveCallbackRequestV1 extends ActiveCallbackRequest {

    private static final long serialVersionUID = 7499317521055778486L;

    public AigcStreamCheckResult parseAigcStreamCallbackData() {
        return parseCallbackData(AigcStreamCheckResult.class);
    }
}
