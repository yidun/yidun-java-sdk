package com.netease.yidun.sdk.antispam.livevideo.callback.v4.request;

import java.util.Map;

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

    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public LiveVideoCallbackReq() {
        productCode = "liveVideo";
        uriPattern = "/v4/livevideo/callback/results";
        version = "v4";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        if (yidunRequestId != null) {
            params.put("yidunRequestId", getYidunRequestId());
        }
        return params;
    }

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }
    @Override
    public Class<LiveVideoCallbackResp> getResponseClass() {
        return LiveVideoCallbackResp.class;
    }
}
