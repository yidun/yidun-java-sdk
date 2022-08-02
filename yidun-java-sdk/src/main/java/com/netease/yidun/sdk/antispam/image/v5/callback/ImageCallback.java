package com.netease.yidun.sdk.antispam.image.v5.callback;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.image.v5.callback.request.ImageV5CallbackRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5Result;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.core.utils.AssertUtils;

import java.util.List;

public abstract class ImageCallback extends AbstractCallbackHandler<ImageV5Result> {

    public ImageCallback(CallbackProfile profile) {
        this(null, profile);
    }

    public ImageCallback(String businessId) {
        this(null, new CallbackProfile(businessId));
    }

    public ImageCallback(AntispamRequester imageRequester, String businessId) {
        this(imageRequester, new CallbackProfile(businessId));
    }

    public ImageCallback(AntispamRequester imageRequester, CallbackProfile profile) {
        super(imageRequester, profile);
        AssertUtils.notBlank(profile.getBusinessId(), "businessId can not be null or empty");
    }

    @Override
    protected List<ImageV5Result> requestCallback(String businessId, String requestId) {
        ImageV5CallbackRequest request = new ImageV5CallbackRequest();
        request.setBusinessId(businessId);
        request.setYidunRequestId(requestId);
        ImageV5CheckResponse callbackResponse = antispamRequester.getImageCommonClient().callback(request);
        if (callbackResponse == null) {
            return null;
        }
        return callbackResponse.getResult();
    }

}
