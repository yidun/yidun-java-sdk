package com.netease.yidun.sdk.antispam.meida.v2;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackResp;
import com.netease.yidun.sdk.antispam.file.v2.callback.request.FileActiveCallbackRequestV2;
import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;
import com.netease.yidun.sdk.antispam.media.v2.callback.request.MediaActiveCallbackRequestV2;
import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.core.utils.SignatureUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 主动回调解析结果demo
 */
@RestController
@RequestMapping("callback/receive")
public class MediaActiveCallbackDemo {

    private static final String SECRET_KEY = "SECRET_KEY";

    @RequestMapping("media")
    public ActiveCallbackResp receiveCallback(HttpServletRequest request, MediaActiveCallbackRequestV2 callbackResp) {
        try {
            if (!SignatureUtils.verifySignature(request.getParameterMap(), SECRET_KEY)) {
                return ActiveCallbackResp.fail(ActiveCallbackResp.SIGN_ERROR);
            }
            MediaCallbackResponseV2.MediaCheckResult activeCallbackResult = callbackResp.parseMediaCallbackData();
            // 根据需要解析字段，具体返回字段的说明，请参考官方接口文档中字段说明https://support.dun.163.com/documents/599750646047514624?docId=599764266958336000


            return ActiveCallbackResp.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ActiveCallbackResp.fail(ActiveCallbackResp.SERVER_ERROR);
        }
    }
}
