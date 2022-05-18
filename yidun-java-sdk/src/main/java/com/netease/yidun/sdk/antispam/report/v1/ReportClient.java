package com.netease.yidun.sdk.antispam.report.v1;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.report.v1.callback.ReportCallback;
import com.netease.yidun.sdk.antispam.report.v1.callback.request.ReportCallbackRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.callback.response.ReportCallbackResponseV1;
import com.netease.yidun.sdk.antispam.report.v1.query.request.ReportQueryRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.submit.request.ReportSubmitRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.submit.response.ReportCheckResponseV1;
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 投诉举报client
 */
public class ReportClient {

    private AntispamRequester reportRequester;

    public ReportClient(AntispamRequester reportRequester) {
        AssertUtils.notNull(reportRequester, "reportRequester can not be null");
        this.reportRequester = reportRequester;
    }

    public ReportClient(AntispamRequester reportRequester, ReportCallback reportCallback) {
        AssertUtils.notNull(reportRequester, "reportRequester can not be null");

        this.reportRequester = reportRequester;
        if (reportCallback != null) {
            if (reportCallback.getAntispamRequester() == null) {
                reportCallback.setAntispamRequester(reportRequester);
            }
            reportCallback.start();
        }
    }

    public ReportCheckResponseV1 submit(ReportSubmitRequestV1 request) {
        return reportRequester.getReportCheckClient().submit(request);
    }

    public ReportCallbackResponseV1 callback(ReportCallbackRequestV1 request) {
        return reportRequester.getReportQueryClient().callback(request);
    }

    public ReportCallbackResponseV1 query(ReportQueryRequestV1 request) {
        return reportRequester.getReportQueryClient().query(request);
    }

}
