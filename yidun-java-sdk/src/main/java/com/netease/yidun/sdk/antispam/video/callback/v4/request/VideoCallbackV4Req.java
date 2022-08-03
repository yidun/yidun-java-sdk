package com.netease.yidun.sdk.antispam.video.callback.v4.request;

import java.util.Map;

import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackV4Resp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.UUIDUtils;

import lombok.Getter;
import lombok.Setter;

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
        version = "v4";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("yidunRequestId", getYidunRequestId());
        return params;
    }

    public String getYidunRequestId() {
        if (yidunRequestId == null) {
            yidunRequestId = UUIDUtils.randomUUID();
        }
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
