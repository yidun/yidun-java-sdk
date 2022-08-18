package com.netease.yidun.sdk.antispam.report.v1;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.report.v1.submit.request.ReportSubmitRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.submit.response.ReportCheckResponseV1;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 投诉举报client
 */
public class ReportCheckClient extends AntispamClient {

    public ReportCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public ReportCheckResponseV1 submit(ReportSubmitRequestV1 request) {
        return client.execute(request);
    }

    @Override
    protected String clientName() {
        return "ReportCheck";
    }
}
