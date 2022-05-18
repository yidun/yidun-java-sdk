package com.netease.yidun.sdk.antispam.media.v2;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.media.v2.callback.request.MediaCallbackRequestV2;
import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.antispam.media.v2.query.request.MediaQueryRequestV2;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 融媒体获取结果client
 */
public class MediaQueryClient extends AntispamClient {

    public MediaQueryClient(ClientProfile profile) {
        super(profile);
    }

    public MediaCallbackResponseV2 callback(MediaCallbackRequestV2 request) {
        return client.execute(request);
    }

    public MediaCallbackResponseV2 query(MediaQueryRequestV2 request) {
        return client.execute(request);
    }

}
