package com.netease.yidun.sdk.antispam.file.v2.callback;

import java.util.Collections;
import java.util.List;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.file.v2.callback.request.FileCallbackV2Request;
import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

public abstract class FileCallback
        extends AbstractCallbackHandler<FileCallbackV2Response.FileCallbackV2Resp> {

    public FileCallback() {
        super(null, new CallbackProfile(null, 1));
    }

    public FileCallback(CallbackProfile profile) {
        super(null, profile);
    }

    public FileCallback(AntispamRequester antispamRequester, CallbackProfile profile) {
        super(antispamRequester, profile);
    }

    @Override
    protected List<FileCallbackV2Response.FileCallbackV2Resp> requestCallback(String businessId,String requestId) {
        FileCallbackV2Request request = new FileCallbackV2Request();
        request.setYidunRequestId(requestId);
        FileCallbackV2Response callbackResponse = antispamRequester.getFileSolutionQueryClient()
                .callback(request);
        if (callbackResponse == null) {
            return Collections.emptyList();
        }
        return callbackResponse.getResult();
    }

}
