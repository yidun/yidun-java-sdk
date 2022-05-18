package com.netease.yidun.sdk.antispam.text.v5.callback;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.text.v5.callback.request.TextCallBackRequest;
import com.netease.yidun.sdk.antispam.text.v5.callback.response.TextCallBackResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.core.utils.AssertUtils;

import java.util.List;

public abstract class TextCallback extends AbstractCallbackHandler<TextCheckResult> {

    public TextCallback(CallbackProfile profile) {
        super(null, profile);
    }

    public TextCallback(String businessId) {
        super(null, businessId);
    }

    public TextCallback(AntispamRequester requester, String businessId) {
        super(requester, businessId);
    }

    public TextCallback(AntispamRequester requester, CallbackProfile profile) {
        super(requester, profile);
        AssertUtils.notBlank(profile.getBusinessId(), "businessId can not be null or empty");
    }

    @Override
    protected List<TextCheckResult> requestCallback(String businessId) {
        TextCallBackRequest request = new TextCallBackRequest();
        request.setBusinessId(businessId);
        TextCallBackResponse callbackResponse = antispamRequester.getTextCommonClient().callback(request);
        if (callbackResponse == null) {
            return null;
        }
        return callbackResponse.getResult();
    }
}
