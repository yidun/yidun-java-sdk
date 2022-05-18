package com.netease.yidun.sdk.antispam.media.v2;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.media.v2.callback.MediaCallback;
import com.netease.yidun.sdk.antispam.media.v2.callback.request.MediaCallbackRequestV2;
import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.antispam.media.v2.query.request.MediaQueryRequestV2;
import com.netease.yidun.sdk.antispam.media.v2.submit.request.MediaSubmitRequestV2;
import com.netease.yidun.sdk.antispam.media.v2.submit.response.MediaCheckResponseV2;
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 融媒体client
 */
public class MediaClient {

    private AntispamRequester mediaRequester;

    public MediaClient(AntispamRequester mediaRequester) {
        AssertUtils.notNull(mediaRequester, "mediaRequester can not be null");
        this.mediaRequester = mediaRequester;
    }

    public MediaClient(AntispamRequester mediaRequester, MediaCallback mediaCallback) {
        AssertUtils.notNull(mediaRequester, "mediaRequester can not be null");

        this.mediaRequester = mediaRequester;
        if (mediaCallback != null) {
            if (mediaCallback.getAntispamRequester() == null) {
                mediaCallback.setAntispamRequester(mediaRequester);
            }
            mediaCallback.start();
        }
    }

    public MediaCheckResponseV2 submit(MediaSubmitRequestV2 request) {
        return mediaRequester.getMediaCheckClient().submit(request);
    }

    public MediaCallbackResponseV2 callback(MediaCallbackRequestV2 request) {
        return mediaRequester.getMediaQueryClient().callback(request);
    }

    public MediaCallbackResponseV2 query(MediaQueryRequestV2 request) {
        return mediaRequester.getMediaQueryClient().query(request);
    }

}
