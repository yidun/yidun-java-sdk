
package com.netease.yidun.sdk.antispam.video.callback.v4;

import java.util.List;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.video.callback.v4.request.VideoCallbackV4Req;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackV4Resp;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackV4Result;
import com.netease.yidun.sdk.core.utils.AssertUtils;

public abstract class VideoCallback extends AbstractCallbackHandler<VideoCallbackV4Result> {

    public VideoCallback(CallbackProfile profile) {
        super(null, profile);
    }

    public VideoCallback(String businessId) {
        super(null, businessId);
    }

    public VideoCallback(AntispamRequester requester, String businessId) {
        super(requester, businessId);
    }

    public VideoCallback(AntispamRequester requester, CallbackProfile profile) {
        super(requester, profile);
        AssertUtils.notBlank(profile.getBusinessId(), "businessId can not be null or empty");
    }

    @Override
    protected List<VideoCallbackV4Result> requestCallback(String businessId) {
        VideoCallbackV4Req request = new VideoCallbackV4Req();
        request.setBusinessId(businessId);
        VideoCallbackV4Resp callbackResponse = antispamRequester.getVideoCommonClient().callback(request);
        if (callbackResponse == null) {
            return null;
        }
        return callbackResponse.getResult();
    }

}
