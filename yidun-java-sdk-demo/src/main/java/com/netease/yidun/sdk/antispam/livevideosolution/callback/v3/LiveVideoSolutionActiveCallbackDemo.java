package com.netease.yidun.sdk.antispam.livevideosolution.callback.v3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackResp;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.request.LiveWallSolutionV3ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response.LiveVideoSolutionCallbackV3Result;
import com.netease.yidun.sdk.core.utils.SignatureUtils;

/**
 * 主动回调解析结果demo
 */
@RestController
@RequestMapping("callback/receive")
public class LiveVideoSolutionActiveCallbackDemo {

    private static final String SECRET_KEY = "SECRET_KEY";

    @RequestMapping("liveVideoSolution")
    public ActiveCallbackResp receiveCallback(HttpServletRequest request,
            LiveWallSolutionV3ActiveCallbackRequest callbackResp) {
        try {
            if (!SignatureUtils.verifySignature(request.getParameterMap(), SECRET_KEY)) {
                return ActiveCallbackResp.fail(ActiveCallbackResp.SIGN_ERROR);
            }
            LiveVideoSolutionCallbackV3Result liveVideoSolutionCallbackV3Result = callbackResp.parseCallbackData();
            // 根据需要解析字段，具体返回字段的说明，请参考官方接口文档中字段说明
            // https://support.dun.163.com/documents/594247746924453888?docId=600827764056403968

            return ActiveCallbackResp.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ActiveCallbackResp.fail(ActiveCallbackResp.SERVER_ERROR);
        }
    }
}
