package com.netease.yidun.sdk.antispam.video;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.video.submit.v4.request.VideoCheckReq;
import com.netease.yidun.sdk.antispam.video.submit.v4.response.VideoCheckResp;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class VideoCheckClient extends AntispamClient {

    public VideoCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }


    public VideoCheckResp check(VideoCheckReq request) {
        return client.execute(request);
    }

}
