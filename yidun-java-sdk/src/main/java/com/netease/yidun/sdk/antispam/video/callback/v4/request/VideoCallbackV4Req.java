package com.netease.yidun.sdk.antispam.video.callback.v4.request;

import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackV4Resp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import lombok.Getter;
import lombok.Setter;

/**
 * 点播回调接口请求 V4 版本
 */
@Getter
@Setter
public class VideoCallbackV4Req extends BizPostFormRequest<VideoCallbackV4Resp> {

    public VideoCallbackV4Req() {
        productCode = "videoCommon";
        uriPattern = "/v4/video/callback/results";
        version = "v4";
    }

    @Override
    public Class<VideoCallbackV4Resp> getResponseClass() {
        return VideoCallbackV4Resp.class;
    }
}
