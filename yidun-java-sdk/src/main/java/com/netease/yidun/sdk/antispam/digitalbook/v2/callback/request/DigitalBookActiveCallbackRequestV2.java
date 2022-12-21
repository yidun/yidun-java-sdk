package com.netease.yidun.sdk.antispam.digitalbook.v2.callback.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response.DigitalBookCallbackResponseV2;

/**
 * 数字阅读主动回调实体
 */
public class DigitalBookActiveCallbackRequestV2 extends ActiveCallbackRequest {

    private static final long serialVersionUID = -2354090338754448434L;

    public DigitalBookCallbackResponseV2.DigitalBookCheckResult parseDigitalBookCallbackData() {
        return parseCallbackData(DigitalBookCallbackResponseV2.DigitalBookCheckResult.class);
    }

}
