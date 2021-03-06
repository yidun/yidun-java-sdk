

package com.netease.yidun.sdk.antispam.video;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.video.callback.v4.VideoCallback;
import com.netease.yidun.sdk.antispam.video.callback.v4.request.VideoCallbackV4Req;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackV4Resp;
import com.netease.yidun.sdk.antispam.video.query.v1.request.VideoImageQueryReq;
import com.netease.yidun.sdk.antispam.video.query.v1.request.VideoTaskIdQueryReq;
import com.netease.yidun.sdk.antispam.video.query.v1.response.VideoImageQueryResp;
import com.netease.yidun.sdk.antispam.video.query.v1.response.VideoTaskIdQueryResp;
import com.netease.yidun.sdk.antispam.video.submit.v4.request.VideoCheckReq;
import com.netease.yidun.sdk.antispam.video.submit.v4.response.VideoCheckResp;
import com.netease.yidun.sdk.core.utils.AssertUtils;


public class VideoClient {

    private AntispamRequester requester;

    public VideoClient(AntispamRequester requester) {
        AssertUtils.notNull(requester, "requester can not be null");
        this.requester = requester;
    }

    public VideoClient(AntispamRequester requester, VideoCallback videoCallback) {
        AssertUtils.notNull(requester, "requester can not be null");

        this.requester = requester;
        if (videoCallback != null) {
            if (videoCallback.getAntispamRequester() == null) {
                videoCallback.setAntispamRequester(requester);
            }
            videoCallback.start();
        }
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
