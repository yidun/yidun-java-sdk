package com.netease.yidun.sdk.antispam.media.v2;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.CallbackRegistry;
import com.netease.yidun.sdk.antispam.ClientRegistry;
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

    /**
     * 获取secretId对应的唯一实例
     *
     * @param mediaRequester
     * @return
     */
    public static MediaClient getInstance(AntispamRequester mediaRequester) {
        return ClientRegistry.register(mediaRequester, MediaClient.class);
    }

    /**
     * 获取secretId对应的唯一实例
     *
     * @param mediaRequester
     * @param mediaCallback
     * @return
     */
    public static MediaClient getInstance(AntispamRequester mediaRequester, MediaCallback mediaCallback) {
        CallbackRegistry.register(mediaRequester, mediaCallback);
        return ClientRegistry.register(mediaRequester, MediaClient.class);
    }


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
