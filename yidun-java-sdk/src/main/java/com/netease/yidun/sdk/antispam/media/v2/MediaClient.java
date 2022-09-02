package com.netease.yidun.sdk.antispam.media.v2;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.media.v2.callback.MediaCallback;
import com.netease.yidun.sdk.antispam.media.v2.callback.request.MediaCallbackRequestV2;
import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.antispam.media.v2.query.request.MediaQueryRequestV2;
import com.netease.yidun.sdk.antispam.media.v2.submit.request.MediaSubmitRequestV2;
import com.netease.yidun.sdk.antispam.media.v2.submit.response.MediaCheckResponseV2;

/**
 * 融媒体client
 */
public class MediaClient extends BaseClient {

    public MediaClient(AntispamRequester mediaRequester) {
        super(mediaRequester);
    }

    public MediaClient(AntispamRequester mediaRequester, MediaCallback mediaCallback) {
        super(mediaRequester, mediaCallback);
    }

    public MediaCheckResponseV2 submit(MediaSubmitRequestV2 request) {
        return requester.getMediaCheckClient().submit(request);
    }

    public MediaCallbackResponseV2 callback(MediaCallbackRequestV2 request) {
        return requester.getMediaQueryClient().callback(request);
    }

    public MediaCallbackResponseV2 query(MediaQueryRequestV2 request) {
        return requester.getMediaQueryClient().query(request);
    }

}
