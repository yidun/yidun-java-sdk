
package com.netease.yidun.sdk.antispam.report.v1.callback.request;

import com.netease.yidun.sdk.antispam.report.v1.callback.response.ReportCallbackResponseV1;
import com.netease.yidun.sdk.core.request.PostFormRequest;

/**
 * 投诉举报回调请求
 */
public class ReportCallbackRequestV1 extends PostFormRequest<ReportCallbackResponseV1> {

    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public ReportCallbackRequestV1() {
        productCode = "report";
        uriPattern = "/v1/report/callback/results";
        version = "v1";
    }

    @Override
    public Class<ReportCallbackResponseV1> getResponseClass() {
        return ReportCallbackResponseV1.class;
    }

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }
}
