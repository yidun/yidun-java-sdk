package com.netease.yidun.sdk.antispam.report.v1.callback;

import java.util.Collections;
import java.util.List;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.report.v1.callback.request.ReportCallbackRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.callback.response.ReportCallbackResponseV1;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

public abstract class ReportCallback extends AbstractCallbackHandler<ReportCallbackResponseV1.ReportCheckResult> {

    public ReportCallback() {
        super(null, new CallbackProfile(null, 1));
    }

    public ReportCallback(CallbackProfile profile) {
        super(null, profile);
    }

    public ReportCallback(AntispamRequester antispamRequester, CallbackProfile profile) {
        super(antispamRequester, profile);
    }

    @Override
    protected List<ReportCallbackResponseV1.ReportCheckResult> requestCallback(String businessId) {
        ReportCallbackRequestV1 request = new ReportCallbackRequestV1();
        ReportCallbackResponseV1 callbackResponse = antispamRequester.getReportQueryClient().callback(request);
        if (callbackResponse == null) {
            return Collections.emptyList();
        }
        return callbackResponse.getResult();
    }

}
