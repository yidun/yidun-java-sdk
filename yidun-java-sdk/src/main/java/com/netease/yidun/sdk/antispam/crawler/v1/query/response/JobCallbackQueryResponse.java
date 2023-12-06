/*
 * @(#) JobCallbackQueryResponse.java 2023-12-05
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.crawler.v1.query.response;

import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.common.Page;
import com.netease.yidun.sdk.core.response.CommonResponse;


/**
 * @author xietieli
 * @version 2023-12-05
 */
public class JobCallbackQueryResponse extends CommonResponse {

    private Page<MediaCallbackResponseV2.MediaCheckResult> result;

    public Page<MediaCallbackResponseV2.MediaCheckResult> getResult() {
        return result;
    }

    public void setResult(Page<MediaCallbackResponseV2.MediaCheckResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JobCallbackQueryResponse{" +
                "result=" + result +
                '}';
    }
}
