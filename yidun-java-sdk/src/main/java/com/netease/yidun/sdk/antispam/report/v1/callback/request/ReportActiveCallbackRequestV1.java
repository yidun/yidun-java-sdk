package com.netease.yidun.sdk.antispam.report.v1.callback.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.report.v1.callback.response.ReportCallbackResponseV1;

/**
 * 爬虫主动回调实体
 */
public class ReportActiveCallbackRequestV1 extends ActiveCallbackRequest {

    private static final long serialVersionUID = -2354090338754448434L;

    public ReportCallbackResponseV1.ReportCheckResult parseReportCallbackData() {
        return parseCallbackData(ReportCallbackResponseV1.ReportCheckResult.class);
    }

}
