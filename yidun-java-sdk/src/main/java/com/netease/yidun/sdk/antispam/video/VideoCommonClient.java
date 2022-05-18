

package com.netease.yidun.sdk.antispam.video;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.video.callback.v4.request.VideoCallbackV4Req;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackV4Resp;
import com.netease.yidun.sdk.antispam.video.query.v1.request.VideoImageQueryReq;
import com.netease.yidun.sdk.antispam.video.query.v1.request.VideoTaskIdQueryReq;
import com.netease.yidun.sdk.antispam.video.query.v1.response.VideoImageQueryResp;
import com.netease.yidun.sdk.antispam.video.query.v1.response.VideoTaskIdQueryResp;
import com.netease.yidun.sdk.core.client.ClientProfile;


public class VideoCommonClient extends AntispamClient {
    public VideoCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public VideoCallbackV4Resp callback(VideoCallbackV4Req request) {
        return this.client.execute(request);
    }

    public VideoImageQueryResp query(VideoImageQueryReq request) {
        return client.execute(request);
    }

    public VideoTaskIdQueryResp query(VideoTaskIdQueryReq request) {
        return client.execute(request);
    }

}
