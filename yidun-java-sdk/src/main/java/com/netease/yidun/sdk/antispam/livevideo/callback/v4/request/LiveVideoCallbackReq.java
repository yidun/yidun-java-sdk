package com.netease.yidun.sdk.antispam.livevideo.callback.v4.request;

import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveVideoCallbackResp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * 视频直播回调请求
 */
@Getter
@Setter
public class LiveVideoCallbackReq extends BizPostFormRequest<LiveVideoCallbackResp> {

    public LiveVideoCallbackReq() {
        productCode = "liveVideo";
        uriPattern = "/v4/livevideo/callback/results";
        version = "v4";
    }

    @Override
    public Class<LiveVideoCallbackResp> getResponseClass() {
        return LiveVideoCallbackResp.class;
    }
}
