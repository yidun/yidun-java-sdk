package com.netease.yidun.sdk.antispam.report.v1;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackResp;
import com.netease.yidun.sdk.antispam.report.v1.callback.request.ReportActiveCallbackRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.callback.response.ReportCallbackResponseV1;
import com.netease.yidun.sdk.core.utils.SignatureUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 主动回调解析结果demo
 */
@RestController
@RequestMapping("callback/receive")
public class ReportActiveCallbackDemo {

    private static final String SECRET_KEY = "SECRET_KEY";

    @RequestMapping("report")
    public ActiveCallbackResp receiveCallback(HttpServletRequest request, ReportActiveCallbackRequestV1 callbackResp) {
        try {
            if (!SignatureUtils.verifySignature(request.getParameterMap(), SECRET_KEY)) {
                return ActiveCallbackResp.fail(ActiveCallbackResp.SIGN_ERROR);
            }
            ReportCallbackResponseV1.ReportCheckResult activeCallbackResult = callbackResp.parseReportCallbackData();
            // 根据需要解析字段，具体返回字段的说明，请参考官方接口文档中字段说明https://support.dun.163.com/documents/593963923786141696?docId=594019656180834304


            return ActiveCallbackResp.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ActiveCallbackResp.fail(ActiveCallbackResp.SERVER_ERROR);
        }
    }
}
