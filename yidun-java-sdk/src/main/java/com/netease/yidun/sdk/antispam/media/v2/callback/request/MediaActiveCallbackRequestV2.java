package com.netease.yidun.sdk.antispam.media.v2.callback.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;

/**
 * 融媒体主动回调实体
 */
public class MediaActiveCallbackRequestV2 extends ActiveCallbackRequest {

    private static final long serialVersionUID = -2354090338754448434L;

    public MediaCallbackResponseV2.MediaCheckResult parseMediaCallbackData() {
        return parseCallbackData(MediaCallbackResponseV2.MediaCheckResult.class);
    }

}
