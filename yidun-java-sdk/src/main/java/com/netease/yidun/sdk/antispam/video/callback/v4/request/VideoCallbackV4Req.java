package com.netease.yidun.sdk.antispam.video.callback.v4.request;

import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackV4Resp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 点播回调接口请求 V4 版本
 */
@Getter
@Setter
public class VideoCallbackV4Req extends BizPostFormRequest<VideoCallbackV4Resp> {

    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public VideoCallbackV4Req() {
        productCode = "videoCommon";
        uriPattern = "/v4/video/callback/results";
        version = "v4.1";
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
    public Class<VideoCallbackV4Resp> getResponseClass() {
        return VideoCallbackV4Resp.class;
    }
}
