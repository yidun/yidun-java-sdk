package com.netease.yidun.sdk.antispam.digitalbook.v2;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackResp;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.request.DigitalBookActiveCallbackRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response.DigitalBookCallbackResponseV2;
import com.netease.yidun.sdk.core.utils.SignatureUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 主动回调解析结果demo
 */
@RestController
@RequestMapping("callback/receive")
public class DigitalBookActiveCallbackDemo {

    private static final String SECRET_KEY = "SECRET_KEY";

    @RequestMapping("digitalBook")
    public ActiveCallbackResp receiveCallback(HttpServletRequest request, DigitalBookActiveCallbackRequestV2 callbackResp) {
        try {
            if (!SignatureUtils.verifySignature(request.getParameterMap(), SECRET_KEY)) {
                return ActiveCallbackResp.fail(ActiveCallbackResp.SIGN_ERROR);
            }
            DigitalBookCallbackResponseV2.DigitalBookCheckResult activeCallbackResult = callbackResp.parseDigitalBookCallbackData();
            // 根据需要解析字段，具体返回字段的说明，请参考官方接口文档中字段说明https://support.dun.163.com/documents/601492044329328640?docId=601495324846338048


            return ActiveCallbackResp.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ActiveCallbackResp.fail(ActiveCallbackResp.SERVER_ERROR);
        }
    }
}
