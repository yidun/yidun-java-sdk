package com.netease.yidun.sdk.antispam.stream.v1;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackResp;
import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.antispam.stream.v1.callback.AigcStreamActiveCallbackRequestV1;
import com.netease.yidun.sdk.core.utils.SignatureUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 主动回调解析结果demo
 */
@RestController
@RequestMapping("callback/receive")
public class AigcStreamActiveCallbackDemo {

    private static final String SECRET_KEY = "SECRET_KEY";

    @RequestMapping("/stream")
    public ActiveCallbackResp receiveCallback(HttpServletRequest request, AigcStreamActiveCallbackRequestV1 callbackResp) {
        try {
            if (!SignatureUtils.verifySignature(request.getParameterMap(), SECRET_KEY)) {
                return ActiveCallbackResp.fail(ActiveCallbackResp.SIGN_ERROR);
            }
            AigcStreamCheckResult aigcStreamCheckResult = callbackResp.parseAigcStreamCallbackData();
            // 根据需要解析字段，具体返回字段的说明，请参考官方接口文档中字段说明https://support.dun.163.com/documents/953823904240750592?docId=953843635578191872


            return ActiveCallbackResp.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ActiveCallbackResp.fail(ActiveCallbackResp.SERVER_ERROR);
        }
    }
}
