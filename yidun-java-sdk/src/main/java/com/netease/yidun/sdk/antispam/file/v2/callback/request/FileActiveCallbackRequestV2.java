package com.netease.yidun.sdk.antispam.file.v2.callback.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;

/**
 * 文档主动回调实体
 */
public class FileActiveCallbackRequestV2 extends ActiveCallbackRequest {

    private static final long serialVersionUID = -2354090338754448434L;

    public FileCallbackV2Response.FileCallbackV2Resp parseFileCallbackData() {
        return parseCallbackData(FileCallbackV2Response.FileCallbackV2Resp.class);
    }

}
