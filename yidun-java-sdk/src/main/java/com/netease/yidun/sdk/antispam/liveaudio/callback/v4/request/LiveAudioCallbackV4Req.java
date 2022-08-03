package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.request;

import java.util.Map;

import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackV4Resp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.UUIDUtils;

import lombok.Data;

@Data
public class LiveAudioCallbackV4Req extends BizPostFormRequest<LiveAudioCallbackV4Resp> {

    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public LiveAudioCallbackV4Req() {
        productCode = "liveAudio";
        uriPattern = "/v4/liveaudio/callback/results";
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
    public Class<LiveAudioCallbackV4Resp> getResponseClass() {
        return LiveAudioCallbackV4Resp.class;
    }
}
