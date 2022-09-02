package com.netease.yidun.sdk.antispam.report.v1;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.report.v1.callback.ReportCallback;
import com.netease.yidun.sdk.antispam.report.v1.callback.request.ReportCallbackRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.callback.response.ReportCallbackResponseV1;
import com.netease.yidun.sdk.antispam.report.v1.query.request.ReportQueryRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.submit.request.ReportSubmitRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.submit.response.ReportCheckResponseV1;

/**
 * 投诉举报client
 */
public class ReportClient extends BaseClient {

    public ReportClient(AntispamRequester reportRequester) {
        super(reportRequester);
    }

    public ReportClient(AntispamRequester reportRequester, ReportCallback reportCallback) {
        super(reportRequester, reportCallback);
    }

    public ReportCheckResponseV1 submit(ReportSubmitRequestV1 request) {
        return requester.getReportCheckClient().submit(request);
    }

    public ReportCallbackResponseV1 callback(ReportCallbackRequestV1 request) {
        return requester.getReportQueryClient().callback(request);
    }

    public ReportCallbackResponseV1 query(ReportQueryRequestV1 request) {
        return requester.getReportQueryClient().query(request);
    }

}
