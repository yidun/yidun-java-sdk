package com.netease.yidun.sdk.antispam.file.v2;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackResp;
import com.netease.yidun.sdk.antispam.file.v2.callback.request.FileActiveCallbackRequestV2;
import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;
import com.netease.yidun.sdk.core.utils.SignatureUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 主动回调解析结果demo
 */
@RestController
@RequestMapping("callback/receive")
public class FileActiveCallbackDemo {

    private static final String SECRET_KEY = "SECRET_KEY";

    @RequestMapping("file")
    public ActiveCallbackResp receiveCallback(HttpServletRequest request, FileActiveCallbackRequestV2 callbackResp) {
        try {
            if (!SignatureUtils.verifySignature(request.getParameterMap(), SECRET_KEY)) {
                return ActiveCallbackResp.fail(ActiveCallbackResp.SIGN_ERROR);
            }
            FileCallbackV2Response.FileCallbackV2Resp activeCallbackResult = callbackResp.parseFileCallbackData();
            // 根据需要解析字段，具体返回字段的说明，请参考官方接口文档中字段说明https://support.dun.163.com/documents/596426875864846336?docId=596429976038510592


            return ActiveCallbackResp.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ActiveCallbackResp.fail(ActiveCallbackResp.SERVER_ERROR);
        }
    }
}
