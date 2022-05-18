package com.netease.yidun.sdk.antispam.media.v2;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.media.v2.submit.request.MediaSubmitRequestV2;
import com.netease.yidun.sdk.antispam.media.v2.submit.response.MediaCheckResponseV2;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 融媒体检测client
 */
public class MediaCheckClient extends AntispamClient {

    public MediaCheckClient(ClientProfile profile) {
        super(profile);
    }

    public MediaCheckResponseV2 submit(MediaSubmitRequestV2 request) {
        return client.execute(request);
    }

}
