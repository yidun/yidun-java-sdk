package com.netease.yidun.sdk.irisk.v1.report;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * @author dongyisheng@corp.netease.com
 * @version 2023/11/6 16:33
 */
public class IRiskReportDataResponse extends CommonResponse {

    public IRiskReportDataResponse(int code, String msg) {
        super(code, msg);
    }

    @Override
    public String toString() {
        return "IRiskReportDataResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
