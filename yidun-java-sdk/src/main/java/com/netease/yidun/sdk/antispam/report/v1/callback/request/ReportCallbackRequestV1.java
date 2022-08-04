
package com.netease.yidun.sdk.antispam.report.v1.callback.request;

import com.netease.yidun.sdk.antispam.report.v1.callback.response.ReportCallbackResponseV1;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import java.util.Map;

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

    /**
     * 获取具体业务中特有的需要参与签名计算的参数
     *
     * @return 返回需要参与签名的参数
     */
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("yidunRequestId", getYidunRequestId());
        return params;
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
