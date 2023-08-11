package com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.request;

import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response.LiveWallSolutionCallbackV3Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import lombok.Data;

import java.util.Map;

@Data
public class LiveWallSolutionCallbackV3Req extends PostFormRequest<LiveWallSolutionCallbackV3Resp> {
    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public LiveWallSolutionCallbackV3Req() {
        productCode = "liveVideoSolutionCommon";
        uriPattern = "/v3/livewallsolution/callback/results";
        version = "v3.1";
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
    public Class<LiveWallSolutionCallbackV3Resp> getResponseClass() {
        return LiveWallSolutionCallbackV3Resp.class;
    }
}
