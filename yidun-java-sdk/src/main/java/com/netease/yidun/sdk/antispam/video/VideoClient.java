

package com.netease.yidun.sdk.antispam.video;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.CallbackRegistry;
import com.netease.yidun.sdk.antispam.ClientRegistry;
import com.netease.yidun.sdk.antispam.video.callback.v4.VideoCallback;
import com.netease.yidun.sdk.antispam.video.callback.v4.request.VideoCallbackV4Req;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackV4Resp;
import com.netease.yidun.sdk.antispam.video.query.v1.request.VideoImageQueryReq;
import com.netease.yidun.sdk.antispam.video.query.v1.request.VideoTaskIdQueryReq;
import com.netease.yidun.sdk.antispam.video.query.v1.response.VideoImageQueryResp;
import com.netease.yidun.sdk.antispam.video.query.v1.response.VideoTaskIdQueryResp;
import com.netease.yidun.sdk.antispam.video.submit.v4.request.VideoCheckReq;
import com.netease.yidun.sdk.antispam.video.submit.v4.response.VideoCheckResp;


public class VideoClient extends BaseClient {

    /**
     * 获取secretId对应的唯一实例
     *
     * @param requester
     * @return
     */
    public static VideoClient getInstance(AntispamRequester requester) {
        return ClientRegistry.register(requester, VideoClient.class);
    }

    /**
     * 获取secretId对应的唯一实例
     *
     * @param requester
     * @param videoCallback
     * @return
     */
    public static VideoClient getInstance(AntispamRequester requester, VideoCallback... videoCallback) {
        CallbackRegistry.register(requester, videoCallback);
        return ClientRegistry.register(requester, VideoClient.class);
    }

    public VideoClient(AntispamRequester requester) {
        super(requester);
    }

    public VideoClient(AntispamRequester requester, VideoCallback videoCallback) {
        super(requester, videoCallback);
    }

    public VideoClient(AntispamRequester requester, VideoCallback... videoCallback) {
        super(requester, videoCallback);
    }


    public VideoCheckResp check(VideoCheckReq request) {
        return requester.getVideoCheckClient().check(request);
    }

    public VideoCallbackV4Resp callback(VideoCallbackV4Req request) {
        return requester.getVideoCommonClient().callback(request);
    }

    public VideoImageQueryResp query(VideoImageQueryReq request) {
        return requester.getVideoCommonClient().query(request);
    }

    public VideoTaskIdQueryResp query(VideoTaskIdQueryReq request) {
        return requester.getVideoCommonClient().query(request);
    }

}
