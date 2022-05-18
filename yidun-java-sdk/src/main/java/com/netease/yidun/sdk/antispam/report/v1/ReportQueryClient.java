package com.netease.yidun.sdk.antispam.report.v1;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.report.v1.callback.request.ReportCallbackRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.callback.response.ReportCallbackResponseV1;
import com.netease.yidun.sdk.antispam.report.v1.query.request.ReportQueryRequestV1;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 投诉举报client
 */
public class ReportQueryClient extends AntispamClient {

    public ReportQueryClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public ReportCallbackResponseV1 callback(ReportCallbackRequestV1 request) {
        return client.execute(request);
    }

    public ReportCallbackResponseV1 query(ReportQueryRequestV1 request) {
        return client.execute(request);
    }
}
